package ru.training.at.hw1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.CalculatorTestDataProvider;
import ru.training.at.hw1.GeneralConditions;

public class CalculatorAdditionTest extends GeneralConditions {

    @Test(dataProvider = "LongTestData", dataProviderClass = CalculatorTestDataProvider.class)
    public void testAdditionLong(long x, long y) {
        long expected = x + y;
        Assert.assertEquals(calculator.sum(x, y), expected);
    }

    @Test(dataProvider = "DoubleTestData", dataProviderClass = CalculatorTestDataProvider.class)
    public void testAdditionDouble(double x, double y) {
        double expected = x + y;
        Assert.assertEquals(calculator.sum(x, y), expected);
    }
}
