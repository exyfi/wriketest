package generator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class RandomFill {
    public void fill(WebElement Bar){
        Random random = new Random();
        List<WebElement> items = Bar.findElements(By.tagName("button"));
        int index = random.nextInt(items.size() - 1);
        items.get(index).click();
    }
}
