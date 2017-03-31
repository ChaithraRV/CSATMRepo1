package CRBActions_US;

import org.testng.annotations.Test;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step03_Finalize {
 
  
  private WebDriver driver;
  
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy ( xpath = ".//*[@id='left-nav']//a[contains(text(), 'Search')]" ) private WebElement LHS_Search_tab ;
	@FindBy ( id="FLD_REQ_NUM_SEARCH" ) private WebElement Request_Num_Fld ;
	@FindBy ( name="GO" ) private WebElement Search_GO_btn ;
	@FindBy ( xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement Request_Num_link ;

	 @FindBy ( xpath = ".//*[@id='content-main']/form/table[1]/tbody/tr[1]/td[3]/a" ) private WebElement Skill_link ;
	 //@FindBy(name="tblcolCandId") private WebElement  Resp1_Checkbox ;
	 @FindAll({@FindBy(name="tblcolCandId")}) private List<WebElement>  Select_Checkbox ;
	 
	 @FindBy(id="NSR1") private WebElement Justification;
	 @FindBy ( name="btnAddSelFin" ) private WebElement Btn_AddSelectedToFinalists ;
	 
	 @FindBy ( name="btnSubmitSel" ) private WebElement Btn_SubmitSelected ;
	 //Hiring Approval 
	 @FindBy ( id="FLD_NON_METRO_HIRING_REQUEST_NUM" ) private WebElement Non_Metro ;
	 @FindBy (id="FLD_REASON_NOT_HAVING_METRO_NUM") private WebElement Reason ;
	 @FindBy (id="ContinueSubmit") private WebElement Continue_Submission;
	 @FindBy (name="Continue") private WebElement Continue;
	 //Submit confirmation page
	 @FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	 @FindBy (name="btnConfirmSubmit") private WebElement Confirm_Submission;
	 
	
	// Initialize the web elements 
	public Step03_Finalize(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	
	public void loginAndOpenReq()
	{
		
		loginToContractor_Link.click();
		
		LHS_Search_tab.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOf(Request_Num_Fld)); 
		
		
		Request_Num_Fld.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
		
		Search_GO_btn.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 160);
		wait1.until(ExpectedConditions.visibilityOf(Request_Num_link)); 
		
		
		Request_Num_link.click();
	}
		
		
		public void FinaliseSubmit()
		{
			
	    WebDriverWait wait2 = new WebDriverWait(driver, 160);
		wait2.until(ExpectedConditions.visibilityOf(Skill_link)); 
		
		Skill_link.click();
		
		 WebDriverWait wait3 = new WebDriverWait(driver, 160);
	     wait3.until(ExpectedConditions.visibilityOf(Btn_AddSelectedToFinalists)); 
	     for (WebElement elt: Select_Checkbox){

				elt.click();

			} 
	     
		
	     Btn_AddSelectedToFinalists.click();
	     
	     /* code to capture screenshot */
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;
		
		File srcFile9 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
	 
		try {
			String filename9 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\US\\9_"+System.currentTimeMillis()+".png";
			FileUtils.copyFile(srcFile9, new File (filename9));

		    } catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error...............");
		}
		
		 WebDriverWait wait4 = new WebDriverWait(driver, 160);
	     wait4.until(ExpectedConditions.visibilityOf(Btn_SubmitSelected));
		
	     for (WebElement elt: Select_Checkbox){

				elt.click();

			} 
		Btn_SubmitSelected.click();
		
		
		
		//Hiring Approval page
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(Continue_Submission));
		
		Non_Metro.click();
		
		Reason.sendKeys("I use Metro, but can't for this situation and have a management-approved bypass");
		
		Continue_Submission.click();
		 
		 //submit confirmation page
		
		 WebDriverWait wait7 = new WebDriverWait(driver, 160);
		 wait7.until(ExpectedConditions.visibilityOf(Confirm_Submission));
		 
		 Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 1));
		 
		 Confirm_Submission.click();
		 
		 
		 
		 
		 /* code to capture screenshot */
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;
	
	File srcFile10 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

		try {
			String filename10 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\US\\10_"+System.currentTimeMillis()+".png";
			FileUtils.copyFile(srcFile10, new File (filename10));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error...............");
			
		}
		
		
		}
 
		
  
  }

