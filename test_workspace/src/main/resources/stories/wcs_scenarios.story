 
Scenario:  Login into WCS and verify Homepage
 
Given user navigate to wcs login page <url>
When user enter <username> and <password> in loginpage
Then user click the Login button
Then user should be in wcs homepage

Examples:
|url|username|password|
|http://localhost:9080/cs/wem/fatwire/home|fwadmin|xcladmin|