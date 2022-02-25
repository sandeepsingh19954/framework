package Script;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(ListenersToday.ListenersLinks.class)
public class links  {


	static WebDriver driver;



	@Test(priority=1)
	public void addsum() throws AWTException{

		System.out.println("testing the app");
		Assert.assertEquals(true,true);
		
		Set<String> values = new HashSet<String>();//not in order
		
		values.add("Selenium");
		values.add("QTP");
		values.add("russia");
		values.add("Ukraine");
		
		
		ArrayList<String> list = new ArrayList<String>(values);
		
	//	System.out.println(list.get(3));
		
	//	System.out.println(values);
		
		for(String e :values){
			
		//	System.out.println("----"+e);
			
		}
		String s = "sandeepsingh";
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();// maintains order 
		
		for(int i=0;i<s.length();i++){
	         set.add(s.charAt(i));
	
		}
		
		String str="";
for(Character e :set){
			
	//	System.out.print(e);
		
		str = str +e;
			
		}

System.out.println(str);


		
		
		//Robot robot = new Robot();
		
		
		

	}

	@Test(priority=2)
	public  void repeatremoval(){

		String s ="subtaraction";
	//	String Str="";
		
		
			char[] charc = s.toCharArray();
			
			LinkedHashSet<Character> set = new LinkedHashSet<Character>();
			for(char c : charc){
				
				set.add(c);
			}
     StringBuilder sb = new StringBuilder();
     for(Character ch : set){
    	 
    	 sb.append(ch);
     }
     
     System.out.println(sb.toString());
		
		
		


		int arr[] = {22,22,23,33,11,6,33,-1,5,33};

		Arrays.sort(arr);
		
	for (int i=arr.length-1;i>0;i--){
		
		if(arr[i]-arr[i-1]!=0){
			
			System.out.println(arr[i-1]);
			break;
		}
		
		
	}

	

	}


}
