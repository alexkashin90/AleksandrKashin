package ru.training.at.hw3.tests.steps;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.stream.IntStream;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.LoggedInHomePage;

public class LoggedInHomePageSteps {
    private static final SoftAssert softAssert = new SoftAssert();

    public static void checkThatUserNameIsCorrect(LoggedInHomePage page, String expected) {
        assertEquals(page.getUserName(), expected);
    }

    public static void checkThatHeaderLinksAreDisplayed(LoggedInHomePage page, int expectedNumberOfLinks) {
        List<WebElement> headerSectionElements = page.getHeaderSectionElements();
        softAssert.assertEquals(headerSectionElements.size(), expectedNumberOfLinks);
        for (WebElement webElement : headerSectionElements) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    public static void checkThatHeaderLinksHaveProperTexts(LoggedInHomePage page, List<String> expectedTexts) {
        List<WebElement> headerSectionElements = page.getHeaderSectionElements();
        IntStream.range(0, headerSectionElements.size())
                .forEachOrdered(index -> softAssert.assertTrue(
                        headerSectionElements.get(index).getText()
                                .contains(expectedTexts.get(index))
                ));
        softAssert.assertAll();
    }

    public static void checkThatImagesAreDisplayed(LoggedInHomePage page, int expectedNumberOfImages) {
        softAssert.assertEquals(page.getImages().size(), expectedNumberOfImages);
        for (WebElement webElement : page.getImages()) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    public static void checkThatTextsBelowImagesAreDisplayed(LoggedInHomePage page,
                                                             int expectedNumberOfTexts) {
        List<WebElement> textsBelowImages = page.getTextsBelowImages();
        softAssert.assertEquals(textsBelowImages.size(), expectedNumberOfTexts);
        for (WebElement webElement : textsBelowImages) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    public static void checkThatThatTextsBelowImagesAreProper(LoggedInHomePage page,
                                                              List<String> expectedTexts) {
        List<WebElement> textsBelowImages = page.getTextsBelowImages();
        IntStream.range(0, textsBelowImages.size())
                .forEachOrdered(index -> softAssert.assertTrue(
                        textsBelowImages.get(index).getText()
                                .contains(expectedTexts.get(index))
                ));
        softAssert.assertAll();
    }

    public static void checkThatIFrameIsDisplayed(LoggedInHomePage page) {
        softAssert.assertTrue(page.getIframe().isDisplayed());
    }

    public static void checkThatIframeButtonIsDisplayed(LoggedInHomePage page) {
        softAssert.assertTrue(page.getFrameButton().isDisplayed());
    }

    public static void checkThatLeftSectionItemsAreDisplayed(LoggedInHomePage page, int expectedNumberOfLinks) {
        List<WebElement> leftSectionElements = page.getLeftSectionElements();
        softAssert.assertEquals(leftSectionElements.size(), expectedNumberOfLinks);
        for (WebElement webElement : leftSectionElements) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

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

    public static DifferentElementsPage navigateToDifferentElementsPage(LoggedInHomePage page) {
        return page.clickDiffElementsPageLink();
    }

}