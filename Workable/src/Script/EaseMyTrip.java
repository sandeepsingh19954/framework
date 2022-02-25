package Script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import CustomLis.CustomListner;


public class EaseMyTrip extends CustomListner {

	@BeforeMethod
	public void Openurl(){

		readPropertiesFile();
		
		
	}

	//	@Test(priority =1)
	public void FromSource(){

		//readPropertiesFile();

		driver.findElement(By.id("FromSector_show")).click();

		List<WebElement> From = driver.findElements(By.xpath("//span[@class='ct']"));

		System.out.println(From.size());


		for(int i=0;i<From.size();i++)
		{

			System.out.println(From.get(i).getText());

			if("Bangalore(BLR)".equals(From.get(i).getText()))
			{
				From.get(i).click();

				break;

			}
		}
	}

	//	@Test(priority =2)
	public void StartDate() throws InterruptedException{

		getProperties();


		ddate(prop.getProperty("monthSelect"),"10");
	}

	public String[] getMonthYear(String monthYear){

		return monthYear.split(" ");
	}


	public  void ddate(String expmonth, String expdate) throws InterruptedException{

		driver.findElement(By.id("ddate")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='month']/div[2]")));

		//div[@class='month']/div[2]
		//div[@class='month3']/img

		String monthYear = driver.findElement(By.xpath("//div[@class='month']/div[2]")).getText();


		while(!(getMonthYear(monthYear)[0].equals(expmonth))&&(getMonthYear(monthYear)[1].equals("2022"))){

			Thread.sleep(2000);

			System.out.println(driver.findElement(By.xpath("//div[@class='month']/div[2]")).getText());

			driver.findElement(By.xpath("//div[@class='month3']/img")).click();
			monthYear = driver.findElement(By.xpath("//div[@class='month']/div[2]")).getText();


		}


		driver.findElement(By.xpath("//li[text()='"+expdate+"']")).click();
		Thread.sleep(2000);



		System.out.println("Test");
	}
	//	@Test(priority =3)
	public void AddTravellers() throws InterruptedException{

		travellers(3);

	}

	public void travellers(int childCount) throws InterruptedException{

		driver.findElement(By.xpath("(//span[@class='drpNoTrv'])[1]")).click();

		Thread.sleep(2000);

		for(int i=0;i<childCount;i++){

			driver.findElement(By.xpath("(//input[@class='plus_boxChd'])[1]")).click();

		}

		Thread.sleep(2000);

		//*[contains(text(),'Done')])[1]

		driver.findElement(By.xpath("(//*[contains(text(),'Done')])[1]")).click();
	}
	//@Test(priority=4)
	public void travellClass() throws InterruptedException{

		driver.findElement(By.xpath("//*[@class='dropbtn_n10']")).click();

		List<WebElement> types =driver.findElements(By.className("cont_flt"));

		for(int i=0;i<types.size();i++){

			if("Business".equals(types.get(i).getText())){

				System.out.println(types.get(i).getText());

				types.get(i).click();

				driver.findElement(By.xpath("(//*[contains(text(),'Done')])[2]")).click();

				break;
			}
		}

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='s_col_v4 ripplen']/input")).click();
	}

	@DataProvider(name = "dataProvider")

	public Object[][] dpMethod(){

		return new Object[][]{{"Avinash","Akash","avinash99"},{"Sandeep","Aman", "akash10911"}};
	}	


	@Test(dataProvider="dataProvider")
	public void AccGmail(String firstName, String seName, String userName) throws InterruptedException{

		System.out.println(driver.findElement(By.xpath("(//span[@class='laptop-desktop-only'])[1]")).getCssValue("background-color"));
		
		//Actions action = new Actions(driver);
		
	//	action.doubleClick(driver.findElement(By.xpath("(//span[@class='laptop-desktop-only'])[1]"))).perform();
	//	action.contextClick(driver.findElement(By.xpath("(//span[@class='laptop-desktop-only'])[1]"))).perform();
		
	

	driver.findElement(By.xpath("(//span[@class='laptop-desktop-only'])[1]")).click();
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		

		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(seName);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);


	}
//	@Test
	public void ExcelAccGmail() throws InterruptedException, Exception{
		

		System.out.println(driver.findElement(By.xpath("(//span[@class='laptop-desktop-only'])[1]")).getCssValue("background-color"));

		driver.findElement(By.xpath("(//span[@class='laptop-desktop-only'])[1]")).click();

		driver.findElement(By.id("firstName")).sendKeys(Excel(0,0));
		driver.findElement(By.id("lastName")).sendKeys("Singh");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("sandeep19878");
		
	//	WriteExcel(0,0,driver.getTitle());

Assert.assertEquals("Create your Google Accoun",driver.getTitle());
	

	}
	
//	@Parameters({"valueofPar","par2"})
	@Test
	public void parameterTest(String valueofPar, String par2){
		
System.out.println("Parameter ="+valueofPar);	
System.out.println("Paramete ="+par2);	
	}
   
}


