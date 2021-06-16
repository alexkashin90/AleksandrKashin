package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class CalculatorTestDataProvider {

    @DataProvider(name = "LongTestData")
    public static Object[][] getLongTestData() {
        return new Object[][]{
                {7L, 4L},
                {150L, 34L},
                {784L, 67L}
        };
    }

    @DataProvider(name = "DoubleTestData")
    public static Object[][] getDoubleTestData() {
        return new Object[][]{
                {243.67, 75.83},
                {125.562, 325.75},
                {38.71, 12.984}
        };
    }

    @DataProvider(name = "DataForDivisionByZero")
    public static Object[][] getDataForDivisionByZero() {
        return new Object[][]{
                {1, 0},
                {57, 0},
                {634, 0}
        };
    }
}
