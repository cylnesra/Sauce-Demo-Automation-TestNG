package org.example.pages;

import org.example.utilities.Locators;
import org.example.utilities.ReusableMethods;

public class LoginPage extends ReusableMethods{
    public Locators locators;
    public LoginPage() {
        this.locators = new Locators();
    }

    public void setUserName(String username){
       type(locators.userNameLocator,username);
    }

    public void setUserPassword(String userPassword) {
        type(locators.userPasswordLocator,userPassword);
    }

    public String getUserName(){
        return getValue(locators.userNameLocator);
    }

    public String getPassword(){
        return getValue(locators.userPasswordLocator);
    }

    public void loginButtonClick(){
        clickMethod(locators.loginButtonLocator);
    }

    public String correctWebSite(){
        return getText(locators.correctAdress);
    }

    public String loginVerify(){
        return getText(locators.loginVerify);
    }
}
