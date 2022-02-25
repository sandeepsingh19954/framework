package Configu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import Utility.AllUtility;

public class Property extends AllUtility{

	public Properties prop = new Properties();

	public void readPropertiesFile(){

		getProperties();


		OpenBrowser(prop.getProperty("browser"),prop.getProperty("url"));

		CaptureScreenshot("str1");


	}



	public void getProperties(){


		try {
			InputStream input = new FileInputStream("D:\\eclipse\\chromedriver_win32\\config.properties");
			prop.load(input);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
