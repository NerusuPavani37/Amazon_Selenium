package com.pageObjectes;

import com.actionDriver.Action;
import com.baseClass.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

import static com.baseClass.base.driver;

public class productListingPage {

    public productListingPage(){
        PageFactory.initElements(base.driver,this);
    }
    Action action=new Action();
    @FindBy(xpath="(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")
    WebElement product;

    public void productList() throws InterruptedException {


        action.click(base.driver,product);
        Thread.sleep(2000);
    }
public void switchToNewWindow() {
    String currentWindowHandle = driver.getWindowHandle();
    Set<String> windowHandles = driver.getWindowHandles();
    for(String windowHandle : windowHandles){
        if(!windowHandle.equals(currentWindowHandle)){
            driver.switchTo().window(windowHandle);
            break;
        }
    }
}


}
