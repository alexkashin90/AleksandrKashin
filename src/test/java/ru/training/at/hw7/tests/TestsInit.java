package ru.training.at.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;

import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw7.JdiSite;
import ru.training.at.hw7.model.User;
import ru.training.at.hw7.utils.UserManager;

public class TestsInit {

    protected static SoftAssert softAssert = new SoftAssert();
    protected static User user = UserManager.createUser();

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        PageFactory.initSite(JdiSite.class);
        JdiSite.open();
        JdiSite.login(user);
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
