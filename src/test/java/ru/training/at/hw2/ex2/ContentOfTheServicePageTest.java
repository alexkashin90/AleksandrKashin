package ru.training.at.hw2.ex2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.training.at.hw2.GeneralConditions;
import ru.training.at.hw2.data.TestData;

public class ContentOfTheServicePageTest extends GeneralConditions {

    //5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 2)
    public void checkIfServicePageIsOpened() {
        driver.findElement(By.xpath("//a[contains(text(), 'Service')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Different elements')]")).click();
        softAssert.assertEquals(driver.getTitle(), TestData.SERVICE_PAGE_TITLE);
    }

    // 6. Select checkboxes
    public List<WebElement> selectCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement waterCheckBox = checkboxes.get(0);
        WebElement windCheckBox = checkboxes.get(2);
        waterCheckBox.click();
        windCheckBox.click();
        return List.of(waterCheckBox, windCheckBox);
    }

    // Assert elements are checked
    @Test(priority = 3)
    public void checkIfCheckboxesAreSelected() {
        for (WebElement checkBox : selectCheckboxes()) {
            softAssert.assertTrue(checkBox.isSelected());
        }
        softAssert.assertAll();
    }

    // 7. Select radio
    public WebElement selectSelenRadio() {
        List<WebElement> radios = driver.findElements(By.cssSelector("input[type='radio']"));
        WebElement selen = radios.get(3);
        selen.click();
        return selen;
    }

    @Test(priority = 4)
    public void checkIfRadioIsSelected() {
        // Assert "Selen" is selected
        softAssert.assertTrue(selectSelenRadio().isSelected());
    }

    // 8. Select in dropdown
    public Select selectYellowInDropdown() {
        Select dropdown = new Select(driver.findElement(By.cssSelector("select.uui-form-element")));
        dropdown.selectByVisibleText(TestData.COLOR);
        return dropdown;
    }

    // Element is selected
    @Test(priority = 5)
    public void checkIfYellowIsSelected() {
        Select dropdown = selectYellowInDropdown();
        softAssert.assertEquals(dropdown.getFirstSelectedOption().getText(), TestData.COLOR);
        softAssert.assertAll();
    }

    // 9. Assert that
    // for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    // for radio button there is a log row and value is corresponded to the status of radio button
    // for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 6)
    public void checkIfLogsHaveProperTexts() {
        List<WebElement> logs = driver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        // Log rows are displayed
        checkIfElementsAreDisplayed(logs);
        // texts of logs are corresponding to selected values
        compareTexts(logs, TestData.TEXTS_OF_LOGS);
    }
}
