package Testcase;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page1_Login {


		  private WebDriver driver;

			// Define the element 
			@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginlink;



			// Initialize the web elements 
			public Page1_Login(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}



			// Function to login to the application
			// Click on the link again as workaround 
			public void login(){


				WebDriverWait wait01 = new WebDriverWait(driver, 180);
				wait01.until(ExpectedConditions.visibilityOf(loginlink));

				loginlink.click();
				System.out.println();

		  }
		}
