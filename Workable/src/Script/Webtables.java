package Script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Logs.SLog;

public class Webtables {

	WebDriver driver;
	int x=x=0;
	@BeforeMethod
	public void launch(){

		System.setProperty("webdriver.chrome.driver","D:\\eclipse\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		x=x+1;
	}

	@Test
	public void WebTables(){

		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='customers']//tr"));

		System.out.println("No of rows---"+(rows.size()-1));

		List<WebElement> cols = driver.findElements(By.xpath("//*[@id='customers']//tr[2]/td"));

		System.out.println("No of cols---"+(cols.size()));

		System.out.println("Total number of elements---"+(rows.size()-1)*(cols.size()));
		
		

		for(int row=2;row<=rows.size();row++){

			for(int col=1;col<=cols.size();col++){

				if("Austria".equals(driver.findElement(By.xpath("//*[@id='customers']//tr["+row+"]/td["+col+"]")).getText())){

					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
					jsExecutor.executeScript("arguments[0].style.border='2px solid red'",driver.findElement(By.xpath("//*[@id='customers']//tr["+row+"]/td["+col+"]")));
				}
			}
		}
		x=x+1;
	}
	
	
	
}
