package ru.training.at.hw5.pages;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInHomePage extends AbstractPage {
    @FindBy(id = "user-name")
    private static WebElement userName;
    @FindBy(xpath = "//a[contains(text(), 'Service')]")
    private static WebElement serviceLink;
    @FindBy(xpath = "//a[contains(text(), 'Different elements')]")
    private static WebElement differentElementsPageLink;
    @FindBy(css = ".dropdown>ul>li>a")
    private static List<WebElement> headerItems;

    public LoggedInHomePage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void clickOnServiceLink(String linkText) {
        if (serviceLink.getText().equalsIgnoreCase(linkText)) {
            serviceLink.click();
        }
    }

    public DifferentElementsPage clickOnALinkInHeader(String linkText) {
        for (WebElement webElement : headerItems) {
            if (webElement.getText().equalsIgnoreCase(linkText)) {
                webElement.click();
                return new DifferentElementsPage(driver);
            }
        }
        throw new NoSuchElementException("Element \"" + linkText + "\" not found");
    }
}

