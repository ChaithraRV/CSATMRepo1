package Testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.FindBy;
import Testcase.Page1_Login ;



public class TestURL {


	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;

	WebDriver driver ;



      @BeforeTest
      public void TestBefore() {

    	  ProfilesIni ini = new ProfilesIni();
    		FirefoxProfile profile = ini.getProfile("default");
    		//WebDriver driver =  new FirefoxDriver(profile);


    		driver = new FirefoxDriver(profile);

    		//driver = new FirefoxDriver();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    		id = "csatestus1@c25a0161.toronto.ca.ibm.com" ;
    		paswd = "bugs2test" ;
    		url = "pesproxy051.boulder.ibm.com/procurement/csa/common/enUS/index.html" ;

    		String url1 = "https://"  +  id + ":" + paswd + "@" + url; 

    	    driver.get(url1); 
      }  

   // test to Login to the application as RIPC
   	  @Test(priority=0)
   	  public void RIPC_Login() 
   	  {

   		 Page1_Login login = new Page1_Login (driver);
		  login.login();

   	  }


}
