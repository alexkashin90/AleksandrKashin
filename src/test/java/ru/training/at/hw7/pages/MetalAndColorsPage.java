package ru.training.at.hw7.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import ru.training.at.hw7.data.MetalAndColorsData;

public class MetalAndColorsPage extends WebPage {

    @Css("#odds-selector input")
    private RadioButtons summaryOdds;

    @Css("#even-selector input")
    private RadioButtons summaryEvens;

    @Css("#elements-checklist input")
    public Checklist elements;

    @JDropdown(list = "#colors li",
               expand = "#colors span.caret")
    private Dropdown colors;

    @JDropdown(list = "#metals span.text",
               expand = "#metals span.caret")
    private Dropdown metals;

    @JDropdown(list = "#vegetables li",
               expand = "#vegetables span.caret")
    private Dropdown vegetables;

    @Css("#submit-button")
    private Button submitButton;

    @Css(".results li")
    private UIElement results;

    private void selectFromDropdown(List<String> values, Dropdown dropdown) {
        for (String value : values) {
            dropdown.select(value);
        }
    }

    private void selectFromCheckList(List<String> values, Checklist checklist) {
        for (String value : values) {
            checklist.select(value);
        }

    }

    public void fillFormWithValues(MetalAndColorsData data) {
        summaryOdds.select(String.valueOf(data.getSummary().get(0)));
        summaryEvens.select(String.valueOf(data.getSummary().get(1)));

        selectFromCheckList(data.getElements(), elements);

        colors.expand();
        colors.select(data.getColor());

        metals.expand();
        metals.select(data.getMetals());

        vegetables.expand();
        vegetables.select(3);
        selectFromDropdown(data.getVegetables(), vegetables);
    }

    public void submit() {
        submitButton.click();
    }

    public List<String> getResults() {
        return results.getAll()
                      .stream()
                      .map(WebElement::getText)
                      .collect(Collectors.toList());
    }
}
