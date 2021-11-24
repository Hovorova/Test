package org.example.autotestdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "/html/body/div[1]/div/div/ul[2]/li/a/span")
    private WebElement username;
    @FindBy(xpath = "/html/body/div[1]/div/div/ul[2]/li/div/a[2]")
    private WebElement logout;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getUsername() {
        return username.getText();
    }

    public void logout() {
        username.click();
        logout.click();
    }
}
