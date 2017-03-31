package crbActions_GB_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRBActions_GB.Step03_Finalize_GB;


import org.apache.log4j.Logger;

import lib.Excel;


public class FinalizeResponse_GB
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
		ProfilesIni ini = new ProfilesIni();
    	FirefoxProfile profile = ini.getProfile("default");
    	//WebDriver driver =  new FirefoxDriver(profile);
			
    	driver = new FirefoxDriver(profile);
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 6, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 6, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 6, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	
             
        driver.get(url1);    
	  }	
		
		
        //Test for Skill Request page
		  @Test(priority=0)
		  public void Login()
		  {
			 
			  Step03_Finalize_GB login = new Step03_Finalize_GB(driver);
			  login.loginAndOpenReq();
			  
			  
				  
		  }
		  @Test(priority=0)
		  public void Finalize()
		  {
			 
			  Step03_Finalize_GB respfinal = new Step03_Finalize_GB(driver);
			   respfinal.FinaliseSubmit();
			  
				  
		  }
		
}
