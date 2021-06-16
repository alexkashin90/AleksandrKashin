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
                {"To include good practices\nand ideas from successful",
                "To be flexible",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and"}
        };
    }

    @DataProvider(name = "TextOfLogs")
    public static Object[][] getExpectedTextOfLogs() {
        return new Object[][]{
                {"value changed to Yellow",
                "value changed to Selen",
                "condition changed to true",
                "condition changed to true"}
        };
    }
}
