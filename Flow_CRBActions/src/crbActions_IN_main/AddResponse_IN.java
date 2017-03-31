package crbActions_IN_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRBActions_GB.Step02_AddResponse_GB;
import CRBActions_IN.Step02_AddResponse_IN;

import org.apache.log4j.Logger;

import lib.Excel;


public class AddResponse_IN
{
	// TestNG logger
	
		public static Logger log = Logger.getLogger("TnM");
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		public String sheet="Login"; 
		public String url;
		public String id;
		public String paswd;
		public String id_green;
		public String paswd_green;
		public String url_green;
		public String url2;
		
		public WebDriver driver;
		
		
		@BeforeTest
	    public void setup()
		{
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	    	driver = new ChromeDriver();
			
    	
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 14, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 14, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 14, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	
              
        driver.get(url1);    
	  }	
		
		 

		  // Test to add response
	   @Test(priority=0)
		  public void add_response()
		  {
		       log.debug("Inside open_CSA_Tab() function");
			  
			  Step02_AddResponse_IN addresp = new Step02_AddResponse_IN(driver); 
			  
			  for (int i=1; i<4; i++)
			  {
				  if(i==1)
				  {
				 addresp.login();
				  addresp.FillRespdetails("fResp"+i , "IN" , "lResp"+i,"GID"+i,"RefNum"+i, "10000");
				  }  
				  else if(i==2)
				  {
				  //addresp.login();
				  addresp.FillRespdetails("fResp"+i , "IN" , "lResp"+i,"GID"+i,"RefNum"+i, "20000");
				  }
			  else
			  {
				  //addresp.login();
				  addresp.FillRespdetails("fResp"+i , "IN" , "lResp"+i,"GID"+i,"RefNum"+i, "22000");
				  addresp.Submit();
			  }
			  }
		  }
}
		
		  
		

