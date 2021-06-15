package ru.training.at.hw2;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "UserData")
    public static Object[][] getTestUserData() {
        return new Object[][]{
                {"Roman", "Jdi1234"}
        };
    }

    @DataProvider(name = "TextBelowImages")
    public static Object[][] getExpectedTextBelowImages() {
        return new Object[][]{
                {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\n"
                    + "some external projects),\nwish to get more…"}
        };
    }

    @DataProvider(name = "TextOfLogs")
    public static Object[][] getExpectedTextOfLogs() {
        return new Object[][]{
                {"Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"}
        };
    }
}
