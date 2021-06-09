package ru.training.at.hw1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.CalculatorTestDataProvider;
import ru.training.at.hw1.GeneralConditions;

public class CalculatorSubtractionTest extends GeneralConditions {
    @Test(dataProvider = "LongTestData", dataProviderClass = CalculatorTestDataProvider.class)
    public void testSubtractionLong(long x, long y) {
        long expected = x - y;
        Assert.assertEquals(calculator.sub(x, y), expected);
    }

    @Test(dataProvider = "DoubleTestData", dataProviderClass = CalculatorTestDataProvider.class)
    public void testSubtractionDouble(double x, double y) {
        double expected = x - y;
        Assert.assertEquals(calculator.sub(x, y), expected);
    }
}
