package Script;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ReadPDF {
	@SuppressWarnings("deprecation")
	@Test(priority=4)
	public void TestPDF() throws IOException{
		
		URL pdfUrl = new URL("file:///C:/Users/SA953418/Downloads/ELSS_FY%202021-22.pdf");
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		String pdfcontent = new PDFTextStripper().getText(doc);
		//System.out.println(pdfcontent);
		
	System.out.println(pdfcontent.contains("80c"));		
	}
	
	public void palindrome(){
		
		String s = "madam";
		String rs ="";
		for (int i=(s.length()-1);i>=0;i--){
			
			rs = rs + s.charAt(i);
			
		}
		
		if(s.equals(s)){
			
			System.out.println("done");
			
		}
		
		else{
			
			System.out.println("not");
		}
		
	}
	
    public void NumberPalindrome(){
    	
    	int num =3553;
    	int rn =0;
    	int on =num;
    	
    	while(num!=0){
    	 int rem = num%10;
    	 rn = rn*10 +rem;
    	  num = num/10;
    	 
    	}
    	if(on==rn){
    		
    		System.out.println("done");
    	}
    	
    	
    	
    }
}
