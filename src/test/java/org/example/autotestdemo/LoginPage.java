package org.example.autotestdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//*[contains(@id, 'email')]")
    private WebElement email;
    @FindBy(xpath = "//*[contains(@id, 'password')]")
    private WebElement password;
    @FindBy(xpath = "/html/body/div[2]/form/div[3]/div/button/i")
    private WebElement loginButton;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterEmail(String input) {
        email.sendKeys(input);
    }

    public void enterPassword(String input) {
        password.sendKeys(input);
    }

    public void login() {
        loginButton.click();
    }
}
