package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllLinks {
	private static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://wikipedia.org/");
		try {
			List<WebElement> theLinks = driver.findElements(By.className("other-project"));
			System.out.println("The # of links is: " + theLinks.size());
			for (WebElement link : theLinks) {
				System.out.println(link.getText() + " " + link.getAttribute("href"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
