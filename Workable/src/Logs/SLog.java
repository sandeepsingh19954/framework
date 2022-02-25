/* Copyright (C) 2018  Wipro Technologies - All Rights Reserved
 * Date    : August 2018
 * Version : 1.2
 * Author  : Wipro Technologies
 */

package Logs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Base64;

public class SLog {

	final String PropFileLocation = "C:\\Holmes\\account.properties";
	final String BotID = "Partner";
	final String AutomationTool = "Selenium";
	final char[] key = {'P','T','J','b','F','Y','y','9','k','u','n','q','c','x','T','m','t','i','m','o','7','n','w','X','h','m','f','G','5','h','i','j','k','3','n','y','w','l','e','m'};
	
	 public void createWDBLog(int Designed, int Executed) 
	 {
	        try 
	        {
	    		InputStream PropFile = new FileInputStream(PropFileLocation);
	    		Properties prop = new Properties();
	    		prop.load(PropFile);
	    		String CustName = prop.getProperty("GroupCustomerName");
	    		String ProjectID = prop.getProperty("ProjectID");
	    		String LogFolder = prop.getProperty("LogFolder");
	    		PropFile.close();

				//Create folder
	        	File folder =new File(LogFolder);
	        	folder.mkdirs();
	        	
	        	//Create File
	        	String filename = CustName + "#" + InetAddress.getLocalHost().getHostName() + "#" + "Testing" + "#" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + ".log";
				File file = new File(LogFolder + "\\" +  filename);
				if (!file.createNewFile())
					System.out.print("Error! Unable to create log file");

				//Encrypt the filename
				StringBuilder encrypted = new StringBuilder();
				for(int i = 0; i < filename.length(); i++) 
					encrypted.append((char) (filename.charAt(i) ^ key[i % key.length]));
		 		
				//Encode to Base64
				byte[] encodedBytes = Base64.getEncoder().encode(encrypted.toString().getBytes());

				JSONObject mainObj = new JSONObject();
				mainObj.put("Filename", new String(encodedBytes));
						        
		        //Add WDB metrics
		        JSONObject jo = new JSONObject();
		        jo.put("Project Code", ProjectID);
		        jo.put("BOT Id", BotID);
		        jo.put("Automation Tool", AutomationTool);
		        jo.put("Test Scripts Designed", Designed);
		        jo.put("Test Scripts Executed", Executed);  

		        JSONArray list = new JSONArray();
		        list.add(jo);
		        
		        mainObj.put("Metrics", list);
		        
				FileWriter log = new FileWriter(file);
				log.write(mainObj.toJSONString());
				log.close();	
			} 
	        catch (Exception e) 
	        {
				e.printStackTrace();
			}
	    }
	
	public static void main(String[] args) 
	{
		SLog log = new SLog();

		// 1st parameter is number of Test Scripts Designed, and 2nd parameter is number of Test Scripts Executed
		log.createWDBLog(20,10); 

	}
}
