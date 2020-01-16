package page;


import generator.RandomFill;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@Epic("Steps 5-9")
@Feature("Testing ResendPage Interface")
public class ResendPage {

    private final WebDriver driver;

    //avoid path like these
    private static final By submitData = By.cssSelector("div.wg-cell.wg-cell--md-6.wg-cell--lg-7 > div > form > button");
    private static final By firstBarLocator = By.cssSelector("div.wg-cell.wg-cell--md-6.wg-cell--lg-7 > div > form > div:nth-child(6)");
    private static final By secondBarLocator = By.cssSelector("div.wg-cell.wg-cell--md-6.wg-cell--lg-7 > div > form > div:nth-child(8)");
    private static final By thirdBarLocator = By.cssSelector("div.wg-cell.wg-cell--md-6.wg-cell--lg-7 > div > form > div:nth-child(10)");
    private static final By socialList = By.xpath("//li[@class='wg-footer__social-item']//a");
    private static final By socialIcons = By.cssSelector("[class='wg-footer__social-icon'] > use");
    private static final String EXPECTED_URL = "Thank you for choosing Wrike!";

    public ResendPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Step("Check with assertion that you are moved to the next page")
    public void fifthStep() {
        assertEquals(EXPECTED_URL, driver.getTitle());
    }

    @Step("Fill in the Q&A section at the left part of page (like random generated answers) + check with assertion that your answers are submitted")
    @Flaky
    public void sixthStep() {
        RandomFill autofill = new RandomFill();
        
        WebElement firstBar = driver.findElement(firstBarLocator);
        WebElement secondBar = driver.findElement(secondBarLocator);
        WebElement thirdBar = driver.findElement(thirdBarLocator);
        
        autofill.fill(firstBar);
        autofill.fill(secondBar);
        autofill.fill(thirdBar);


    }

    @Step("Check with assertion that your answers are submitted")
    public void seventhStep() {
        WebElement submitbutton = driver.findElement(submitData);
        assertTrue(submitbutton.isEnabled());
        driver.findElement(submitData).click();
    }
    
    @Step("Check that 'Follow us' contains the Media button")
    public void eighthStep() {
        List<WebElement> socialButtonsList = driver.findElements(socialList);

        int indexUrl = -1;

        for (int i = 0; i < socialButtonsList.size(); i++) {
            if (socialButtonsList.get(i).getAttribute("href").equals("https://twitter.com/wrike")) {
                indexUrl = i;
                break;
            }

        }
        assertTrue(indexUrl >= 0);

    }

    @Step("Check that Twitter button has the correct logo")
    @Flaky
    public void ninthStep() {     
        List<WebElement> socialIconsList = driver.findElements(socialIcons);
        int index = -1;

        for (int i = 0; i < socialIconsList.size(); i++) {
            if (socialIconsList.get(i).getAttribute("xlink:href").contains("footer-icons.symbol.svg?v2#twitter")) {
                index = i;
                break;
            }
        }
        assertTrue(index >= 0);
    }
}
