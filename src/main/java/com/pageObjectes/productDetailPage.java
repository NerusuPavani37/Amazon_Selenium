package com.pageObjectes;
import com.actionDriver.Action;
import com.baseClass.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class productDetailPage {

    public productDetailPage(){
        PageFactory.initElements(base.driver,this);
    }
    Action action=new Action();
    @FindBy(xpath = "//*[@id=\"buy-now-button\"]")
            WebElement buyBtn;


 String title=base.driver.getTitle();



 public void productDetails() throws InterruptedException {
     System.out.println(title);
     Thread.sleep(2000);
     buyBtn.click();
 }
}
