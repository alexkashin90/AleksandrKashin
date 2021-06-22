package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.data.FailTestData;
import ru.training.at.hw4.tests.steps.HomePageSteps;

@Feature("Failing test")
@Story("Testing Home page title with wrong data")
public class FailTest extends BaseTest {

    @Test
    public void testWrongHomePageTitle() {
        HomePageSteps.checkThatHomePageTitleIsCorrect(homePage, FailTestData.WRONG_PAGE_TITLE);
    }
}
