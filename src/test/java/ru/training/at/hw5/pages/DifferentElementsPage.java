package ru.training.at.hw5.pages;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends AbstractPage {

    private LogSection logSection;

    @FindBy(css = "input[type='checkbox']")
    private static List<WebElement> checkboxes;
    @FindBy(css = "input[type='radio']")
    private static List<WebElement> radios;
    @FindBy(css = "div>select")
    private static WebElement dropdown;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        logSection = new LogSection(driver);
    }

    public WebElement getCheckboxByText(String checkboxText) {
        for (WebElement element : checkboxes) {
            String text = element.getAccessibleName();
            if (text.equals(checkboxText)) {
                return element;
            }
        }
        throw new NoSuchElementException("Element \"" + checkboxText + "\" can not be found");
    }

    public void clickOnCheckbox(String checkboxText) {
        getCheckboxByText(checkboxText).click();
    }

    public WebElement getRadioByText(String radioText) {
        for (WebElement element : radios) {
            String text = element.getAccessibleName();
            if (text.equals(radioText)) {
                return element;
            }
        }
        throw new NoSuchElementException("Element \"" + radioText + "\" can not be found");
    }

    public void clickOnRadio(String radioText) {
        getRadioByText(radioText).click();
    }

    public void selectColor(String color) {
        new Select(dropdown).selectByVisibleText(color);
    }

    public LogSection getLogSection() {
        return logSection;
    }
}
