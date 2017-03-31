package CRBActions_US;

import org.testng.annotations.Test;

import lib.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step01_CreateRequest {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='content-main']/form[1]/div/span/input") private WebElement Create_New_Request;
	
	//Skill Request Page	
	@FindBy (id ="FLD_REQ_TYPE") private WebElement New_Request ;
	@FindBy ( id="FLD_NORMAL_TYPE1") private WebElement Time_Materials ;
	@FindBy (name = "btnContinue") private WebElement Continue ;
	
	//Select Requestor
	@FindBy  (id = "FLD_REQST_CO") private WebElement  Requesting_Company ;
	@FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	
	// Job Role/Skill
	  @FindBy ( xpath= ".//*[@id='JRSS_SELECTION1']") private WebElement Priced_JRSS;
	    @FindBy ( id = "FLD_JOB_ROLE" ) private WebElement Select_JobRole ;
	    @FindBy ( id = "FLD_SKILL_SET") private WebElement Select_SkillSet;
	
	//Project Creation
	    @FindBy ( id="FLD_PROJ_NAME") private WebElement Project_Name;
	    @FindBy (id="FLD_IS_GLOBAL_RESOURCE0") private WebElement GlobalResource_No ;
	    @FindBy ( id="FLD_CONTACT_NAME") private WebElement CustomerName_Refernce ;
	    @FindBy ( xpath = ".//*[@id='FLD_IS_FED_CONTRACT']")  private WebElement Govt_FederalContract ;
	    @FindBy ( id="FLD_CLIENT") private WebElement Client ;
	    @FindBy ( id="FLD_BRAND") private WebElement Brand ;
	    @FindBy ( id="FLD_SECTOR") private WebElement Sector ;
	    @FindBy ( id="FLD_INDUSTRY") private WebElement Industry ;
	    @FindBy ( id="fldRegulatedAcc1") private WebElement FDA ;
	    @FindBy ( id="fldRegulatedAcc2") private WebElement FFIEC ;
	    @FindBy ( id="fldRegulatedAcc4") private WebElement NREG ;
	    @FindBy ( xpath = " .//*[@value='I'] " ) private WebElement Accounting_Type ;
	    
	    //Skill detail Location
	    @FindBy ( id="FLD_WRK_LOC_STATE" ) private WebElement State_Region_Province;
	    @FindBy ( id="FLD_WRK_LOC_CITY" ) private WebElement City ;
	    @FindBy ( id="FLD_WRK_LOC" ) private WebElement Work_Location ;
	    @FindBy ( name="Continue" ) private WebElement Continue_2 ;
	    @FindBy (id="FLD_ALT_WORK_LOC" ) private WebElement Alternate_Workloc ;
	    
	  //Skill detail skill price
	    @FindBy ( id="FLD_RQSTD_SKILL_LVL" ) private WebElement Skill_Level;
	    @FindBy (id="FLD_RQSTD_PRICE_LVL" )  private WebElement Price_Level;
	    @FindBy (id="FLD_QTY_SKILL_NEEDED" ) private WebElement Quantity ;
	    
	    //Skill Summary Page
	    @FindBy (xpath = ".//*[@value='Continue to request summary'] ") private WebElement ContinueToRequestSummary;
	
	 //Review Skill request
	    @FindBy (name = "Submit request") private WebElement SubmitRequest;
	    
	    //Request Created
	    @FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated;
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	 
	// Initialize the web elements 
	public Step01_CreateRequest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login(){
		
		loginToContractor_Link.click();
  
  }
	//Create Request
	public void Create_New_Request()
    {
    	WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Create_New_Request));
		
		
    	Create_New_Request.click();
    	
    }
	//Skill Request Page
	public void Skill_Request(){
	
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(New_Request));
		
		New_Request.click();
		Time_Materials.click();
		Continue.click();
		
	}
	
	//Select Requestor Page
	public void Select_Requestor(){
		Requesting_Company.sendKeys(Excel.getCellValue(xlsFilePath,"Request_Creation",1,0));
		Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath,"Request_Creation" , 1, 1));
		
		 /* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

	try {
		String filename1 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\US\\1_"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile1, new File (filename1));





	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
	}
		Continue.click();		
	}
	
	//JRSS
	public void Select_JRSS()
    
    {
	 
	 String JR = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 2);
	 String SS = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 3);  
   
	 Priced_JRSS.click();	
	
    Select JRlistbox = new Select(Select_JobRole);
	JRlistbox.selectByVisibleText(JR);
	
	Select SSlistbox = new Select(Select_SkillSet);
	SSlistbox.selectByVisibleText(SS);
	 /* code to capture screenshot */
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

File srcFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

try {
	String filename2 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\US\\2_"+System.currentTimeMillis()+".png";
	FileUtils.copyFile(srcFile2, new File (filename2));





} catch (IOException e) {
	// TODO Auto-generated catch block
	System.out.println("Error...............");
	
}
	
	 Continue.click();
	 
    }
	
	//request details
	public void Request_detailpage()
    
    {
	 
	Project_Name.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 4));
	GlobalResource_No.click();
	Govt_FederalContract.click();
	Client.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 5));
	Brand.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 6));
	Sector.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 7));
	Industry.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 8));
	FDA.click();
	FFIEC.click();
	NREG.click();
	Accounting_Type.click();
	Continue.click();
	}
	
	//skill detail Page
	public void Skill_detailLocationpage()
    
    {
	 
	 Select st = new Select(State_Region_Province);
		st.selectByVisibleText("Vermont");
		
   try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
   
   Select ct = new Select(City);
	ct.selectByVisibleText("ESSEX JUNCTION");
	
	
   try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
   Continue_2.click();
    }
   public boolean isAlertPresent() 
   { 
       try 
       { 
    	   driver.switchTo().alert().accept();
           return true;
       
           
       }   // try 
       catch (NoAlertPresentException Ex) 
       { 
           return false; 
       }   // catch 
   //driver.switchTo().alert().accept();
}
    
	//Skill detail skill price
	public void Skill_detail_skillpricepage()
    
    {

	    WebDriverWait wait3 = new WebDriverWait(driver, 160);
		wait3.until(ExpectedConditions.visibilityOf(Skill_Level));
		
    Skill_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 12));
    Price_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 13));
    Quantity.clear();
    driver.switchTo().alert().accept();
    Quantity.sendKeys("3");
    
   
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    
    Continue_2.click();
	
}
	//Supplier Selection Page
	public void SupplierSelectionPage()
	{
		WebDriverWait wait4 = new WebDriverWait(driver, 160);
		wait4.until(ExpectedConditions.visibilityOf(Continue));
		
		Continue.click();
		
		//Skill detail Skill request
		WebDriverWait wait5 = new WebDriverWait(driver, 160);
		wait5.until(ExpectedConditions.visibilityOf(Continue));
		
		Continue.click();
		
		//Summary Page
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(ContinueToRequestSummary));
		
		ContinueToRequestSummary.click();
		
		 /* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

File srcFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

	try {
		String filename3 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\US\\3_"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile3, new File (filename3));





	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
	}
		
		WebDriverWait wait7 = new WebDriverWait(driver, 160);
		wait7.until(ExpectedConditions.visibilityOf(SubmitRequest));
		
		SubmitRequest.click();
		
		String Number = RequestCreated.getText().substring(33, 39);
		Excel.setCellValue(xlsFilePath, "Request_creation", 1, 15, Number );
	}

	
	    public String Reqdata()
	    
	    {
		 
		 /* code to capture screenshot */
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;
	
    	File srcFile4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

		try {
			String filename4 = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\CRBActions\\US\\4_"+System.currentTimeMillis()+".png";
			FileUtils.copyFile(srcFile4, new File (filename4));





		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error...............");
			
		}
		
		return RequestCreated.getText();
		
	   }
}



	
