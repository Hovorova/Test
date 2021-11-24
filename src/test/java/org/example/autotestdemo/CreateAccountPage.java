package org.example.autotestdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    @FindBy(xpath = "//*[contains(@id, 'email')]")
    private WebElement email;
    @FindBy(xpath = "//*[contains(@id, 'password')]")
    private WebElement password;
    @FindBy(xpath = "//*[contains(@id, 'confirmPassword')]")
    private WebElement confirmPassword;
    @FindBy(xpath = "/html/body/div[2]/form/div[4]/button")
    private WebElement createAccount;
    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterEmail(String input) {
        email.sendKeys(input);
    }

    public void enterPassword(String input) {
        password.sendKeys(input);
    }

    public void confirmPassword(String input) {
        confirmPassword.sendKeys(input);
    }

    public void createAccount() {
        createAccount.click();
    }
}
