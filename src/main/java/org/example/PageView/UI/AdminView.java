package org.example.PageView.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminView extends BaseView {
    final By toastBy = By.xpath("//p[contains(@class,'text--toast-message')]");
    final By totalRecordsBy = By.xpath("//span[contains(normalize-space(),'Records Found')]");
    String employeeName = "";
    static String userName="";
    final By deleteIconBy = By.xpath("(//i[@class='oxd-icon bi-trash'])[1]");
    final By deleteIconFromAlertBy = By.xpath("(//i[@class='oxd-icon bi-trash oxd-button-icon'])[1]");

    public void clickOnTabWithName(String tabName) {
        By adminTab = By.xpath("//span[normalize-space()='" + tabName + "']");
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(adminTab));
        tab.click();
    }

    public void getTotalRecords() {
        String totalRecordsNum = getTotalRecordsNum();
        Map<String, String> data = new HashMap<>();
        data.put("totalRecords", totalRecordsNum);
        data.put("EmployeeName", employeeName);
        fileUtils.writeKeyAndValueInFile("testData.json", data);
    }

    private String getTotalRecordsNum() {
        WebElement totalRecordsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(totalRecordsBy));
        String totalRecordsNum = extractInt(totalRecordsElement.getText());
        employeeName = driver.findElement(By.xpath("(//div[@role='cell'])[4]")).getText();
        return totalRecordsNum;
    }


    public void fillDDLUnderLabelWithName(String labelName, String optionText) {
        try {
            WebElement ddl = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[normalize-space()='" + labelName + "']/../..//div[contains(text(),'-- Select --')]")));
            ddl.click();
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='oxd-select-option']//span[normalize-space()='" + optionText + "']")));
            option.click();
        } catch (Exception e) {
            throw new Error("Couldn't type " + optionText + " in Drop Down List with name " + labelName);
        }
    }

    public void fillInputUnderLabelWithName(String text, String labelName) {
        try {
            WebElement input = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[normalize-space()='" + labelName + "']/../..//*[contains(@class,'input--active')]")));
            if (labelName.toLowerCase().contains("password")) {
                input.sendKeys(text);
            } else {
                userName=text + System.currentTimeMillis() / 10000;
                input.sendKeys(userName);
            }
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private String extractInt(String text) {
        Pattern pattern = Pattern.compile("\\d+"); // Regular expression to match one or more digits
        Matcher matcher = pattern.matcher(text);
        String totalRecordsNum = "";
        if (matcher.find()) {
            totalRecordsNum = matcher.group(); // Extract the matched digits
            System.out.println("Digits found: " + totalRecordsNum);
        } else {
            System.out.println("No digits found");
        }
        return totalRecordsNum;
    }

    public void selectEmployee(String labelName) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='" + labelName + "']/../..//*[contains(@class,'input--active')]/input")));

        try {
            // This component is bugged if you tried to entire valid employeeName it will fail you have to select it
            // even worse you can't the debugger on the browser using f8 the element will disappear
            Thread.sleep(100);
            input.sendKeys(employeeName);
            Thread.sleep(1000);
            input.sendKeys(" ");
            Thread.sleep(3000);
            Actions actions = new Actions(driver);
            actions.sendKeys(input, Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ENTER).perform();
        } catch (Exception e) {
            throw new Error(e);
        }

    }

    public void validateUserIsCreated(){
        WebElement message =wait.until(ExpectedConditions.visibilityOfElementLocated(toastBy));
        Assert.assertEquals(message.getText(),"Successfully Saved");
    }
    public void validateUserIsDeleted(){
        WebElement message =wait.until(ExpectedConditions.visibilityOfElementLocated(toastBy));
        Assert.assertEquals(message.getText(),"Successfully Deleted");
    }
    public void validateRecordsNumberIsChanged(int num){
        int oldRecordsNum =fileUtils.readValueBasedOnKey("totalRecords","testData.json");
        int newRecordsNum =Integer.parseInt(getTotalRecordsNum());
        Assert.assertEquals(newRecordsNum,oldRecordsNum+num);
    }
    public void typeCreatedUser(){
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='Username']/../..//*[contains(@class,'input--active')]")));
        input.sendKeys(userName);
    }
    public void clickOnDeleteIcon(){
        try {
            WebElement deleteIcon = wait.until(ExpectedConditions.elementToBeClickable(deleteIconBy));
            deleteIcon.click();
        }catch (Exception e){
            throw new Error("Couldn't click on delete icon");
        }
    }
    public void clickOnDeleteIconFromAlert(){
        try {
            WebElement deleteIcon = wait.until(ExpectedConditions.elementToBeClickable(deleteIconFromAlertBy));
            deleteIcon.click();
        }catch (Exception e){
            throw new Error("Couldn't click on delete icon");
        }
    }
}
