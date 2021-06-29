package ru.training.at.hw6.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw6.data.BaseTestData;
import ru.training.at.hw6.driver.WebDriverSingleton;
import ru.training.at.hw6.pages.DifferentElementsPage;
import ru.training.at.hw6.pages.HomePage;
import ru.training.at.hw6.pages.LoggedInHomePage;
import ru.training.at.hw6.tests.listeners.Listener;
import ru.training.at.hw6.tests.steps.HomePageSteps;
import ru.training.at.hw6.tests.steps.LoggedInHomePageSteps;

@Listeners({Listener.class})
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
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
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
        WebDriverSingleton.closeDriver();
    }
}
