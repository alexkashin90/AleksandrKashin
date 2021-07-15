package ru.training.at.hw7;

import static com.epam.jdi.light.common.CheckTypes.CONTAINS;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw7.model.User;
import ru.training.at.hw7.pages.HomePage;
import ru.training.at.hw7.pages.MetalAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/index.html")
    @Title(value = "Home", validate = CONTAINS)
    public static HomePage homePage;

    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    public static MetalAndColorsPage metalAndColorsPage;

    public static void open() {
        homePage.open();
    }

    public static void login(User user) {
        HomePage.loginUser(user);
    }
}
