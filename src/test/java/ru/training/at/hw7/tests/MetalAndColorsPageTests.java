package ru.training.at.hw7.tests;

import org.testng.annotations.Test;
import ru.training.at.hw7.JdiSite;
import ru.training.at.hw7.data.MetalAndColorsData;
import ru.training.at.hw7.data.MetalAndColorsPageDataProvider;
import ru.training.at.hw7.data.TestData;
import ru.training.at.hw7.pages.HomePage;

public class MetalAndColorsPageTests extends TestsInit {

    @Test(dataProvider = "MetalAndColorsPageTestData",
          dataProviderClass = MetalAndColorsPageDataProvider.class)
    public void metalAndColorsPageTest(MetalAndColorsData data) {
        softAssert.assertEquals(HomePage.getUserName(), user.getFullName());
        JdiSite.homePage.openMetalsColorsPage();
        softAssert.assertEquals(JdiSite.metalAndColorsPage.title, TestData.METAL_AND_COLORS_PAGE_TITLE);
        JdiSite.metalAndColorsPage.fillFormWithValues(data);
        JdiSite.metalAndColorsPage.submit();
        softAssert.assertEquals(JdiSite.metalAndColorsPage.getResults(),
            data.getExpectedResult());
        softAssert.assertAll();
    }
}
