package crbActions_GB_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRBActions_GB.Step04_CRB_Auth_GB;
import CRBActions_GB.Step04_CRB_Reject_GB;
import CRBActions_GB.Step04_CRB_Return_GB;

import org.apache.log4j.Logger;

import lib.Excel;


public class CRB_Actions_ReturnGB
{
	// TestNG logger
	
		public static Logger log = Logger.getLogger("TnM");
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		public String sheet="Login"; 
		public String url;
		public String id;
		public String paswd;
		
		WebDriver driver;
		
		
		@BeforeTest
	    public void setup()
		{
		ProfilesIni ini = new ProfilesIni();
    	FirefoxProfile profile = ini.getProfile("default");
    	//WebDriver driver =  new FirefoxDriver(profile);
			
    	driver = new FirefoxDriver(profile);
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 9, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 9, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 9, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
        
        driver.get(url1);    
	  }	
		
		 // test to Login to the application as RIPC
		  
		  @Test(priority=0)
		  public void CRB_Wlcmpage() 
		  {
			  
			  Step04_CRB_Return_GB login = new Step04_CRB_Return_GB(driver);
			  login.login();
		  }
		  @Test(priority=1)
		  public void CRB_return() 
		  {
			  
			  Step04_CRB_Return_GB crbretrn = new Step04_CRB_Return_GB(driver);
			  crbretrn.CRB_Return();
		  }
			  
			 
		  
}
		  
	
