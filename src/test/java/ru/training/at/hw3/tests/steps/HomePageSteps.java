package ru.training.at.hw3.tests.steps;

import static org.testng.Assert.assertEquals;

import ru.training.at.hw3.pages.AbstractPage;
import ru.training.at.hw3.pages.HomePage;
import ru.training.at.hw3.pages.LoggedInHomePage;

public class HomePageSteps {

    public static void checkThatHomePageTitleIsCorrect(AbstractPage page, String expected) {
        assertEquals(page.getTitle(), expected);
    }

    public static LoggedInHomePage logInUser(HomePage page) {
        return page.logIn();
    }
}
