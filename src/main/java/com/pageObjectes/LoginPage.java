package com.pageObjectes;

import com.actionDriver.Action;
import com.baseClass.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(base.driver,this);
    }

    Action action=new Action();

    @FindBy(xpath="//a[@id='nav-link-accountList']")
    WebElement signUp;

    @FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[1]/div[1]/a[1]")
    WebElement signInBtn;

    @FindBy(xpath = "//*[@id=\"ap_email\"]")
  WebElement enterMb;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    WebElement otp;


    //*[@id="cvf-submit-otp-button"]/span/input

    @FindBy(xpath="//*[@id=\"signInSubmit\"]")
    WebElement otpContinue;

   public void loginPage() throws InterruptedException {
       action.click(base.driver,signUp);
       Thread.sleep(2000);
//       action.click(base.driver,signInBtn);
       Thread.sleep(2000);
       action.sendKeys(base.driver,enterMb,"6300412977");
       Thread.sleep(2000);
       action.click(base.driver,continueBtn);
       Thread.sleep(2000);
       action.click(base.driver,otp);
       Thread.sleep(2000);
       action.sendKeys(base.driver,otp,"Pav@2001");
      Thread.sleep(3000);
      action.click(base.driver,otpContinue);
   }
}
