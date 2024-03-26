import com.baseClass.base;
import com.pageObjectes.LoginPage;
import com.pageObjectes.searchPage;
import com.pageObjectes.productDetailPage;
import com.pageObjectes.productListingPage;
import com.pageObjectes.AddToCartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

import static com.baseClass.base.driver;
import static com.baseClass.base.prop;

public class TestCases {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        base.loadConfig();
        base.launchApp();
        driver.manage().window().maximize();
    }

    @Test
    public void end_to_end_Searching() throws InterruptedException, AWTException {
        driver.get(prop.getProperty("url"));

        LoginPage login=new LoginPage();
        searchPage search=new searchPage();
        productDetailPage proDetails=new productDetailPage();
        productListingPage proLists=new productListingPage();
        AddToCartPage addToCart=new AddToCartPage();

        login.loginPage();
        search.searchProduct();
        proLists.productList();
        proLists.switchToNewWindow();
        proDetails.productDetails();
        addToCart.addToCart();

        System.out.println("till checked out");
    }

//    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
