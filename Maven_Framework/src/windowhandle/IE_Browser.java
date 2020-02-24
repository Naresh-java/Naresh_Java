package windowhandle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IE_Browser {
	public static void main(String[] args) {
		InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
		internetExplorerOptions.ignoreZoomSettings();
		internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
		internetExplorerOptions.requireWindowFocus();

		WebDriver driver = new InternetExplorerDriver(internetExplorerOptions);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.get("http://www.google.co.uk");

		// Getting the main window handle

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String mainWindowHandle = driver.getWindowHandle();

		WebElement link = driver.findElement(By.tagName("a"));

		new Actions(driver).keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();

		new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);

		// Switching to the child window
		Set<String> allHandles = driver.getWindowHandles();
		for (String handle : allHandles) {
			String title = driver.switchTo().window(handle).getTitle();

			System.out.println(title);

			if (title.equals("About | Google")) {
				System.out.println("Actually switching");
				driver.switchTo().window(handle);
				break;
			}
		}

		// Closing the child window
		driver.close();

		// This line not getting executed and throws the Time out Exception
		driver.switchTo().window(mainWindowHandle);

		new Actions(driver).keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();

	}
}
