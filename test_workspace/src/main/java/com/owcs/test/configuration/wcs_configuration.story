 
Scenario:  Login into WCS and verify logout message
 
Given user navigate to wcs login page <url>
When user enter <username> and <password> in loginpage
Then user click the Login button
Then user should be able to see logout message

Examples:
|url|username|password|
|http://localhost:9080/cs/wem/fatwire/home|fwadmin|xceladmin|