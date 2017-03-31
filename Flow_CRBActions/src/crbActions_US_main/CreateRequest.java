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

import org.apache.log4j.Logger;

import lib.Excel;


public class CreateRequest
{
	// TestNG logger
	
		public static Logger log = Logger.getLogger("TnM");
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		public String sheet="Login"; 
		public String url;
		public String id;
		public String paswd;
		
		
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
			  
			  Step01_CreateRequest login = new Step01_CreateRequest(driver);
			  login.login();
		  }
			@Test(priority=1)
			  public void Create_Req() 
			  {
				  
				  Step01_CreateRequest createreq = new Step01_CreateRequest(driver);
				  createreq.Create_New_Request();
			  }
			@Test(priority=2)
			  public void skill_Req() 
			  {
				  
				  Step01_CreateRequest skillreq = new Step01_CreateRequest(driver);
				  skillreq.Skill_Request();
			  }
			@Test(priority=3)
			  public void select_Req() 
			  {
				  
				  Step01_CreateRequest selectreq = new Step01_CreateRequest(driver);
				  selectreq.Select_Requestor();
			  }

			@Test(priority=4)
			  public void select_jrss() 
			  {
				  
				  Step01_CreateRequest selectreq = new Step01_CreateRequest(driver);
				  selectreq.Select_JRSS();
			  }

			@Test(priority=5)
			  public void req_detail() 
			  {
				  
				  Step01_CreateRequest reqdetail = new Step01_CreateRequest(driver);
				  reqdetail.Request_detailpage();
			  }
			@Test(priority=6)
			  public void skill_loc() 
			  {
				  
				  Step01_CreateRequest skillloc = new Step01_CreateRequest(driver);
				  skillloc.Skill_detailLocationpage();
			  }
			@Test(priority=7)
			  public void alert_check() 
			  {
				  
				  Step01_CreateRequest alertchk = new Step01_CreateRequest(driver);
				  alertchk.isAlertPresent();
			  }
			@Test(priority=8)
			  public void skill_price() 
			  {
				  
				  Step01_CreateRequest skillprice = new Step01_CreateRequest(driver);
				  skillprice.Skill_detail_skillpricepage();
			  }
			@Test(priority=9)
			  public void supp() 
			  {
				  
				  Step01_CreateRequest supplier = new Step01_CreateRequest(driver);
				  supplier.SupplierSelectionPage();
			  }
			@Test(priority=10)
			  public void req_data() 
			  {
				  
				  Step01_CreateRequest reqdata = new Step01_CreateRequest(driver);
				  reqdata.Reqdata();
			  }
			  
			  
			  
		
		  }
	    		

