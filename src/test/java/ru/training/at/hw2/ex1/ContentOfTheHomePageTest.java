package ru.training.at.hw2.ex1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw2.GeneralConditions;
import ru.training.at.hw2.data.TestData;

public class ContentOfTheHomePageTest extends GeneralConditions {

    //5. Assert that there are 4 items on the header section are displayed and they have proper texts

    @Test(priority = 2)
    public void checkHeaderSectionLinks() {
        //Assert that there are 4 items on the header section are displayed
        WebElement homeLink = driver.findElement(By.xpath("//a[text()='Home']"));
        WebElement contactFormLink = driver.findElement(By.xpath("//a[text()='Contact form']"));
        WebElement serviceLink = driver.findElement(By.xpath("//a[contains(text(), 'Service')]"));
        WebElement metalsAndColorsLink = driver.findElement(By.xpath("//a[text()='Metals & Colors']"));
        List<WebElement> headerSectionElements = List.of(homeLink, contactFormLink, serviceLink,
                metalsAndColorsLink);
        softAssert.assertEquals(headerSectionElements.size(), TestData.HEADER_LINKS_TEXTS.size());
        checkIfElementsAreDisplayed(headerSectionElements);
        //Assert that 4 items on the header section have proper texts
        compareTexts(headerSectionElements, TestData.HEADER_LINKS_TEXTS);
    }

    //6. Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 3)
    public void testFourImagesExist() {

        //Assert that there are 4 images on the Index Page
        final List<WebElement> imagesOnHomePage = driver.findElements(
                By.cssSelector("div.benefit-icon"));
        softAssert.assertEquals(imagesOnHomePage.size(), TestData.NUMBER_OF_IMAGES);

        //Assert that 4 images on the Index Page are displayed
        checkIfElementsAreDisplayed(imagesOnHomePage);
    }

    //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 4)
    public void checkIfProperTextsAreBelowImages() {

        //Assert that there are 4 texts on the Index Page under icons
        final List<WebElement> textsBelowImages = driver.findElements(By.cssSelector("span.benefit-txt"));
        softAssert.assertEquals(textsBelowImages.size(), TestData.NUMBER_OF_TEXTS_BELOW_IMAGES);

        //Assert that texts on the Index Page under icons have proper text
        compareTexts(textsBelowImages, TestData.TEXTS_BELOW_IMAGES);
    }

    //8. Assert that there is the iframe with “Frame Button” exist
    @Test(priority = 5)
    public void checkIfIFrameExists() {
        final WebElement iframeLink = driver.findElement(By.tagName("iframe"));
        softAssert.assertTrue(iframeLink.isDisplayed());
    }

    // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
    @Test(priority = 6)
    public void checkIfFrameButtonExists() {
        //Switch to the iframe
        driver.switchTo().frame("frame");
        WebElement frameButton = driver.findElement(By.xpath("//*[@id='frame-button']"));
        // The frame button exists
        softAssert.assertTrue(frameButton.isDisplayed());
    }

    // 10. Switch to original window back
    @Test(priority = 7)
    public void checkIfSwitchedToOriginalWindow() {
        driver.switchTo().defaultContent();
        String currentHandle = driver.getWindowHandle();
        softAssert.assertEquals(currentHandle, originalHandle);
    }

    // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test(priority = 8)
    public void checkElementsOnTheLeftSection() {
        final WebElement homeLink = driver.findElement(By.xpath("//span[text()='Home']"));
        final WebElement contactFormLink = driver.findElement(By.xpath("//span[text()='Contact form']"));
        final WebElement serviceLink = driver.findElement(By.xpath("//span[contains(text(), 'Service')]"));
        final WebElement metalsAndColorsLink = driver.findElement(By.xpath("//span[text()='Metals & Colors']"));
        final WebElement elementsPacksLink = driver.findElement(By.xpath("//span[text()='Elements packs']"));
        List<WebElement> elementsOnTheLeftSection = List.of(homeLink, contactFormLink,
                serviceLink, metalsAndColorsLink, elementsPacksLink);

        //Assert that there are 5 items on the Left Section are displayed
        checkIfElementsAreDisplayed(elementsOnTheLeftSection);

        //Assert that 5 items on the Left Section have proper texts
        compareTexts(elementsOnTheLeftSection, TestData.LEFT_SECTION_LINKS_TEXTS);
    }
}
