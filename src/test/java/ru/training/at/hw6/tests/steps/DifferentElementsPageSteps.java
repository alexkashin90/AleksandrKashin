package ru.training.at.hw6.tests.steps;

import static org.testng.Assert.assertEquals;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.IntStream;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw6.pages.AbstractPage;
import ru.training.at.hw6.pages.DifferentElementsPage;

public class DifferentElementsPageSteps {

    private static final SoftAssert softAssert = new SoftAssert();

    @Step("Chek that 'Different Elements' page is opened")
    public static void checkThatDifferentElementsPageIsOpened(AbstractPage page, String expected) {
        softAssert.assertEquals(page.getTitle(), expected);
    }

    @Step("Check that 'water' and 'wind' checkboxes are unchecked")
    public static void checkThatCheckboxesAreUnchecked(DifferentElementsPage page, int waterListNumber,
                                                       int windListNumber) {
        softAssert.assertFalse(page.isWaterChecked(waterListNumber));
        softAssert.assertFalse(page.isWindChecked(windListNumber));
        softAssert.assertAll();
    }

    @Step("Select 'water' and 'wind' checkboxes")
    public static void selectCheckboxes(DifferentElementsPage page, int waterListNumber,
                                        int windListNumber) {
        page.clickWaterCheckbox(waterListNumber);
        page.clickWindCheckbox(windListNumber);
    }

    @Step("Check that 'water' and 'wind' checkboxes are checked")
    public static void checkThatCheckboxesAreChecked(DifferentElementsPage page, int waterListNumber,
                                                     int windListNumber) {
        softAssert.assertTrue(page.isWaterChecked(waterListNumber));
        softAssert.assertTrue(page.isWindChecked(windListNumber));
        softAssert.assertAll();
    }

    @Step("Select 'selen' radio")
    public static void selectRadio(DifferentElementsPage page, int selenListNumber) {
        page.selectSelenRadio(selenListNumber);
    }

    @Step("Check that 'selen' radio is selected")
    public static void checkThatRadioIsSelected(DifferentElementsPage page, int selenListNumber) {
        softAssert.assertTrue(page.isSelenRadioChecked(selenListNumber));
    }

    @Step("Select 'Yellow' color in dropdown")
    public static void selectYellowInDropdown(DifferentElementsPage page, String color) {
        page.selectColor(color);
    }

    @Step("Check that 'Yellow' color is selected")
    public static void checkThatYellowWasSelected(DifferentElementsPage page, String color) {
        assertEquals(page.getFirstSelectedColor(), color);
    }

    @Step("Check that logs are displayed")
    public static void checkThatLogsAreDisplayed(DifferentElementsPage page, List<String> expectedTexts) {
        List<WebElement> logs = page.getLogs();
        softAssert.assertEquals(logs.size(), expectedTexts.size());
        for (WebElement webElement : logs) {
            softAssert.assertTrue(webElement.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check that logs have proper texts")
    public static void checkThatLogsHaveProperTexts(DifferentElementsPage page, List<String> expectedTexts) {
        List<WebElement> logs = page.getLogs();
        IntStream.range(0, logs.size())
                .forEachOrdered(index -> softAssert.assertTrue(
                        logs.get(index).getText()
                                .contains(expectedTexts.get(index))
                ));
        softAssert.assertAll();
    }
}
