package ru.training.at.hw1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.CalculatorTestDataProvider;
import ru.training.at.hw1.GeneralConditions;

public class CalculatorMultiplicationTest extends GeneralConditions {

    @Test(dataProvider = "LongTestData", dataProviderClass = CalculatorTestDataProvider.class)
    public void testMultiplicationLong(long x, long y) {
        long expected = x * y;
        Assert.assertEquals(calculator.mult(x, y), expected);
    }

    @Test(dataProvider = "DoubleTestData", dataProviderClass = CalculatorTestDataProvider.class)
    public void testMultiplicationDouble(double x, double y) {
        double expected = x * y;
        Assert.assertEquals(calculator.mult(x, y), expected);
    }
}
