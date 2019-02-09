package elements;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TrainItem {

    private WebElement element;
    private By title = By.cssSelector("span");

    public TrainItem(WebElement element) {
        this.element = element;
    }

    public void clickOnTitle() {
        System.out.println(String.format("Click on %s", element.getText()));
        element.findElement(title).click();
    }


}
