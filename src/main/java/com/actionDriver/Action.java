package com.actionDriver;

import com.baseClass.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action extends base {
    public void click(WebDriver driver, WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).click().perform();
    }
    public void sendKeys(WebDriver driver, WebElement ele, String text) {
        ele.sendKeys(text);
    }
}