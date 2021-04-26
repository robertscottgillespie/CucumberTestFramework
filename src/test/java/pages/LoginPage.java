package pages;

import base.Base;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {

    @FindBy(xpath="//input[@id='username-inp']")
    WebElement userID;

    @FindBy(xpath="//input[@id='password-inp']")
    WebElement userPassword;

    @FindBy(xpath="//button[@id='signInSubmitButton']")
    WebElement loginButton;

    @FindBy(xpath="//a[@id='forgotPasswordHref']")
    WebElement forgotPasswordLink;

    //div[contains(text(),'This field is required')]
    @FindBy(xpath="//div[contains(text(),'This field is required')]")
    WebElement fieldRequiredMsg;

    @FindBy(xpath="//p[contains(text(),'Multiple incorrect sign-ins could result in your a')]")
    WebElement incorrectSignInMsg;

    public void inputUserID(){
        String myUserID = appProps.getProperty("userid");
        driverWait.WaitForElementVisible(userID);
        userID.sendKeys(myUserID);
    }

    public ResetPasswordPage clickResetPasswordLink(){
        driverWait.WaitForElementClickable(forgotPasswordLink);
        forgotPasswordLink.click();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        return resetPasswordPage;
    }

    public String getFieldRequiredText(){
        driverWait.WaitForElementVisible(fieldRequiredMsg);
        return fieldRequiredMsg.getText();
    }

    public String getIncorrectSignInText(){
        driverWait.WaitForElementVisible(incorrectSignInMsg);
        return incorrectSignInMsg.getText();
    }

    public void clearUserID(){
        driverWait.WaitForElementVisible(userID);
        userID.clear();
    }

    public void inputPassword(){
        String myPassword = appProps.getProperty("password");
        driverWait.WaitForElementVisible(userPassword);
        userPassword.sendKeys(myPassword);
    }

    public void clearPasswordField(){
        driverWait.WaitForElementVisible(userPassword);
        userPassword.clear();
    }

    public HomePage clickLoginButtonNavigateToAdminPage(){
        //when we click login button we navigate to admin page so
        //we should return a page object for this page - page chaining
        driverWait.WaitForElementClickable(loginButton);
        loginButton.click();
        HomePage homepage = new HomePage();
        return homepage;
    }

    public void goToLoginPage(){
        String Url = appProps.getProperty("baseUrl");
        driver.get(Url);
    }

    public String getLoginPageURL(){
        return driver.getCurrentUrl();
    }

    public void inputBadUserID() {
        driverWait.WaitForElementVisible(userID);
        userID.sendKeys("Robert.Gillespie");
    }

    public void inputBadPassword() {
        driverWait.WaitForElementVisible(userPassword);
        userPassword.sendKeys("1955Genev@");
    }

    public boolean checkButtonIsEnabled() {
        return loginButton.isEnabled();
    }

}
