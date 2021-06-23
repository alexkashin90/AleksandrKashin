package ru.training.at.hw4.tests.steps;

import static org.testng.Assert.assertEquals;

import io.qameta.allure.Step;
import ru.training.at.hw4.pages.AbstractPage;
import ru.training.at.hw4.pages.HomePage;
import ru.training.at.hw4.pages.LoggedInHomePage;

public class HomePageSteps {

    @Step("Check if 'HomePage' title is correct")
    public static void checkThatHomePageTitleIsCorrect(AbstractPage page, String expected) {
        assertEquals(page.getTitle(), expected);
    }

    @Step("Log in user")
    public static LoggedInHomePage logInUser(HomePage page) {
        return page.logIn();
    }
}
