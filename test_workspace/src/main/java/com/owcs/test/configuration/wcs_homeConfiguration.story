Scenario:  Login into WCS and verify Homepage
 
Given user navigate to wcs login page <url>
When user enter <username> and <password> in loginpage
Then user click the Login button
Then user should be in wcs homepage

Examples:
|url|username|password|
|http://localhost:9080/cs/wem/fatwire/home|fwadmin|xceladmin|

Scenario: As a content contributor, user able to Create Home Page and see preview




When user select New from Content Menu
When user select Page (Home) from New SubMenu
Then user should be on Home content page



When user enter <Name> in the Home page template
Then user select HomeDetail from Template dropdown
When user enter <Tags> in the Home page template
Then user enter value in Meta Title field as <MetaTitle>
Then user enter value in Meta Description field as <MetaDescription>

When user enter <Banner AVI Image> in Search box and click the Search button
Then user should see <Banner AVI Image> in search results
Then user select <Banner AVI Image> in the search results and drag into <BannerSlot> slot


When user enter <Banner Title> in the Home page template
When user enter <Banner Text> in the Home page template


When user enter <banners AVI Image1> in Search field and click the Search button
Then user should see <banners AVI Image1> in search results
Then user select <banners AVI Image1> in the search results and drag into <bannersSlot> slot


When user enter <Title> in the Home page template


When user enter <Teaser AVI Image1> in Search field and click the Search button
Then user should see <Teaser AVI Image1> in search results
Then user select <Teaser AVI Image1> in the search results and drag into <Teaser Images Slot>

When user enter <Teaser AVI Image2> in Search field and click the Search button
Then user should see <Teaser AVI Image2> in search results
Then user select <Teaser AVI Image2> in the search results and drag into <Teaser Images Slot> slot



When user enter <Teaser AVI Image3> in Search field and click the Search button
Then user should see <Teaser AVI Image3> in search results
Then user select <Teaser AVI Image3> in the search results and drag into <Teaser Images Slot> slot


When user enter <Teaser AVI Image4> in Search field and click the Search button
Then user should see <Teaser AVI Image4> in search results
Then user select <Teaser AVI Image4> in the search results and drag into <Teaser Images Slot> slot


When user click on Save button after create




Examples:
|Name |Tags |MetaTitle |MetaDescription |Url |Banner AVI Image |Banner Title |Banner Text |banners AVI Image1 |Title |Teaser AVI Image1 |Teaser AVI Image2 |Teaser AVI Image3 |Teaser AVI Image4 |Teaser Text1|Teaser Text2 |Teaser Text3 |Teaser Text4 |
|HomePage |A      |Home |HomePage |cart |Ski Banner (large) | All 25 Nevada | Hit the slopes |Football banner (small) |Home |Tennis Lesson | Windsurfer Sail | Female Runner Stretch | Baseball Home || | | |