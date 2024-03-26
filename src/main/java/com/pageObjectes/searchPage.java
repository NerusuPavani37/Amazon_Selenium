package com.pageObjectes;

import com.actionDriver.Action;
import com.baseClass.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPage {

    public searchPage(){
        PageFactory.initElements(base.driver,this);
    }
    Action action=new Action();

    @FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
    WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
    WebElement searchBtn;

    public void searchProduct(){
        action.click(base.driver,searchInput);
        action.sendKeys(base.driver,searchInput,"poco 11");
        action.click(base.driver,searchBtn);

    }
}
