package ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class GeneralConditions {
    protected WebDriver driver;
    protected  final String homePageURL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected String originalHandle;
    protected final SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(homePageURL);
        originalHandle = driver.getWindowHandle();
    }

    //2. Assert Browser title
    @Test
    public void testHomePageTitle() {
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        softAssert.assertAll();
    }

    //3. Perform login
    //4. Assert Username is logged
    @Test(priority = 1, dataProvider = "UserData",
            dataProviderClass = TestDataProvider.class)
    public void testUserIsLoggedIn(String userName, String pass) {

        //Perform login
        driver.findElement(By.cssSelector("div.profile-photo")).click();
        driver.findElement(By.cssSelector("input#name")).sendKeys(userName);
        driver.findElement(By.cssSelector("input#password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button#login-button")).click();

        //Assert Username is logged
        String actualUserName = driver.findElement(By.cssSelector("span#user-name")).getText();
        softAssert.assertEquals(actualUserName, "ROMAN IOVLEV");
        softAssert.assertAll();
    }

    //12 or 10. Close browser
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
