# WRIKETEST 

Steps to start test: 
 ```sh
$ mvn clean test
$ mvn allure:serve

```
 
 ## I needed to implement a test which contains following steps:
 
 ### Test case scenario:

-(firstStep)Open url: wrike.com;


-(secondStep)Click "Get started for free" button near "Login" button;


-(thirdStep)Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);


-(fourthStep)Click on "Create my Wrike account" button + check with assertion that you are moved to the next page;


-(fifthStep)Fill in the Q&A section at the left part of page (like random generated answers) + check with assertion that your answers are submitted;

-(Click on "Resend email" + check it with assertion;


-Check that section "Follow us" at the site footer contains the "Twitter" button that leads to the correct url and has the -correct icon;


-Create results report using allure plugin (by maven).


-(you may close all needless tooltips on your way)



#### Stack of technologies for implementation:

-Platform: java8 /n
>Build and run: maven
>Test framework: junit4
>UI test: selenium 3 
>Pattern: pageObject (test -> steps -> pages)
>Reporting: allure plugin
>Selector: xpath and css
