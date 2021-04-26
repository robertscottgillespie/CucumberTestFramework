package steps;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    public static LoginPage loginPage;
    public static HomePage adminPage;

    @Given("^I navigate to the modular login page$")
    public void iNavigateToTheLoginPage() {

        System.out.println("Navigate Login Page");
        Base.launchApplication();
        loginPage = new LoginPage();
        loginPage.goToLoginPage();

    }

    @When("I enter an empty UserName")
    public void iEnterAnEmptyUserName() {

        System.out.println("I enter a valid username");
        loginPage.clearUserID();
    }
    @When("I enter a valid UserName")
    public void iEnterAValidUserName() {

        System.out.println("I enter a valid username");
        loginPage.clearUserID();
        loginPage.inputUserID();
    }

    @When("I enter a valid Password")
    public void iEnterAValidPassword() {

        System.out.println("I enter a valid password");
        loginPage.clearPasswordField();
        loginPage.inputPassword();
    }

    @Then("I click login button")
    public void iClickLoginButton() {

        System.out.println("I click login button");
        adminPage = loginPage.clickLoginButtonNavigateToAdminPage();
    }

    @Then("I should be logged in to Admin Page")
    public void iShouldBeLoggedInToAdminPage()  {

        System.out.println("I should be logged into admin page");
        Assert.assertEquals(adminPage.getAdminPageMessageText(),"Accounts", "You are now logged in to Admin Page");
        Base.closeBrowser();

    }

    @Then("I get username field required message")
    public void iGetUsernameFieldRequiredMessage()  {
        System.out.println("Username field is required message");
        Assert.assertEquals(loginPage.getFieldRequiredText(),"This field is required", "Password required message");
        Base.closeBrowser();
    }

    @And("I enter an empty Password")
    public void iEnterAnEmptyPassword() {
        System.out.println("I enter an empty password");
        loginPage.clearPasswordField();
    }

    @Then("I get password field required message")
    public void iGetPasswordFieldRequiredMessage()  {
        System.out.println("Password field is required message");
        Assert.assertEquals(loginPage.getFieldRequiredText(),"This field is required", "Password required message");
        Base.closeBrowser();
    }

    @When("I enter an incorrect UserName")
    public void iEnterAnIncorrectUserName() {
        System.out.println("I enter a valid username");
        loginPage.clearUserID();
        loginPage.inputBadUserID();
    }

    @Then("I get username or password is incorrect message")
    public void iGetUsernameOrPasswordIsIncorrectMessage() {
        System.out.println("username or password is incorrect message");
        Assert.assertEquals(loginPage.getIncorrectSignInText(),"Multiple incorrect sign-ins could result in your access being locked. If this does happen, you'll receive an email explaining how to reset your access.", "Multiple sign i error");
        Base.closeBrowser();
    }

    @And("I enter an incorrect Password")
    public void iEnterAnIncorrectPassword() {
        System.out.println("I enter an incorrect password");
        loginPage.clearPasswordField();
        loginPage.inputBadPassword();
    }

    @And("login button should be disabled")
    public void loginButtonShouldBeDisabled() {
        System.out.println("Assert that button is disabled");
        Assert.assertFalse(loginPage.checkButtonIsEnabled());
        Base.closeBrowser();
    }
}
