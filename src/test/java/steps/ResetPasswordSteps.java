package steps;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ResetPasswordPage;

public class ResetPasswordSteps {
    public static LoginPage loginPage;
    public static ResetPasswordPage resetPasswordPage;


    @Given("User navigates to the modular login page")
    public void userNavigatesToTheModularLoginPage() {

        System.out.println("Navigate Login Page");
        Base.launchApplication();
        loginPage = new LoginPage();
        loginPage.goToLoginPage();
    }


    @And("I click on forgotten password link")
    public void iClickOnForgottenPasswordLink() {
        System.out.println("click on password reset");
         resetPasswordPage = loginPage.clickResetPasswordLink();
    }


    @When("I enter my username on reset password page")
    public void iEnterMyUsernameOnResetPasswordPage() {
        System.out.println("input user name");
        resetPasswordPage.clearUserName();
        resetPasswordPage.inputUserName();
    }


    @And("I click request a reset link")
    public void iClickRequestAResetLink() {
        System.out.println("click on request reset button");
        resetPasswordPage.clickResetButton();
    }


    @Then("I get a message with Email sent")
    public void iGetAMessageWithEmailSent() {
        System.out.println("Assert that message says Email Sent");
        Assert.assertEquals(resetPasswordPage.getEmailSentText(),"Email sent", "Email has been sent");
        Base.closeBrowser();
    }
}
