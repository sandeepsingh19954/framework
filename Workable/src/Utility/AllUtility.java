package Utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import ExcelReaderUtility.ExcelReader;

public class AllUtility extends ExcelReader {

	public WebDriver driver;

	public void OpenBrowser(String browserName, String link){
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\eclipse\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\SA953418\\Downloads\\edgedriver_win64\\msedgedriver.exe");

			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(link);

	}
	public void CaptureScreenshot(String Name)
	{
		TakesScreenshot ts =   (TakesScreenshot)driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src,new File("D:\\eclipse\\chromedriver_win32\\ScreenShot\\"+Name+".png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void ErrorScreenshot() {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src,new File("D:\\eclipse\\chromedriver_win32\\ScreenShot\\Error.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void StringUpperCase(){
		
		
		
		String Str = "How to12  pRint upPer Case";
		
		int upperCase =0;
		int lowerCase =0;
		int others=0;
		double upperCasePercentage=0;
		
		for(int i=0;i<Str.length();i++){
			 
			
			if(Character.isUpperCase(Str.charAt(i))){
				
				upperCase++;
				
			}
			
			else if(Character.isDigit(Str.charAt(i))){
				
				lowerCase++;
			}
			
			else {
				
				others++;
			}
			
		}
		
		System.out.println(upperCase);
		System.out.println(lowerCase);
		System.out.println(others);
		System.out.println(upperCasePercentage =(upperCase*100)/Str.length());
		
	}

}

