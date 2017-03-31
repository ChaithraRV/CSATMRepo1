package CRBActions_IN;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step06_PO_Auth_IN {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting project office action')]") private WebElement Awaiting_PO_Auth_link ;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Service ids')]") private WebElement Candidates ;
	@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a " ) private WebElement Request_Number ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[4]/a" ) private WebElement Project_Name ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy(name="FLD_MULTI_LINE_ITEMS") private WebElement  Select_Checkbox ;
	@FindBy (name="btnSubmitSelCand") private WebElement Submit_Selected_Responses ;
	 @FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	@FindBy (name="btnConfirmSubmit") private WebElement Confirm_submission ;
	
	
	
	
	
	// Initialize the web elements 
	public Step06_PO_Auth_IN(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login(){
		
		loginToContractor_Link.click();
  
		
  }
	
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	
		
		//Function to click Create New Request button
        public void authorize_PO ()
        {
        	
        	WebDriverWait wait01 = new WebDriverWait(driver, 180);
			wait01.until(ExpectedConditions.visibilityOf(Awaiting_PO_Auth_link));
			
		    Awaiting_PO_Auth_link.click();
    		Candidates.click();
    		
    		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 15));
    		GO_reqnum.click();

    		WebDriverWait wait02 = new WebDriverWait(driver, 180);
			wait02.until(ExpectedConditions.visibilityOf(Project_Name));
    		
    		
    	Project_Name.click();
    	
    	WebDriverWait wait03 = new WebDriverWait(driver, 180);
		wait03.until(ExpectedConditions.visibilityOf(Submit_Selected_Responses));
    	
		Select_Checkbox.click();
		
    	Submit_Selected_Responses.click();
    	
    	 /* code to capture screenshot */
    	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\IN\\");
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
    	WebDriverWait wait04 = new WebDriverWait(driver, 180);
		wait04.until(ExpectedConditions.visibilityOf(Confirm_submission));
		
		 Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 1));
    	Confirm_submission.click();
    	
    	
    	
    	 /* code to capture screenshot */
    	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\IN\\");
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        	
        }
	
}
