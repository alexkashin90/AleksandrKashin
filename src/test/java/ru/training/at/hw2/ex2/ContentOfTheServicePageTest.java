package ru.training.at.hw2.ex2;

import java.util.List;
import java.util.Objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.training.at.hw2.GeneralConditions;
import ru.training.at.hw2.TestDataProvider;


public class ContentOfTheServicePageTest extends GeneralConditions {

    //5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 2)
    public void openServicePage() {
        driver.findElement(By.xpath("//a[contains(text(), 'Service')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Different elements')]")).click();
        softAssert.assertEquals(driver.getTitle(), "Different Elements");
        softAssert.assertAll();
    }

    // 6. Select checkboxes
    @Test(priority = 3)
    public void selectWaterAndWindCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement water = null;
        WebElement wind = null;

        for (WebElement element : checkboxes) {
            String text = element.findElement(By.xpath("..")).getText();
            switch (text) {
                case "Water":
                    water = element;
                    water.click();
                    break;
                case "Wind":
                    wind = element;
                    wind.click();
                    break;
                default: break;
            }
        }

        // Assert elements are checked
        softAssert.assertTrue(Objects.requireNonNull(water).isSelected());
        softAssert.assertTrue(Objects.requireNonNull(wind).isSelected());
        softAssert.assertAll();
    }

    // 7. Select radio
    @Test(priority = 4)
    public void selectSelenRadio() {
        List<WebElement> radios = driver.findElements(By.cssSelector("input[type='radio']"));
        WebElement selen = null;

        for (WebElement element : radios) {
            String text = element.findElement(By.xpath("..")).getText();
            if (text.contains("Selen")) {
                selen = element;
                selen.click();
            }
        }

        // Assert "Selen" is selected
        softAssert.assertTrue(Objects.requireNonNull(selen).isSelected());
        softAssert.assertAll();
    }

    // 8. Select in dropdown
    @Test(priority = 5)
    public void selectYellowInDropdown() {
        String color = "Yellow";
        Select dropdown = new Select(driver.findElement(By.cssSelector("select.uui-form-element")));
        dropdown.selectByVisibleText(color);

        // Element is selected
        softAssert.assertEquals(dropdown.getFirstSelectedOption().getText(), color);
        softAssert.assertAll();
    }

    // 9. Assert that
    // for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    // for radio button there is a log row and value is corresponded to the status of radio button
    // for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 9, dataProvider = "TextOfLogs",
            dataProviderClass = TestDataProvider.class)
    public void assertLogs(String text1, String text2,
                           String text3, String text4) {
        List<WebElement> logs = driver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));

        softAssert.assertEquals(logs.size(), 4);
        // Log rows are displayed
        softAssert.assertTrue(logs.get(0).isDisplayed());
        softAssert.assertTrue(logs.get(1).isDisplayed());
        softAssert.assertTrue(logs.get(2).isDisplayed());
        softAssert.assertTrue(logs.get(3).isDisplayed());
        // checkbox name and its status is corresponding to selected
        softAssert.assertTrue(logs.get(0).getText().contains(text1));
        softAssert.assertTrue(logs.get(1).getText().contains(text2));
        softAssert.assertTrue(logs.get(2).getText().contains(text3));
        softAssert.assertTrue(logs.get(3).getText().contains(text4));
        softAssert.assertAll();
    }
}
