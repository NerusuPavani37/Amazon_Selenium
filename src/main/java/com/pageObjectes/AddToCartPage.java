package com.pageObjectes;

import com.actionDriver.Action;
import com.baseClass.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

    public AddToCartPage(){
        PageFactory.initElements(base.driver,this);
    }
    Action action=new Action();
//    @FindBy(xpath = "//*[@id=\"sc-buy-box-ptc-button\"]/span/input")
//    WebElement buyBtn;

    @FindBy(xpath = "//*[@id=\"orderSummaryPrimaryActionBtn\"]")
    WebElement useAddress;

    public void addToCart(){

//        action.click(base.driver,useAddress);
        useAddress.click();
    }
}
