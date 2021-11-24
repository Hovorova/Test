package org.example.autotestdemo;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CreateAccountTest {
    private static HomePage homePage;
    private static CreateAccountPage createAccountPage;

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", TestResource.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TestResource.getProperty("createaccountpage"));

        homePage = new HomePage(driver);
        createAccountPage = new CreateAccountPage(driver);
    }

    @Test
    public void createAccountTest() {
        String email = UUID.randomUUID() + "@testmail.com";
        String password = UUID.randomUUID().toString();

        createAccountPage.enterEmail(email);
        createAccountPage.enterPassword(password);
        createAccountPage.confirmPassword(password);
        createAccountPage.createAccount();

        Assert.assertEquals(email, homePage.getUsername().toLowerCase());
    }

    @AfterClass
    public static void tearDown() {
        homePage.logout();
        driver.quit();
    }
}
