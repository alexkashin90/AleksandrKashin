package ru.training.at.hw2.ex1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw2.GeneralConditions;
import ru.training.at.hw2.TestDataProvider;

public class ContentOfTheHomePageTest extends GeneralConditions {

    //5. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 2)
    public void testHeaderSectionLinksExistAndHaveProperText() {
        final WebElement homeLink = driver.findElement(By.xpath("//a[text()='Home']"));
        final WebElement contactFormLink = driver.findElement(By.xpath("//a[text()='Contact form']"));
        final WebElement serviceLink = driver.findElement(By.xpath("//a[contains(text(), 'Service')]"));
        final WebElement metalsAndColorsLink = driver.findElement(By.xpath("//a[text()='Metals & Colors']"));

        //Assert that there are 4 items on the header section are displayed
        softAssert.assertTrue(homeLink.isDisplayed());
        softAssert.assertTrue(contactFormLink.isDisplayed());
        softAssert.assertTrue(serviceLink.isDisplayed());
        softAssert.assertTrue(metalsAndColorsLink.isDisplayed());

        //Assert that 4 items on the header section have proper texts
        softAssert.assertEquals(homeLink.getText(), "HOME");
        softAssert.assertEquals(contactFormLink.getText(), "CONTACT FORM");
        softAssert.assertEquals(serviceLink.getText(), "SERVICE");
        softAssert.assertEquals(metalsAndColorsLink.getText(), "METALS & COLORS");
        softAssert.assertAll();
    }

    //6. Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 3)
    public void testFourImagesExist() {

        //Assert that there are 4 images on the Index Page
        final List<WebElement> numberOfImagesOnHomePage = driver.findElements(
                By.cssSelector("div.benefit-icon"));
        softAssert.assertEquals(numberOfImagesOnHomePage.size(), 4);

        //Assert that 4 images on the Index Page are displayed
        for (WebElement image : numberOfImagesOnHomePage) {
            softAssert.assertTrue(image.isDisplayed());
            softAssert.assertAll();
        }
    }

    //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 4, dataProvider = "TextBelowImages",
            dataProviderClass = TestDataProvider.class)
    public void testProperTextBelowImages(String text1, String text2,
                                     String text3, String text4) {

        //Assert that there are 4 texts on the Index Page under icons
        final List<WebElement> numberOfTextsBelowImages = driver.findElements(By.cssSelector("span.benefit-txt"));
        softAssert.assertEquals(numberOfTextsBelowImages.size(), 4);

        //Assert that texts on the Index Page under icons have proper text
        softAssert.assertTrue(numberOfTextsBelowImages.get(0).getText().contains(text1));
        softAssert.assertTrue(numberOfTextsBelowImages.get(1).getText().contains(text2));
        softAssert.assertTrue(numberOfTextsBelowImages.get(2).getText().contains(text3));
        softAssert.assertTrue(numberOfTextsBelowImages.get(3).getText().contains(text4));
        softAssert.assertAll();
    }

    //8. Assert that there is the iframe with “Frame Button” exist
    @Test(priority = 5)
    public void testIFrameExist() {
        final WebElement iframeLink = driver.findElement(By.tagName("iframe"));
        softAssert.assertTrue(iframeLink.isDisplayed());
    }

    // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
    @Test(priority = 6)
    public void testFrameButtonExist() {
        //Switch to the iframe
        driver.switchTo().frame("frame");
        WebElement frameButton = driver.findElement(By.xpath("//*[@id='frame-button']"));
        // The frame button exists
        softAssert.assertTrue(frameButton.isDisplayed());
    }

    // 10. Switch to original window back
    @Test(priority = 7)
    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
        String currentHandle = driver.getWindowHandle();
        softAssert.assertEquals(currentHandle, originalHandle);
    }

    // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test(priority = 8)
    public void testElementsOnTheLeftSectionExistAndHaveProperText() {
        final WebElement homeLink = driver.findElement(By.xpath("//span[text()='Home']"));
        final WebElement contactFormLink = driver.findElement(By.xpath("//span[text()='Contact form']"));
        final WebElement serviceLink = driver.findElement(By.xpath("//span[contains(text(), 'Service')]"));
        final WebElement metalsAndColorsLink = driver.findElement(By.xpath("//span[text()='Metals & Colors']"));
        final WebElement elementsPacksLink = driver.findElement(By.xpath("//span[text()='Elements packs']"));

        //Assert that there are 5 items on the Left Section are displayed
        softAssert.assertTrue(homeLink.isDisplayed());
        softAssert.assertTrue(contactFormLink.isDisplayed());
        softAssert.assertTrue(serviceLink.isDisplayed());
        softAssert.assertTrue(metalsAndColorsLink.isDisplayed());
        softAssert.assertTrue(elementsPacksLink.isDisplayed());

        //Assert that 5 items on the Left Section have proper texts
        softAssert.assertEquals(homeLink.getText(), "Home");
        softAssert.assertEquals(contactFormLink.getText(), "Contact form");
        softAssert.assertEquals(serviceLink.getText(), "Service");
        softAssert.assertEquals(metalsAndColorsLink.getText(), "Metals & Colors");
        softAssert.assertEquals(elementsPacksLink.getText(), "Elements packs");
        softAssert.assertAll();
    }
}
