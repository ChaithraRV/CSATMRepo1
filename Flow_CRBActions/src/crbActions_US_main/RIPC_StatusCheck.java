package crbActions_US_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRBActions_US.Step01_CreateRequest;
import CRBActions_US.Step02_AddResponse;
import CRBActions_US.Step03_Finalize;
import CRBActions_US.Step05_RIPC_ResponseStatus;

import org.apache.log4j.Logger;

import lib.Excel;


public class RIPC_StatusCheck
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
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 1, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 1, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 1, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	
            driver.get(url1);    
	  }	
		
		 // test to Login to the application as RIPC
		  @Test(priority=0)
		  public void RIPC_Login() 
		  {
			  
			  Step05_RIPC_ResponseStatus statuschk = new  Step05_RIPC_ResponseStatus(driver);
			  statuschk.status();
			  statuschk.status_verf();
			  
}
		  // Test to add response
	/*	 @Test(priority=1)
		  public void add_response()
		  {
		     driver.get(url2);
			  
			  log.debug("Inside open_CSA_Tab() function");
			  
			  Step02_AddResponse addresp = new Step02_AddResponse(driver); 
			  
			  for (int i=1; i<4; i++)
			  {
				  if(i==1)
				  {
				 addresp.login();
				  addresp.FillRespdetails("fResp"+i , "US" , "lResp"+i, "40");
				  }  
				  else if(i==2)
				  {
				  //addresp.login();
				  addresp.FillRespdetails("fResp"+i , "US" , "lResp"+i, "35");}
			  else
			  {
				  //addresp.login();
				  addresp.FillRespdetails("fResp"+i , "US" , "lResp"+i, "38");
				  addresp.Submit();
			  }
			  }
			
		  }
		*/  
		 //Test for Skill Request page
	/*	  @Test(priority=0)
		  public void Finalize()
		  {
			 
			  Step03_Finalize respfinal = new Step03_Finalize(driver);
			  respfinal.loginAndOpenReq();
			  respfinal.FinaliseSubmit();
			  
				  
		  }*/
		  
		
}
