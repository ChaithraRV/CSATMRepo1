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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step04_CRB_Reject {
 
  
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
		@FindBy (name ="btnRejectSel") private WebElement Reject;
		@FindBy (xpath = ".//*[@id='finalCandForm']/table[3]/tbody/tr/td[2]/input") private WebElement Reject_sel;
		@FindBy (name = "FLD_REJ_REASON") private WebElement Reason;
		@FindBy (name = "txtReturnSelAsFinalist") private WebElement Return;
		@FindBy (name ="txtSaveAndReturnAsFinalist") private WebElement Save_Return;
		@FindBy (xpath=".//*[@id='FLD_CMTS_TO_REQSTR']") private WebElement ReturnReason;
		@FindBy (xpath=".//*[@id='FLD_CMTS_TO_REQSTR']") private WebElement Comments;
		@FindBy(xpath = ".//*[@value='002~S23CZG~001~1000118974~IBMSAPGC0~AUTH~0'] ") private WebElement  Resp2_Checkbox ;
		@FindBy(xpath = ".//*[@value='003~S23CZG~001~1000118974~IBMSAPGC0~AUTH~0'] ") private WebElement  Resp3_Checkbox ;
		@FindBy(xpath = ".//*[@value='001~S23CZG~001~1000118974~IBMSAPGC0~AUTH~0'] ") private WebElement  Resp1_Checkbox ;
		
	
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Initialize the web elements 
	public Step04_CRB_Reject(WebDriver driver)
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
    public void crbreject()
    {
    	WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(Awaiting_CRB_auth_link));
		
		
		Awaiting_CRB_auth_link.click();
		
		WebDriverWait wait03 = new WebDriverWait(driver, 180);
		wait03.until(ExpectedConditions.visibilityOf(Candidates));
		
		Candidates.click();
		
		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
		GO_reqnum.click();

		String Req_Num = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15) ;
		
		 WebDriverWait wait04 = new WebDriverWait(driver, 160);
		wait04.until(ExpectedConditions.visibilityOf(Skill_link)); 
		
		Skill_link.click();
	
			
			//Resp Selection Page
	    WebDriverWait wait05 = new WebDriverWait(driver, 160);
		wait05.until(ExpectedConditions.visibilityOf(Reject_sel));
	
	
		Select_Checkbox.click();
		
		
       	//SkillLink.click();
    		Reject_sel.click();
    	/* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

    File srcFile13 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

	try {
		String filename13 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\US\\13_Reject"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile13, new File (filename13));
		} catch (IOException e) 
		{
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
		}	
    	
    	Reason.sendKeys("Other");
    	Comments.sendKeys("test");
    	Reject.click();
    	WebDriverWait wait09 = new WebDriverWait(driver, 160);
		wait09.until(ExpectedConditions.visibilityOf(ExitRequest)); 
		
		/* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

    File srcFile14 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

	try {
		String filename14 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\US\\14_Reject"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile14, new File (filename14));
    	} catch (IOException e) 
	{
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
	}	
    	
    }
}