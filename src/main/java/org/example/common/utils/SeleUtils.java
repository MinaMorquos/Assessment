package org.example.common.utils;

import org.example.common.base.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SeleUtils extends BaseBrowser {
    private final Duration TIMEOUT = Duration.ofSeconds(5);
    private final Duration POLLING = Duration.ofMillis(300);
    private final WebDriverWait wait = new WebDriverWait(driver, TIMEOUT, POLLING);

    public void typeInInputWithName(String name, String text) {
        try {
            WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
            input.sendKeys(text);
        } catch (Exception e) {
            throw new Error("Couldn't type " + text + " on input with name " + name);
        }
    }


    public void clickOnButtonWithTextAndType(String text, String type) {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@type='"+type+"' and normalize-space()='"+text+"']")));
            button.click();
        } catch (Exception e) {
            throw new Error("Couldn't click on button with text" + text);
        }
    }
    public void assertPageOpened(String pageName){
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='oxd-topbar-header-title']//h6[normalize-space()='"+pageName+"']")
        ));
        Assert.assertTrue(title.isDisplayed());
    }
}
