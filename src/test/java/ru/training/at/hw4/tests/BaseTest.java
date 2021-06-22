package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.data.BaseTestData;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.pages.HomePage;
import ru.training.at.hw4.pages.LoggedInHomePage;
import ru.training.at.hw4.tests.steps.HomePageSteps;
import ru.training.at.hw4.tests.steps.LoggedInHomePageSteps;
import ru.training.at.hw4.utils.DriverManager;

@Feature("Base test for Exercise #1 and Exercise #2")
@Story("Testing Home page title logging of the user")
public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected LoggedInHomePage loggedInHomePage;
    protected DifferentElementsPage differentElementsPage;
    protected HomePage homePage;


    //Navigate to Home Page
    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) {
        driver = DriverManager.createDriver();
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        homePage.openHomePage();
        testContext.setAttribute("driver", driver);
    }

    //2. Assert Browser title
    @Test
    public void testHomePageTitle() {
        HomePageSteps.checkThatHomePageTitleIsCorrect(homePage, BaseTestData.PAGE_TITLE);
    }

    //3. Perform login
    //4. Assert Username is logged
    @Test(priority = 1)
    public void testUserIsLoggedIn() {
        loggedInHomePage = HomePageSteps.logInUser(homePage);
        LoggedInHomePageSteps.checkThatUserNameIsCorrect(loggedInHomePage, BaseTestData.USERNAME);
    }

    //12 or 10. Close browser
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
