package ru.training.at.hw6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw6.data.BaseTestData;
import ru.training.at.hw6.model.User;
import ru.training.at.hw6.utils.UserManager;


public class HomePage extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        driver.get(BaseTestData.PAGE_URL);
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
