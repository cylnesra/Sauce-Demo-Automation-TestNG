package org.example.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class ReusableMethods {

    WebDriver driver;
    WebDriverWait wait;

    public ReusableMethods(){
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    public void clickMethod(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    public void type(WebElement locator,String text){
        wait.until(ExpectedConditions.visibilityOf(locator));
        locator.sendKeys(text);
    }

    public String getText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public String getValue(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute("value");
    }

//    public void performMoveToElement(WebElement element) {
//        actions.moveToElement(element).perform();
//    }
//
//    public List<WebElement> findAll(By locator){
//        return driver.findElements(locator);
//    }
}
