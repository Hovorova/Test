package org.example.autotestdemo;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static CreateAccountPage createAccountPage;

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", TestResource.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TestResource.getProperty("loginpage"));

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        loginPage.enterEmail(TestResource.getProperty("email"));
        loginPage.enterPassword(TestResource.getProperty("password"));
        loginPage.login();
        Assert.assertEquals(TestResource.getProperty("email"), homePage.getUsername().toLowerCase());
    }

    @AfterClass
    public static void tearDown() {
        homePage.logout();
        driver.quit();
    }
}
