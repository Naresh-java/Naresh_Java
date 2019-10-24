package sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class SikuliTest {
	@Test
	public void LoginToGoogle() {
		Screen screen = new Screen();
		Pattern signIn = new Pattern("D:\\Sikuli_Images\\SignIn.PNG");
		Pattern EnterGmail = new Pattern("D:\\Sikuli_Images\\Enter_Gmail.PNG");
		Pattern EnterPass = new Pattern("D:\\Sikuli_Images\\Enter_Gmail.PNG");
		Pattern next = new Pattern("D:\\Sikuli_Images\\Next.PNG");
		Pattern options = new Pattern("D:\\Sikuli_Images\\Options.PNG");
		Pattern youtube = new Pattern("D:\\Sikuli_Images\\Youtube.PNG");
		WebDriver driver = new ChromeDriver();
		driver.get("https:\\google.com");
		try {
			Thread.sleep(3000);
			screen.click(signIn);
			Thread.sleep(3000);
			screen.type(EnterGmail, "mamellapallinaresh@gmail.com");
			Thread.sleep(3000);
			screen.click(next);
			Thread.sleep(3000);
			screen.type(EnterPass, "Naresh@9491151062");
			Thread.sleep(3000);
			screen.click(next);
			Thread.sleep(3000);
			screen.click(options);
			Thread.sleep(3000);
			screen.click(youtube);	
		
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
}
