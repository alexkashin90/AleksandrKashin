package ru.training.at.hw3.tests.ex1;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.data.HomePageTestData;
import ru.training.at.hw3.tests.BaseTest;
import ru.training.at.hw3.tests.steps.LoggedInHomePageSteps;

public class ContentOfHomePageTest extends BaseTest {

    String originalPageHandle;

    //5. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 2)
    public void testHeaderSectionLinks() {
        //Assert that there are 4 items on the header section are displayed
        LoggedInHomePageSteps.checkThatHeaderLinksAreDisplayed(loggedInHomePage,
                HomePageTestData.HEADER_LINKS_TEXTS.size());
        LoggedInHomePageSteps.checkThatHeaderLinksHaveProperTexts(loggedInHomePage,
                HomePageTestData.HEADER_LINKS_TEXTS);
    }

    //6. Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 3)
    public void testFourImagesExist() {
        LoggedInHomePageSteps.checkThatImagesAreDisplayed(loggedInHomePage,
                HomePageTestData.NUMBER_OF_IMAGES);
    }

    //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 4)
    public void testTextsBelowImages() {
        LoggedInHomePageSteps.checkThatTextsBelowImagesAreDisplayed(loggedInHomePage,
                HomePageTestData.TEXTS_BELOW_IMAGES.size());
        LoggedInHomePageSteps.checkThatTextsBelowImagesAreProper(loggedInHomePage,
                HomePageTestData.TEXTS_BELOW_IMAGES);
    }

    //8. Assert that there is the iframe with “Frame Button” exist
    @Test(priority = 5)
    public void testIFrameExists() {
        LoggedInHomePageSteps.checkThatIFrameIsDisplayed(loggedInHomePage);
        originalPageHandle = driver.getWindowHandle();
    }

    // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
    @Test(priority = 6)
    public void testFrameButtonExists() {
        driver.switchTo().frame(loggedInHomePage.getIframe());
        LoggedInHomePageSteps.checkThatIframeButtonIsDisplayed(loggedInHomePage);
        driver.switchTo().parentFrame();
    }

    // 10. Switch to original window back
    @Test(priority = 7)
    public void testSwitchedBackToOriginalWindow() {
        String currentHandle = driver.getWindowHandle();
        Assert.assertEquals(originalPageHandle, currentHandle);
    }

    // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test(priority = 8)
    public void testLeftSectionItems() {
        LoggedInHomePageSteps.checkThatLeftSectionItemsAreDisplayed(loggedInHomePage,
                HomePageTestData.LEFT_SECTION_ITEMS_TEXTS.size());
        LoggedInHomePageSteps.checkThatLeftSectionItemsHaveProperTexts(loggedInHomePage,
                HomePageTestData.LEFT_SECTION_ITEMS_TEXTS);
    }
}
