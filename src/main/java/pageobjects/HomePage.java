package pageobjects;

import elements.TrainItem;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private AppiumDriver<MobileElement> driver;
    private By inputFrom = By.xpath("//input[@name='from-title']");
    private By inputTo = By.xpath("//input[@name='to-title']");
    private By submit = By.cssSelector("button[type='submit']");
    private By trainItem = By.cssSelector("div[class='item']");

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public HomePage setFrom(String text) {
        MobileElement element = driver.findElement(inputFrom);
        element.click();
        driver.hideKeyboard();
        element.sendKeys(text);
        return this;
    }

    public HomePage setTo(String text) {
        MobileElement element = driver.findElement(inputTo);
        element.click();
        driver.hideKeyboard();
        element.sendKeys(text);
        return this;
    }

    public void submit() {
        driver.findElement(submit).click();
    }

    public ArrayList<TrainItem> getTrains() {
        ArrayList<TrainItem> trains = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        ArrayList<WebElement> elements = (ArrayList<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(trainItem));
//        ArrayList<MobileElement> elements = (ArrayList<MobileElement>) driver.findElements(trainItem);

        for (int i = 0; i < elements.size(); i++) {
            System.out.println(String.format("Number on page %d: %s", i, elements.get(i).getText()));
            trains.add(new TrainItem(elements.get(i)));
        }
        return trains;
    }
}