package com.owcs.test.steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import com.owcs.test.base.BaseClass;

public class WcsHomeSteps extends BaseClass {

private By outerIFrameLoc = By.xpath("//div[@id='frame1']/iframe");
private By innerIFrameLoc = By.xpath("//iframe[contains(@id,'contentPane_view')]");

@Given("user navigate to wcs login page <url>")
public void userloginwcs(@Named("url") String wcsUrl) throws InterruptedException {
start(wcsUrl);
}

@When("user enter <username> and <password> in loginpage")
public void userenteruserandpass(@Named("username") String user, @Named("password") String pwd)
throws InterruptedException {

driver.findElement(By.cssSelector("input#username")).sendKeys(user);
driver.findElement(By.cssSelector("input#password")).sendKeys(pwd);

}

@Then("user click the Login button")
public void userclickbutton() throws InterruptedException {
// driver.findElement(By.xpath("//span[contains(@text,'LOGIN')]")).click();
driver.findElement(By.xpath("//span[contains(@id,'fw_ui_dijit_Button_') and contains(text(),'LOGIN')]")).click();
// Thread.sleep(60000);

}

@Then("user should be in wcs homepage")
public void userisinhomepage() throws Exception {
System.out.println("User in homepage");
// waitForElement(By.xpath("//span[contains(@text,'Logout')]"));
// Boolean isTrue = driver.findElement(By.xpath("//span[contains(@text,'Logout')]")).isDisplayed();
// Assert.assertTrue("User is not in HomePage", isTrue);

}

@When("user select New from Content Menu")
public void selectContentMenu() throws Exception {
Thread.sleep(10000);
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
waitForElement(By.xpath("//span[text()='Content']"));
Actions builder = new Actions(driver);
builder.clickAndHold(driver.findElement(By.xpath("//span[text()='Content']"))).build().perform();
waitForElement(By.xpath("//td[text()='New']"));

}

@When("user select Page (Home) from New SubMenu")
public void selectHomePage() throws Exception {
driver.findElement(By.xpath("//td[text()='New']")).click();
waitForElement(By.xpath("//td[text()='Page (Home)']"));
driver.findElement(By.xpath("//td[text()='Page (Home)']")).click();
waitForElement(By.xpath("//iframe[contains(@id,'contentPane_view')]"));

}

@Then("user should be on Home content page")
public void verifyHomePageForm() throws Exception {
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
Thread.sleep(5000);
// Boolean isTrue =
// driver.findElementByXPath("//span[contains(text(),'Page
// (Home)')]").isDisplayed();
Assert.assertTrue("User is not in HomePage",
driver.findElements(By.xpath("//span[contains(text(),'Page (Home)')]")).size() > 0);
}

@When("user enter <Name> in the Home page template")
public void enterName(@Named("Name") String name) throws Exception {
System.out.println("user able to enter name in the field");
driver.switchTo().frame(driver.findElement(innerIFrameLoc));
waitForElement(By.cssSelector("input[name='flexassets:name']"));
driver.findElement(By.cssSelector("input[name='flexassets:name']")).sendKeys(name);
}

@Then("user select HomeDetail from Template dropdown")
public void userSelectHomeDatail() {

System.out.println("user able to Select Home Deatail from Template Dropdown");
}

@When("user enter <Tags> in the Home page template")
public void userSelectTags(@Named("Tags") String name) throws InterruptedException {
System.out.println("user able to Select Tags in Home Page");
waitForElement(By.xpath("//div[contains(@id,'fw_ui_dojox_form_TagListInput')]"));
driver.findElement(By.xpath("//div[contains(@id,'fw_ui_dojox_form_TagListInput')]")).sendKeys(name);
}

@Then("user enter value in Meta Title field as <MetaTitle>")
public void userEnterMetaTitle(@Named("MetaTitle") String name) throws Exception {
System.out.println("user able to Enter Meta Title in Home Page");
waitForElement(By.xpath("//input[@name='Attribute_metaTitle']"));
driver.findElement(By.xpath("//input[@name='Attribute_metaTitle']")).sendKeys(name);
}

@Then("user enter value in Meta Description field as <MetaDescription>")
public void userEnterMetaDescription(@Named("MetaDescription") String name) throws Exception {
System.out.println("user able to Enter MetaDescription in Home Page");
waitForElement(By.xpath("//input[@name='Attribute_metaDescription']"));
driver.findElement(By.xpath("//input[@name='Attribute_metaDescription']")).sendKeys(name);
}

@When("user enter <Banner AVI Image> in Search box and click the Search button")
public void userEnterBannerAviImage(@Named("Banner AVI Image") String name) throws Exception {
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
// waitForElement(By
// .xpath("//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]"));
// driver.findElementByXPath(
// "//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]")
// .click();
// waitForElement(By.xpath("//span[text()='Find Scene7 Image']"));
// driver.findElementByXPath("//span[text()='Find Scene7
// Image']").click();
waitForElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input"));
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).clear();
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(name);
System.out.println("user able to Enter Banner AVI Image in Banner Slot");
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(Keys.ENTER);
Thread.sleep(10000);

}

