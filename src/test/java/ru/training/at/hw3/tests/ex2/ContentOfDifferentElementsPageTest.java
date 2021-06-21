package ru.training.at.hw3.tests.ex2;

import org.testng.annotations.Test;
import ru.training.at.hw3.data.DifferentElementsPageTestData;
import ru.training.at.hw3.tests.BaseTest;
import ru.training.at.hw3.tests.steps.DifferentElementsPageSteps;
import ru.training.at.hw3.tests.steps.LoggedInHomePageSteps;

public class ContentOfDifferentElementsPageTest extends BaseTest {

    //5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 2)
    public void testDifferentElementsPageIsOpened() {
        differentElementsPage = LoggedInHomePageSteps.navigateToDifferentElementsPage(loggedInHomePage);
        DifferentElementsPageSteps.checkIfDifferentElementsPageIsOpened(differentElementsPage,
                DifferentElementsPageTestData.DIFFERENT_ELEMENTS_PAGE_TITLE);
    }

    // 6. Select checkboxes
    @Test(priority = 3)
    public void testCheckboxesAreSelected() {
        DifferentElementsPageSteps.checkIfCheckboxesAreUnchecked(differentElementsPage,
                DifferentElementsPageTestData.WATER_LIST_NUMBER, DifferentElementsPageTestData.WIND_LIST_NUMBER);
        DifferentElementsPageSteps.selectCheckboxes(differentElementsPage,
                DifferentElementsPageTestData.WATER_LIST_NUMBER, DifferentElementsPageTestData.WIND_LIST_NUMBER);
        DifferentElementsPageSteps.checkIfCheckboxesAreChecked(differentElementsPage,
                DifferentElementsPageTestData.WATER_LIST_NUMBER, DifferentElementsPageTestData.WIND_LIST_NUMBER);
    }

    // 7. Select radio
    @Test(priority = 4)
    public void testRadioIsSelected() {
        DifferentElementsPageSteps.selectRadio(differentElementsPage,
                DifferentElementsPageTestData.SELEN_LIST_NUMBER);
        DifferentElementsPageSteps.checkIfRadioIsSelected(differentElementsPage,
                DifferentElementsPageTestData.SELEN_LIST_NUMBER);
    }

    // 8. Select in dropdown
    @Test(priority = 5)
    public void testYellowIsSelectedInDropdown() {
        DifferentElementsPageSteps.selectYellowInDropdown(differentElementsPage,
                DifferentElementsPageTestData.COLOR);
        DifferentElementsPageSteps.checkThatYellowWasSelected(differentElementsPage,
                DifferentElementsPageTestData.COLOR);

    }

    // 9. Assert that
    // for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    // for radio button there is a log row and value is corresponded to the status of radio button
    // for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 6)
    public void testOfLogs() {
        DifferentElementsPageSteps.checkIfLogsAreDisplayed(differentElementsPage,
                DifferentElementsPageTestData.TEXTS_OF_LOGS);
        DifferentElementsPageSteps.checkIfLogsHaveProperTexts(differentElementsPage,
                DifferentElementsPageTestData.TEXTS_OF_LOGS);
    }
}
