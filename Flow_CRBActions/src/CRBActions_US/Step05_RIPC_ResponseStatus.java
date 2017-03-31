package CRBActions_US;

import org.testng.annotations.Test;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step05_RIPC_ResponseStatus {
 
  String str="Finalist";
  String str1 = "Rejected";
  public String str2;
  public String str3;
  public String str4="Awaiting authorization";
  public String str5;
  private WebDriver driver;
  
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Search')]") private WebElement Search ;
	@FindBy ( id="FLD_REQ_NUM_SEARCH") private WebElement Request_Num ;
	@FindBy ( name="GO") private WebElement Go_btn ;
	@FindBy  ( xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a") private WebElement ReqNumlink ;
	@FindBy (xpath=".//*[@id='content-main']/form/table[3]/tbody/tr[3]/td[4]") private WebElement Reject_status;
	@FindBy (xpath =".//*[@id='content-main']/form/table[3]/tbody/tr[4]/td[4]") private WebElement Finalist;
	@FindBy (xpath =".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[4]/a") private WebElement AwaitingAuth;
	@FindBy ( xpath = ".//*[@id='content-main']/form/table[1]/tbody/tr[11]/td[3]/a") private WebElement Supplink ;
	
	
	
	
	// Initialize the web elements 
	public Step05_RIPC_ResponseStatus(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void status(){
		
		loginToContractor_Link.click();
		Search.click();
		
		Request_Num.sendKeys(Excel.getCellValue(xlsFilePath,"Request_creation", 1, 15));
		Go_btn.click();
		
		
		ReqNumlink.click();
		System.out.println("Hello1");
	}
		public void status_verf()
		{
		 str2 = Finalist.getText();
		 System.out.println(str2);
		if (str2.equals(str))
		{ 
		System.out.println("Status Passed : Finalist_Response");
		} else
		{ 
			System.out.println("Status Failed : Finalist_response");
			driver.quit();
		}
		
		str3 = Reject_status.getText();
		if (str3.equals(str1))
		{
			System.out.println("Status Passed : Rejected_response");
		}else
		{ 
			System.out.println("Status Failed : Rejected_response");
			driver.quit();
		}
		
		str5= AwaitingAuth.getText();
		System.out.println(str5);
		if (str5.equals(str4))
		{
			System.out.println("Status Passed : Authorize_response");
		}else
		{ 
			System.out.println("Status Failed : Authorize_response");
			driver.quit();
		}
		
		/* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

		File srcFile17 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

		try 
		{
		String filename17 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\17_StatusRIPC"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile17, new File (filename17));
		} catch (IOException e) 
		{
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
		}
	}
		
		
	
  }

