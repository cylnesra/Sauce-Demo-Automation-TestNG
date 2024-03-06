package org.example.tests;

import org.example.dataprovider.JsonDataProvider;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @Test(  priority = 1,
            description = "Verify that the home page loads successfully")
    public void  verifyHomePageLoadsSuccessfully(){
        loginPage = new LoginPage();
        Assert.assertEquals(loginPage.correctWebSite(),"Accepted usernames are:",
                                                       "Home page didn't load successfully");
    }

    @Test(  priority = 2,
            description = "Verifying that user logins are successful",
            dataProvider = "viaJsonSource", dataProviderClass = JsonDataProvider.class)
    public void verifyUserLoginIsSuccessful(Object loginData){
        Map<String, Object> loginMap = (Map<String, Object>)  loginData;
        String userName = (String) loginMap.get("username");
        String userPassword = (String) loginMap.get("password");
        loginPage = new LoginPage();

        loginPage.setUserName(userName);
        Assert.assertEquals(userName,loginPage.getUserName(),"Username value is not correct!");

        loginPage.setUserPassword(userPassword);
        Assert.assertEquals(userPassword,loginPage.getPassword(),"Password value is not correct!");

        loginPage.loginButtonClick();
        Assert.assertEquals(loginPage.loginVerify(),"Products","Login was not successful");
    }
}
