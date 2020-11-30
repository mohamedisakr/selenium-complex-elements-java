package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownList {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://wikipedia.org/");
		try {
//			List<WebElement> theOptions = driver.findElements(By.tagName("option"));
			WebElement dropdown = driver.findElement(By.id("searchLanguage"));
			Select select = new Select(dropdown) ;
			List<WebElement> theOptions = select.getOptions();
			System.out.println("The # of options is: " + theOptions.size());
			for (WebElement option : theOptions) {
				System.out.println(option.getText() + " " + option.getAttribute("value"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
