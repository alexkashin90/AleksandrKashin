package ru.training.at.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import ru.training.at.hw7.model.User;
import ru.training.at.hw7.pages.forms.LogInForm;

public class HomePage extends WebPage {

    private static LogInForm loginForm;

    @Css("#user-icon")
    private static Icon userIcon;

    @Css("#user-name")
    private static Label userName;

    @FindBy(linkText = "Metals & Colors")
    private static Button metalsColorsPageButton;

    public static void loginUser(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public static String getUserName() {
        return userName.getText();
    }

    public void openMetalsColorsPage() {
        metalsColorsPageButton.click();
    }

}
