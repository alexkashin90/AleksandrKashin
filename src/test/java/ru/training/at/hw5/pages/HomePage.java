package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.data.TestData;
import ru.training.at.hw5.model.User;
import ru.training.at.hw5.utils.UserManager;


public class HomePage extends AbstractPage {

    @FindBy(id = "user-icon")
    private  static WebElement userIcon;
    @FindBy(id = "name")
    private static WebElement name;
    @FindBy(id = "password")
    private static WebElement password;
    @FindBy(id = "login-button")
    private static WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        driver.get(TestData.PAGE_URL);
        return this;
    }

    public LoggedInHomePage logIn() {
        User user = UserManager.createUser();
        userIcon.click();
        name.sendKeys(user.getUsername());
        password.sendKeys(user.getPassword());
        loginButton.click();
        return new LoggedInHomePage(driver);
    }

}
