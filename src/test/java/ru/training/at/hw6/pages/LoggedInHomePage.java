package ru.training.at.hw6.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoggedInHomePage extends AbstractPage {
    @FindBy(id = "user-name")
    private static WebElement userName;
    @FindBy(css = ".nav > li > a")
    private static List<WebElement> headerSectionElements;
    @FindBy(css = "div.benefit-icon")
    private static List<WebElement> imagesOnHomePage;
    @FindBy(css = "span.benefit-txt")
    private static List<WebElement> textsBelowImages;
    @FindBy(tagName = "iframe")
    private static WebElement iframe;
    @FindBy(id = "frame-button")
    private static WebElement frameButton;
    @FindBy(css = "ul.sidebar-menu > li > a > span")
    private static List<WebElement> leftSectionElements;
    @FindBy(xpath = "//a[contains(text(), 'Service')]")
    private static WebElement serviceLink;
    @FindBy(xpath = "//a[contains(text(), 'Different elements')]")
    private static WebElement differentElementsPageLink;



    public LoggedInHomePage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return userName.getText();
    }

    public List<WebElement> getHeaderSectionElements() {
        return headerSectionElements;
    }

    public List<WebElement> getImages() {
        return imagesOnHomePage;
    }

    public List<WebElement> getTextsBelowImages() {
        return textsBelowImages;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public List<WebElement> getLeftSectionElements() {
        return leftSectionElements;
    }

    public DifferentElementsPage clickDifferentElementsPageLink() {
        serviceLink.click();
        differentElementsPageLink.click();
        return new DifferentElementsPage(driver);
    }

    public DifferentElementsPage clickDiffElementsPageLink() {
        return clickDifferentElementsPageLink();
    }

}

