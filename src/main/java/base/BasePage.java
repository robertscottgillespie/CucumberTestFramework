package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Base{


    protected static DriverWait driverWait;


    public BasePage(){
        PageFactory.initElements(driver, this);
        driverWait = new DriverWait(driver);
    }


}



