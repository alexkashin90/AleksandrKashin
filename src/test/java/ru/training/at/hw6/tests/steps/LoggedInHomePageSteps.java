package ru.training.at.hw6.tests.steps;

import static org.testng.Assert.assertEquals;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.IntStream;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw6.pages.DifferentElementsPage;
import ru.training.at.hw6.pages.LoggedInHomePage;

public class LoggedInHomePageSteps {
    private static final SoftAssert softAssert = new SoftAssert();

    @Step("Check that user name is correct")
    public static void checkThatUserNameIsCorrect(LoggedInHomePage page, String expected) {
        assertEquals(page.getUserName(), expected);
    }

    @Step("Check that header links are displayed")
    public static void checkThatHeaderLinksAreDisplayed(LoggedInHomePage page, int expectedNumberOfLinks) {
        List<WebElement> headerSectionElements = page.getHeaderSectionElements();
        softAssert.assertEquals(headerSectionElements.size(), expectedNumberOfLinks);
        for (WebElement webElement : headerSectionElements) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check that header links have proper texts")
    public static void checkThatHeaderLinksHaveProperTexts(LoggedInHomePage page, List<String> expectedTexts) {
        List<WebElement> headerSectionElements = page.getHeaderSectionElements();
        IntStream.range(0, headerSectionElements.size())
                .forEachOrdered(index -> softAssert.assertTrue(
                        headerSectionElements.get(index).getText()
                                .contains(expectedTexts.get(index))
                ));
        softAssert.assertAll();
    }

    @Step("Check that images are displayed")
    public static void checkThatImagesAreDisplayed(LoggedInHomePage page, int expectedNumberOfImages) {
        softAssert.assertEquals(page.getImages().size(), expectedNumberOfImages);
        for (WebElement webElement : page.getImages()) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check that texts below images are displayed")
    public static void checkThatTextsBelowImagesAreDisplayed(LoggedInHomePage page,
                                                             int expectedNumberOfTexts) {
        List<WebElement> textsBelowImages = page.getTextsBelowImages();
        softAssert.assertEquals(textsBelowImages.size(), expectedNumberOfTexts);
        for (WebElement webElement : textsBelowImages) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check that texts below images are proper")
    public static void checkThatTextsBelowImagesAreProper(LoggedInHomePage page,
                                                          List<String> expectedTexts) {
        List<WebElement> textsBelowImages = page.getTextsBelowImages();
        IntStream.range(0, textsBelowImages.size())
                .forEachOrdered(index -> softAssert.assertTrue(
                        textsBelowImages.get(index).getText()
                                .contains(expectedTexts.get(index))
                ));
        softAssert.assertAll();
    }

    @Step("Check that IFrame is displayed")
    public static void checkThatIFrameIsDisplayed(LoggedInHomePage page) {
        softAssert.assertTrue(page.getIframe().isDisplayed());
    }

    @Step("Check that Iframe button is displayed")
    public static void checkThatIframeButtonIsDisplayed(LoggedInHomePage page) {
        softAssert.assertTrue(page.getFrameButton().isDisplayed());
    }

    @Step("Check that left section items are displayed")
    public static void checkThatLeftSectionItemsAreDisplayed(LoggedInHomePage page, int expectedNumberOfLinks) {
        List<WebElement> leftSectionElements = page.getLeftSectionElements();
        softAssert.assertEquals(leftSectionElements.size(), expectedNumberOfLinks);
        for (WebElement webElement : leftSectionElements) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check that left section items have proper texts")
    public static void checkThatLeftSectionItemsHaveProperTexts(LoggedInHomePage page,
                                                                List<String> expectedTexts) {
        List<WebElement> leftSectionElements = page.getLeftSectionElements();
        IntStream.range(0, leftSectionElements.size())
                .forEachOrdered(index -> softAssert.assertTrue(
                        leftSectionElements.get(index).getText()
                                .contains(expectedTexts.get(index))
                ));
        softAssert.assertAll();
    }

    @Step("Navigate to different elements page")
    public static DifferentElementsPage navigateToDifferentElementsPage(LoggedInHomePage page) {
        return page.clickDiffElementsPageLink();
    }

}
