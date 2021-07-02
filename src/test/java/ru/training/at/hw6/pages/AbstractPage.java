package ru.training.at.hw6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