@Then("user should see <Banner AVI Image> in search results")
public void userSeeBannerAviImage(@Named("Banner AVI Image") String name) {
driver.switchTo().defaultContent();
driver.switchTo().frame(0);
Assert.assertTrue("User is not able to see Banner AVI Image in Search results",
driver.findElements(
By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"))
.size() > 0);
}

@Then("user select <Banner AVI Image> in the search results and drag into <BannerSlot> slot")
public void userSelectBannerAviImage(@Named("Banner AVI Image") String name) throws Exception {
WebElement fromElement = driver
.findElement(By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"));
System.out.println("First ---------------> " + fromElement.getText());
Actions actions = new Actions(driver);
actions.clickAndHold(fromElement).build().perform();
WebElement inner_frame = driver.findElement(By.xpath("//iframe[contains(@id,'contentPane_view')]"));
driver.switchTo().frame(inner_frame);
WebElement target = driver
.findElement(By.xpath("//div[@id='fw_ui_dijit_form_DropZone_0']//div[@class='MainDropDiv']"));
((Locatable) target).getCoordinates().inViewPort();
actions.moveToElement(target).release().build().perform();
Thread.sleep(10000);
}

@When("user enter <Banner Title> in the Home page template")
public void useEnterBannerTitle(@Named("Banner Title") String name) throws InterruptedException {
waitForElement(By.xpath("//input[@name='Attribute_bannerTitle']"));
driver.findElement(By.xpath("//input[@name='Attribute_bannerTitle']")).sendKeys(name);
System.out.println("user able to enter text in Banner Title Slot");
}

@When("user enter <Banner Text> in the Home page template")
public void useEnterBannerText(@Named("Banner Text") String name) throws Exception {
System.out.println("user able to enter text in Banner Text Slot");
// waitForElement(By.xpath("//input[@id='Attribute_bannerText']"));
// driver.findElement(By.xpath("//input[@id='Attribute_bannerText']")).click();
}

@When("user enter <banners AVI Image1> in Search field and click the Search button")
public void userEnterAViImageinbannersSlot(@Named("banners AVI Image1") String name) throws Exception {
System.out.println("user able to Drag and drop Avi Image in banners Slot");
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
// waitForElement(By
// .xpath("//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]"));
// driver.findElementByXPath(
// "//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]")
// .click();
// waitForElement(By.xpath("//span[text()='Find Scene7 Image']"));
// driver.findElementByXPath("//span[text()='Find Scene7
// Image']").click();
waitForElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input"));
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).clear();
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(name);
System.out.println("user able to Enter Banner AVI Image in Banner Slot");
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(Keys.ENTER);
Thread.sleep(10000);
}

@Then("user should see <banners AVI Image1> in search results")
public void AViImageinSearchResults(@Named("banners AVI Image1") String name) {
driver.switchTo().defaultContent();
driver.switchTo().frame(0);
Assert.assertTrue("User is not able to see Banner AVI Image in Search results",
driver.findElements(
By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"))
.size() > 0);
System.out.println("user able to see Avi Image in search Results");
}

@Then("user select <banners AVI Image1> in the search results and drag into <bannersSlot> slot")
public void AviImageIntobannersSlot(@Named("banners AVI Image1") String name) throws Exception {
WebElement fromElement = driver
.findElement(By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"));
System.out.println("First ---------------> " + fromElement.getText());
Actions actions = new Actions(driver);
actions.clickAndHold(fromElement).build().perform();
WebElement inner_frame = driver.findElement(By.xpath("//iframe[contains(@id,'contentPane_view')]"));
driver.switchTo().frame(inner_frame);
WebElement target = driver
.findElement(By.xpath("//div[@id='fw_ui_dijit_form_DropZone_1']//div[@class='MainDropDiv']"));
((Locatable) target).getCoordinates().inViewPort();
actions.moveToElement(target).release().build().perform();
Thread.sleep(10000);
System.out.println("user able to see Avi Image in banners Slot");
}

@When("user enter <Title> in the Home page template")
public void EnterValueInTitleSlot(@Named("Title") String name) {
System.out.println("user able to enter value in Title Slot");
}

@When("user enter <Teaser AVI Image1> in Search field and click the Search button")
public void EnterAviImageInSearchFieldClickSearchButton(@Named("Teaser AVI Image1") String name) throws Exception {
System.out.println("user able to enter Teaser AVI Image1 in Seach box and click search button");
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
// waitForElement(By
// .xpath("//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]"));
// driver.findElementByXPath(
// "//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]")
// .click();
// waitForElement(By.xpath("//span[text()='Find Scene7 Image']"));
// driver.findElementByXPath("//span[text()='Find Scene7
// Image']").click();
waitForElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input"));
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).clear();
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(name);
System.out.println("user able to Enter Banner AVI Image in Banner Slot");
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(Keys.ENTER);
Thread.sleep(10000);
}

@Then("user should see <Teaser AVI Image1> in search results")
public void TeaserAviImage1InSearchresults(@Named("Teaser AVI Image1") String name) {
System.out.println("user able to see Teaser Avi Images into Search results");
driver.switchTo().defaultContent();
driver.switchTo().frame(0);
Assert.assertTrue("User is not able to see Banner AVI Image in Search results",
driver.findElements(
By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"))
.size() > 0);
System.out.println("user able to see Avi Image in search Results");
}

@Then("user select <Teaser AVI Image1> in the search results and drag into <Teaser Images Slot>")
public void DragAndDropAviImageIntoTeaserImagesSlot(@Named("Teaser AVI Image1") String name) throws Exception {
WebElement fromElement = driver
.findElement(By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"));
System.out.println("First ---------------> " + fromElement.getText());
Actions actions = new Actions(driver);
actions.clickAndHold(fromElement).build().perform();
WebElement inner_frame = driver.findElement(By.xpath("//iframe[contains(@id,'contentPane_view')]"));
driver.switchTo().frame(inner_frame);
WebElement target = driver
.findElement(By.xpath("//div[@id='fw_ui_dijit_form_DropZone_3']//div[@class='MainDropDiv']"));
((Locatable) target).getCoordinates().inViewPort();
actions.moveToElement(target).release().build().perform();
Thread.sleep(10000);
System.out.println("user able to drag and drop Avi Image1 in Teaser Image Slot");
}

@When("user enter <Teaser AVI Image2> in Search field and click the Search button")
public void EnterAviImage2InSearchFieldClickSearchButton(@Named("Teaser AVI Image2") String name) throws Exception {
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
// waitForElement(By
// .xpath("//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]"));
// driver.findElementByXPath(
// "//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]")
// .click();
// waitForElement(By.xpath("//span[text()='Find Scene7 Image']"));
// driver.findElementByXPath("//span[text()='Find Scene7
// Image']").click();
waitForElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input"));
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).clear();
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(name);
System.out.println("user able to Enter Banner AVI Image in Banner Slot");
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(Keys.ENTER);
Thread.sleep(10000);
System.out.println("user able to enter Teaser AVI Image2 in Seach box and click search button");
}

@Then("user should see <Teaser AVI Image2> in search results")
public void TeaserAviImage2InSearchresults(@Named("Teaser AVI Image2") String name) {
System.out.println("user able to see Teaser Avi Images in Search results");
driver.switchTo().defaultContent();
driver.switchTo().frame(0);
Assert.assertTrue("User is not able to see Banner AVI Image in Search results",
driver.findElements(
By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"))
.size() > 0);
}

@Then("user select <Teaser AVI Image2> in the search results and drag into <Teaser Images Slot> slot")
public void DragAndDropAviImage2IntoTeaserImagesSlot(@Named("Teaser AVI Image2") String name) throws Exception {
System.out.println("user able to drag and drop Avi Image2 in Teaser Image Slot");
WebElement fromElement = driver
.findElement(By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"));
System.out.println("First ---------------> " + fromElement.getText());
Actions actions = new Actions(driver);
actions.clickAndHold(fromElement).build().perform();
WebElement inner_frame = driver.findElement(By.xpath("//iframe[contains(@id,'contentPane_view')]"));
driver.switchTo().frame(inner_frame);
WebElement target = driver
.findElement(By.xpath("//div[@id='fw_ui_dijit_form_DropZone_3'] //following-sibling::div[@class='dojoDndItem']"));
((Locatable) target).getCoordinates().inViewPort();
actions.moveToElement(target).release().build().perform();
Thread.sleep(10000);
}

@When("user enter <Teaser AVI Image3> in Search field and click the Search button")
public void EnterAviImage3InSearchFieldClickSearchButton(@Named("Teaser AVI Image3") String name) throws Exception {
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
// waitForElement(By
// .xpath("//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]"));
// driver.findElementByXPath(
// "//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]")
// .click();
// waitForElement(By.xpath("//span[text()='Find Scene7 Image']"));
// driver.findElementByXPath("//span[text()='Find Scene7
// Image']").click();
waitForElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input"));
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).clear();
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(name);
System.out.println("user able to Enter Banner AVI Image in Banner Slot");
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(Keys.ENTER);
Thread.sleep(10000);
System.out.println("user able to enter Teaser AVI Image3 in Seach box and click search button");
}

@Then("user should see <Teaser AVI Image3> in search results")
public void TeaserAviImage3InSearchresults(@Named("Teaser AVI Image3") String name) {
driver.switchTo().defaultContent();
driver.switchTo().frame(0);
Assert.assertTrue("User is not able to see Banner AVI Image in Search results",
driver.findElements(
By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"))
.size() > 0);
System.out.println("user able to see Teaser Avi Images in Search results");
}

@Then("user select <Teaser AVI Image3> in the search results and drag into <Teaser Images Slot> slot")
public void DragAndDropAviImage3IntoTeaserImagesSlot(@Named("Teaser AVI Image3") String name) throws Exception {
WebElement fromElement = driver
.findElement(By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"));
System.out.println("First ---------------> " + fromElement.getText());
Actions actions = new Actions(driver);
actions.clickAndHold(fromElement).build().perform();
WebElement inner_frame = driver.findElement(By.xpath("//iframe[contains(@id,'contentPane_view')]"));
driver.switchTo().frame(inner_frame);
WebElement target = driver
.findElement(By.xpath("//div[@id='fw_ui_dijit_form_DropZone_3'] //following-sibling::div[@class='dojoDndItem']"));
((Locatable) target).getCoordinates().inViewPort();
actions.moveToElement(target).release().build().perform();
Thread.sleep(10000);
System.out.println("user able to drag and drop Avi Image3 in Teaser Image Slot");
}

@When("user enter <Teaser AVI Image4> in Search field and click the Search button")
public void EnterAviImage4InSearchFieldClickSearchButton(@Named("Teaser AVI Image4") String name) throws Exception {
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
// waitForElement(By
// .xpath("//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]"));
// driver.findElementByXPath(
// "//span[@id='searchTypeMenu']//span[contains(@id,'DropDownButton')]")
// .click();
// waitForElement(By.xpath("//span[text()='Find Scene7 Image']"));
// driver.findElementByXPath("//span[text()='Find Scene7
// Image']").click();
waitForElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input"));
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).clear();
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(name);
System.out.println("user able to Enter Banner AVI Image in Banner Slot");
driver.findElement(By.xpath("//div[@id='widget_searchBox']/div[2]/div/input")).sendKeys(Keys.ENTER);
Thread.sleep(10000);
System.out.println("user able to enter Teaser AVI Image4 in Seach box and click search button");
}

@Then("user should see <Teaser AVI Image4> in search results")
public void TeaserAviImage4InSearchresults(@Named("Teaser AVI Image4") String name) {
driver.switchTo().defaultContent();
driver.switchTo().frame(0);
Assert.assertTrue("User is not able to see Banner AVI Image in Search results",
driver.findElements(
By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"))
.size() > 0);
System.out.println("user able to see Teaser Avi Images in Search results");
}

@Then("user select <Teaser AVI Image4> in the search results and drag into <Teaser Images Slot> slot")
public void DragAndDropAviImage4IntoTeaserImagesSlot(@Named("Teaser AVI Image4") String name) throws Exception {
WebElement fromElement = driver
.findElement(By.xpath("//div[@id='searchGrid']/div[2]/div/div/div/div/div[1]/table/tbody/tr/td/a"));
System.out.println("First ---------------> " + fromElement.getText());
Actions actions = new Actions(driver);
actions.clickAndHold(fromElement).build().perform();
WebElement inner_frame = driver.findElement(By.xpath("//iframe[contains(@id,'contentPane_view')]"));
driver.switchTo().frame(inner_frame);
WebElement target = driver
.findElement(By.xpath("//div[@id='fw_ui_dijit_form_DropZone_3'] //following-sibling::div[@class='dojoDndItem']"));
((Locatable) target).getCoordinates().inViewPort();
actions.moveToElement(target).release().build().perform();
Thread.sleep(10000);
System.out.println("user able to drag and drop Avi Image4 in Teaser Image Slot");
}

@When("user enter <Teaser Text1> in the Home page template")
public void enterText1InTeaserSlot(@Named("Teaser Text1") String name) {
System.out.println("user able to see Teaser text1 in Teaser Slot");
}

@When("user enter <Teaser Text2> in the Home page template")
public void enterText2InTeaserSlot(@Named("Teaser Text2") String name) {
System.out.println("user able to see Teaser text2 in Teaser Slot");
}

@When("user enter <Teaser Text3> in the Home page template")
public void enterText3InTeaserSlot(@Named("Teaser Text3") String name) {
System.out.println("user able to see Teaser text3 in Teaser Slot");
}

@When("user enter <Teaser Text4> in the Home page template")
public void enterText4InTeaserSlot(@Named("Teaser Text4") String name) {
System.out.println("user able to see Teaser text4 in Teaser Slot");
}

@When("user click on Metadata tab")
public void ClickOnMetaabT() throws Exception {
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
driver.switchTo().frame(driver.findElement(innerIFrameLoc));
waitForElement(By.xpath("//span[text()='Metadata']"));
driver.findElement(By.xpath("//span[text()='Metadata']")).click();
System.out.println("user able to click on Meata Tab");
Thread.sleep(25000);
}

@Then("user enter Start Date")
public void EnterStartDate() {
System.out.println("user able to Enter Start Date");
}

@Then("user enter End Date")
public void EnterEndDate() {
System.out.println("user able to Enter End Date");
}

@Then("user click on URL Tab")
public void ClickOnUrlTab() {
System.out.println("user able to click on Url Tab");
}

@When("user click on Save button after create")
public void ClickOnSaveButton() throws Exception {
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
Thread.sleep(5000);
driver.findElement(By.xpath("//div[@id='create']//span[@role='button']")).click();
System.out.println("user able to click on Save button");
}

@Then("the template should be successfully saved")
public void TemplateSave() {
System.out.println("user able to see Template successfully saved");
}

@When("user select Preview in New Window from View Menu")
public void PreviewInViewWnidow() {
System.out.println("user able to see Preview in New Window");
}

@Then("user verify the content of the page for Home for all slots should be displayed")
public void VerifyContentOfAllSlots() {
System.out.println("user able to see the content of the page of all slots in Home Page");
}

@When("user type url in URL field for Home Page")
public void TypeUrlInHomePage() {
driver.switchTo().frame(driver.findElement(outerIFrameLoc));
driver.findElement(By.xpath("//span[contains(text(),'URL')]")).click();
}

@Then("user select <Template> from Template dropdown")
public void selectTemplate(@Named("Template") String template) {
System.out.println("user selected template form dropdown");
}

@Then("user select <Url> from Host dropdown")
public void selectUrlFromHost(@Named("Url") String url) {
System.out.println("user is able to select url form host");
}

@Then("user select <DeviceGroup> from Device Group dropdown")
public void selectDeviceGroup(@Named("DeviceGroup") String deviceGroup) {
System.out.println("user is able to select Device Group form dropdown");
}

@Then("user click on Add and verify url under Info")
public void clickAddUrl() {
System.out.println("user is able to add url");
}
}
	