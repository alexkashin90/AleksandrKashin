package ru.training.at.hw3.tests.steps;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.stream.IntStream;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.AbstractPage;
import ru.training.at.hw3.pages.DifferentElementsPage;

public class DifferentElementsPageSteps {

    private static final SoftAssert softAssert = new SoftAssert();

    public static void checkIfDifferentElementsPageIsOpened(AbstractPage page, String expected) {
        softAssert.assertEquals(page.getTitle(), expected);
    }

    public static void checkIfCheckboxesAreUnchecked(DifferentElementsPage page, int waterListNumber,
                                                     int windListNumber) {
        softAssert.assertFalse(page.waterIsChecked(waterListNumber));
        softAssert.assertFalse(page.windIsChecked(windListNumber));
        softAssert.assertAll();
    }

    public static void selectCheckboxes(DifferentElementsPage page, int waterListNumber,
                                        int windListNumber) {
        page.clickWaterCheckbox(waterListNumber);
        page.clickWindCheckbox(windListNumber);
    }

    public static void checkIfCheckboxesAreChecked(DifferentElementsPage page, int waterListNumber,
                                                   int windListNumber) {
        softAssert.assertTrue(page.waterIsChecked(waterListNumber));
        softAssert.assertTrue(page.windIsChecked(windListNumber));
        softAssert.assertAll();
    }

    public static void selectRadio(DifferentElementsPage page, int selenListNumber) {
        page.selectSelenRadio(selenListNumber);
    }

    public static void checkIfRadioIsSelected(DifferentElementsPage page, int selenListNumber) {
        softAssert.assertTrue(page.selenRadioIsChecked(selenListNumber));
    }

    public static void selectYellowInDropdown(DifferentElementsPage page, String color) {
        page.selectColor(color);
    }

    public static void checkThatYellowWasSelected(DifferentElementsPage page, String color) {
        assertEquals(page.getFirstSelectedColor(), color);
    }


    public static void checkIfLogsAreDisplayed(DifferentElementsPage page, List<String> expectedTexts) {
        List<WebElement> logs = page.getLogs();
        softAssert.assertEquals(logs.size(), expectedTexts.size());
        for (WebElement webElement : logs) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    public static void checkIfLogsHaveProperTexts(DifferentElementsPage page, List<String> expectedTexts) {
        List<WebElement> logs = page.getLogs();
        IntStream.range(0, logs.size())
                .forEachOrdered(index -> softAssert.assertTrue(
                        logs.get(index).getText()
                                .contains(expectedTexts.get(index))
                ));
        softAssert.assertAll();
    }
}
