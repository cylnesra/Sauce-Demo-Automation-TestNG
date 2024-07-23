package org.example.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Locators {
    public Locators() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='login_credentials']/h4")
    public WebElement correctAdress;
    @FindBy(id="user-name")
    public WebElement userNameLocator;

    @FindBy(id="password")
    public WebElement userPasswordLocator;

    @FindBy(id = "login-button")
    public WebElement loginButtonLocator;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement loginVerify;

}

