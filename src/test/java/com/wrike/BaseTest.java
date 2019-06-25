package com.wrike;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ResendPage;
import page.MainPage;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    private static WebDriver driver;
    private static MainPage mainPage;
    private static ResendPage resendPage;
    private static final String Page = "http://wrike.com";


    @BeforeClass
    public static void init() {
        //TODO CREATE ENUM TO CONTAIN PROPERTIES FOR WEBDRIVER AND PAGES
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        resendPage = new ResendPage(driver);
        System.out.println("TESTING STARTED");

    }

    @Test

    public void tests() throws InterruptedException {
        //open URL
        mainPage.firstStep(Page);
        //click button GetFree
        mainPage.secondStep();
        //Fill random data
        mainPage.thirdStep();
        //Click button Submit
        mainPage.fourthStep();
        //check Redirect
        resendPage.fifthStep();
        //Fill QA form
        resendPage.sixthStep();
        //Click submit
        resendPage.seventhStep();
        //I haven't found "Resend email" button on your site , so I haven't done this step

        //check Twitter
        resendPage.eighthStep();
        resendPage.ninthStep();

    }

    @After
    public void closeBrowser() {
        System.out.println("TESTS PASSED");
        driver.close();
    }


}

