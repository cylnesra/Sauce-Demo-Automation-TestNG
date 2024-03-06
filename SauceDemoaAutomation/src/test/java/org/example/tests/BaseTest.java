package org.example.tests;

import org.example.utilities.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected String baseURL = "https://www.saucedemo.com/";
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        DriverManager.getDriver().get(baseURL);
        DriverManager.getDriver().manage().window().maximize();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() {
        softAssert.assertAll();
        DriverManager.quitDriver();
    }
}
