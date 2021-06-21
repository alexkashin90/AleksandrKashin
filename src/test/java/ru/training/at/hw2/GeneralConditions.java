package ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.data.TestData;

public class GeneralConditions {
    protected final SoftAssert softAssert = new SoftAssert();
    protected WebDriver driver;
    protected String originalHandle;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(TestData.HOME_PAGE_URL);
        originalHandle = driver.getWindowHandle();
    }

    //2. Assert Browser title
    @Test
    public void checkHomePageTitleText() {
        softAssert.assertEquals(driver.getTitle(), TestData.HOME_PAGE_TITLE);
        softAssert.assertAll();
    }

    //3. Perform login
    public void performLogIn() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(TestData.LOGIN);
        driver.findElement(By.id("password")).sendKeys(TestData.PASSWORD);
        driver.findElement(By.id("login-button")).click();
    }

    //4. Assert Username is logged
    @Test(priority = 1)
    public void checkIfUserIsLoggedIn() {
        performLogIn();
        String actualUserName = driver.findElement(By.id("user-name")).getText();
        softAssert.assertEquals(actualUserName, TestData.USERNAME);
        softAssert.assertAll();
    }

    //12 or 10. Close browser
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

    public void compareTexts(List<WebElement> webElements, List<String> expectedTexts) {
        IntStream.range(0, webElements.size())
                .forEachOrdered(index -> softAssert.assertTrue(
                        webElements.get(index).getText()
                                .contains(expectedTexts.get(index))
                ));
        softAssert.assertAll();
    }

    public void checkIfElementsAreDisplayed(List<WebElement> webElements) {
        for (WebElement webElement : webElements) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }
}
