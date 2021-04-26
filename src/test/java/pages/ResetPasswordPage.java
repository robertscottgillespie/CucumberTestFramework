package pages;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResetPasswordPage extends BasePage {


    @FindBy(xpath="//p[contains(text(),'Accounts')]")
    WebElement EmailSentTxt;

    @FindBy(xpath="//input[@id='usernameInput']")
    WebElement userName;


    @FindBy(xpath="//span[contains(text(),'Request a reset')]")
    WebElement resetBtn;

    @FindBy(xpath="//span[contains(text(),'Request a reset')]")
    WebElement cancelBtn;

    @FindBy(xpath="//p[@id='emailSentHeading']")
    WebElement emailSentHeader;


    public void clearUserName(){
        driverWait.WaitForElementVisible(userName);
        userName.clear();
    }

    public void inputUserName(){
        String myUserID = appProps.getProperty("userid");
        driverWait.WaitForElementVisible(userName);
        userName.sendKeys(myUserID);
    }

    public void clickResetButton(){
        driverWait.WaitForElementVisible(resetBtn);
        resetBtn.click();
    }

    public void clickCancelButton(){
        driverWait.WaitForElementVisible(cancelBtn);
        cancelBtn.click();
    }

    public String getEmailSentText(){
        driverWait.WaitForElementVisible(emailSentHeader);
        return emailSentHeader.getText();
    }



    public String getResetPasswordPageTitle(){ return driver.getTitle(); }

    public String getResetPasswordPageURL(){ return driver.getCurrentUrl(); }


}
