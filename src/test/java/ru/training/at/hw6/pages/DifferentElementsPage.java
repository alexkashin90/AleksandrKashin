package ru.training.at.hw6.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class DifferentElementsPage extends AbstractPage {

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;
    @FindBy(css = "input[type='radio']")
    private List<WebElement> radios;
    @FindBy(css = "select.uui-form-element")
    private WebElement dropdown;
    @FindBy(css = ".logs >li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWaterChecked(int listNumber) {
        return checkboxes.get(listNumber).isSelected();
    }

    public void clickWaterCheckbox(int listNumber) {
        checkboxes.get(listNumber).click();
    }

    public boolean isWindChecked(int listNumber) {
        return checkboxes.get(listNumber).isSelected();
    }

    public void clickWindCheckbox(int listNumber) {
        checkboxes.get(listNumber).click();
    }

    public boolean isSelenRadioChecked(int listNumber) {
        return radios.get(listNumber).isSelected();
    }

    public void selectSelenRadio(int listNumber) {
        radios.get(listNumber).click();
    }

    public void selectColor(String color) {
        new Select(dropdown).selectByVisibleText(color);
    }

    public String getFirstSelectedColor() {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }


    public List<WebElement> getLogs() {
        return logs;
    }
}
