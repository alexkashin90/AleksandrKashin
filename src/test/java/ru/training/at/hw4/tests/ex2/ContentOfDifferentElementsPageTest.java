package ru.training.at.hw4.tests.ex2;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.data.DifferentElementsPageTestData;
import ru.training.at.hw4.tests.BaseTest;
import ru.training.at.hw4.tests.steps.DifferentElementsPageSteps;
import ru.training.at.hw4.tests.steps.LoggedInHomePageSteps;

@Feature("Tests for Exercise #2")
@Story("Testing elements of Different Elements page")
public class ContentOfDifferentElementsPageTest extends BaseTest {

    //5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 2)
    public void testDifferentElementsPageIsOpened() {
        differentElementsPage = LoggedInHomePageSteps.navigateToDifferentElementsPage(loggedInHomePage);
        DifferentElementsPageSteps.checkThatDifferentElementsPageIsOpened(differentElementsPage,
                DifferentElementsPageTestData.DIFFERENT_ELEMENTS_PAGE_TITLE);
    }

    // 6. Select checkboxes
    @Test(priority = 3)
    public void testCheckboxesAreSelected() {
        DifferentElementsPageSteps.checkThatCheckboxesAreUnchecked(differentElementsPage,
                DifferentElementsPageTestData.WATER_LIST_NUMBER, DifferentElementsPageTestData.WIND_LIST_NUMBER);
        DifferentElementsPageSteps.selectCheckboxes(differentElementsPage,
                DifferentElementsPageTestData.WATER_LIST_NUMBER, DifferentElementsPageTestData.WIND_LIST_NUMBER);
        DifferentElementsPageSteps.checkThatCheckboxesAreChecked(differentElementsPage,
                DifferentElementsPageTestData.WATER_LIST_NUMBER, DifferentElementsPageTestData.WIND_LIST_NUMBER);
    }

    // 7. Select radio
    @Test(priority = 4)
    public void testRadioIsSelected() {
        DifferentElementsPageSteps.selectRadio(differentElementsPage,
                DifferentElementsPageTestData.SELEN_LIST_NUMBER);
        DifferentElementsPageSteps.checkThatRadioIsSelected(differentElementsPage,
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
        DifferentElementsPageSteps.checkThatLogsAreDisplayed(differentElementsPage,
                DifferentElementsPageTestData.TEXTS_OF_LOGS);
        DifferentElementsPageSteps.checkThatLogsHaveProperTexts(differentElementsPage,
                DifferentElementsPageTestData.TEXTS_OF_LOGS);
    }
}
