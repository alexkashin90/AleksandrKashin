package ru.training.at.hw1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.CalculatorTestDataProvider;
import ru.training.at.hw1.GeneralConditions;

public class CalculatorDivisionTest extends GeneralConditions {
    @Test(dataProvider = "LongTestData", dataProviderClass = CalculatorTestDataProvider.class)
    public void testDivisionLong(long x, long y) {
        long expected = x / y;
        Assert.assertEquals(calculator.div(x, y), expected);
    }

    @Test(dataProvider = "DoubleTestData", dataProviderClass = CalculatorTestDataProvider.class)
    public void testDivisionDouble(double x, double y) {
        double expected = x / y;
        Assert.assertEquals(calculator.div(x, y), expected);
    }

    @Test(dataProvider = "DataForDivisionByZero",
            dataProviderClass = CalculatorTestDataProvider.class,
            expectedExceptions = NumberFormatException.class)
    public void testDivisionByZero(long x, long y) {
        calculator.div(x, y);
    }
}
