package CRBActions_GB;


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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step04_CRB_Return_GB {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	
	// Define all web elements under test displayed on home page
		@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Switch instance')]") private WebElement Switch_Instance;
		@FindBy (id="FLD_SELECT_INSTANCE") private WebElement Instance ;
		@FindBy (name="btnGo") private WebElement GO ;
		@FindBy (xpath = ".//*[@value='Exit request'] ") private WebElement ExitRequest;
		@FindBy (xpath = ".//*[@id='content-main']/form/table[1]/tbody/tr[1]/td[3]/a") private WebElement SkillLink ;
		@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting client review board action')]") private WebElement Awaiting_CRB_auth_link ;
		@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Candidates')]") private WebElement Candidates ;
		@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
		@FindBy (name="btnGo") private WebElement GO_reqnum ;
		@FindBy (name = "btnAuthCandidate") private WebElement Auth_Link;
		@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a) " ) private WebElement Request_Number ;
		
		@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
		@FindBy(name="tblcolCandId") private WebElement  Select_Checkbox ;
		@FindBy (name="btnAuthSel") private WebElement Authorize_selected ;
		
		@FindBy (name = "txtReturnSelAsFinalist") private WebElement Return;
		@FindBy (name ="txtSaveAndReturnAsFinalist") private WebElement Save_Return;
		@FindBy (xpath=".//*[@id='FLD_CMTS_TO_REQSTR']") private WebElement ReturnReason;
		@FindBy (xpath=".//*[@id='FLD_CMTS_TO_REQSTR']") private WebElement Comments;
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Initialize the web elements 
	public Step04_CRB_Return_GB(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Function to login to the application
	
	public void login()
	{
		
		loginToContractor_Link.click();
  
    }

	//Function to click Create New Request button
    public void CRB_Return()
    {
    	WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Awaiting_CRB_auth_link));
		
		
		Awaiting_CRB_auth_link.click();
		
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(Candidates));
		
		Candidates.click();
		
		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 2, 15));
		GO_reqnum.click();

		String Req_Num = Excel.getCellValue(xlsFilePath, "Request_creation", 2, 15) ;
		
		 WebDriverWait wait03 = new WebDriverWait(driver, 160);
		wait03.until(ExpectedConditions.visibilityOf(Skill_link)); 
		
		Skill_link.click();
	
			
			//Resp Selection Page
	    WebDriverWait wait05 = new WebDriverWait(driver, 160);
		wait05.until(ExpectedConditions.visibilityOf(Return));
	
	
		Select_Checkbox.click();
		
				
		 /* code to capture screenshot */
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

	File srcFile11 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

	try 
	{
	String filename11 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\GB\\11_CRBReturn"+System.currentTimeMillis()+".png";
	FileUtils.copyFile(srcFile11, new File (filename11));
    } 
	catch (IOException e) 
	{
	// TODO Auto-generated catch block
	System.out.println("Error...............");
	
	}
    	Return.click();
    	ReturnReason.sendKeys("test");
    	Save_Return.click();
    	
    	WebDriverWait wait09 = new WebDriverWait(driver, 160);
		wait09.until(ExpectedConditions.visibilityOf(ExitRequest)); 
		
		/* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

    File srcFile16 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

	try 
	{
		String filename16 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\GB\\12_CRBReturn"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile16, new File (filename16));
    } catch (IOException e) 
	{
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
	}	
    	
    }
    
	}
