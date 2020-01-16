package page;

import generator.EmailGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;
@Epic("Steps 1-4")
@Feature("Testing MainPage Interface")
public class MainPage {
    
    private final WebDriver driver;

    private static final By getStartedFreeButton = By.xpath("//div[@class='wg-header__sticky-mainmenu']//button");
    private static final By completeRegistration = By.xpath("//button[@class='wg-btn wg-btn--blue modal-form-trial__submit']");
    private static final By emailInput = By.xpath("//input[@class='wg-input modal-form-trial__input']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click 'Get started for free' button")
    public void secondStep() {
        driver.findElement(getStartedFreeButton).click();
    }

    @Step("Open url: wrike.com")
    public void firstStep(String page) {
        driver.get(page);

    }

    @Step("Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa")
    public void thirdStep() {
        WebElement element = driver.findElement(emailInput);
        assertTrue(element.isDisplayed());
        String randomEmail = new EmailGenerator().generate();
        driver.findElement(emailInput).sendKeys(randomEmail);
    }


    @Step("Click on 'Create my Wrike account' button + check with assertion that you are moved to the next page;")
    public void fourthStep() {
        WebElement element = driver.findElement(completeRegistration);
        assertTrue(element.isDisplayed());
        driver.findElement(completeRegistration).click();
    }
}
