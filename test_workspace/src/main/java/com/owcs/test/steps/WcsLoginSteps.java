package com.owcs.test.steps;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class WcsLoginSteps extends Embedder {

	static ChromeDriver driver;
	
	//private By outerIFrameLoc = By.xpath("//div[@id='frame1']/iframe");
	//private By innerIFrameLoc = By.xpath("//iframe[contains(@id,'contentPane_view')]");
	
@Given("user navigate to wcs login page <url>")
public void userloginwcs(@Named("url") String wcsUrl) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "G:/software/chromedriver_win32/chromedriver_win32/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(wcsUrl);
	//Thread.sleep(20000);
	driver.manage().window().maximize();
}

@When("user enter <username> and <password> in loginpage")
public void userenteruserandpass(@Named("username") String user,@Named("password") String pwd) throws InterruptedException {
	
	 driver.findElementByCssSelector("input#username").sendKeys(user);
	 driver.findElementByCssSelector("input#password").sendKeys(pwd);
	
	
	
}


@Then("user click the Login button")
public void userclickbutton() throws InterruptedException {
	//driver.findElement(By.xpath("//span[contains(@text,'LOGIN')]")).click();
	 driver.findElementByXPath("//span[contains(@id,'fw_ui_dijit_Button_') and contains(text(),'LOGIN')]").click();
	//Thread.sleep(60000);
	
}



@Then("user should be able to see logout message")
public void logoutmessage() throws Exception {
//	driver.switchTo().frame(driver.findElement(outerIFrameLoc));
	Thread.sleep(10000);
	System.out.println("Lo      "+driver.findElementByXPath("//span[text()='Logout']").getText());
//	Boolean isTrue = driver.findElementByXPath(".//*[@id='fw_ui_dijit_Button_0_label']").isDisplayed();
	
	Assert.assertTrue("User is not able to see logout message", driver.findElementByXPath("//span[text()='Logout']").getText().equals("Logout"));
	
	
}

}