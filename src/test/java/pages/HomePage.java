package pages;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {


    @FindBy(xpath="//p[contains(text(),'Accounts')]")
    WebElement adminTxt;

    public String getAdminPageMessageText(){
        driverWait.WaitForElementVisible(adminTxt);
        return adminTxt.getText();
    }

    public String getHomePageTitle(){ return driver.getTitle(); }

    public String getHomePageURL(){ return driver.getCurrentUrl(); }


}
