package ru.training.at.hw3.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.data.BaseTestData;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.HomePage;
import ru.training.at.hw3.pages.LoggedInHomePage;
import ru.training.at.hw3.tests.steps.HomePageSteps;
import ru.training.at.hw3.tests.steps.LoggedInHomePageSteps;
import ru.training.at.hw3.utils.DriverManager;


public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected LoggedInHomePage loggedInHomePage;
    protected DifferentElementsPage differentElementsPage;
    protected HomePage homePage;

    //Navigate to Home Page
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.createDriver();
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        homePage.openHomePage();
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
