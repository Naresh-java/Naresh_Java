package autoit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.tinyupload.com");
		driver.findElement(By.name("uploaded_file")).click();;
		try {
			Runtime.getRuntime().exec("D:\\AutoitScripts\\FileUploadScript.exe");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("file_description")).sendKeys("hariNath doodi");
		driver.findElement(By.name("sessionid")).click();

	}
}
