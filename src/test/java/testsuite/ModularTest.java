package testsuite;

import base.Base;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModularTest extends Base {


    //@Test(priority = 0, enabled = true,dataProvider="SearchProvider",dataProviderClass=DataProviderClass.class)
//        @Parameters({"env", "mode"})
    @Test(priority = 0, enabled = true)
    public void LoginTest() throws Exception{

        String loginMsg = "";
        String expectedMsg = "";
        String homePageTitle = "";

        LoginPage lp = new LoginPage();
        HomePage hp = new HomePage();
        try {
            lp.goToLoginPage();
            lp.clearUserID();
            lp.inputUserID();
            lp.clearPasswordField();
            lp.inputPassword();
            lp.clickLoginButtonNavigateToAdminPage();
            System.out.println("clicked login button");
            Thread.sleep(3000);
//            loginMsg = hp.getHomePageMessageText();
//            Assert.assertEquals(loginMsg, expectedMsg + strUserID, "Login is not successful");
            String actualHPTtitle = hp.getHomePageTitle();
            Assert.assertEquals(actualHPTtitle, homePageTitle, "HomePage title is not correct");
        } catch (Exception f) {
            System.out.println("Exception due to unhandled alert");
            Assert.fail("Exception occured, undhandled alert");
        }
    }

    @Test(priority = 1, enabled = true)
    public void resetPasswordTest() throws Exception{

        LoginPage lp = new LoginPage();
        HomePage hp = new HomePage();
        try {
            lp.goToLoginPage();
            lp.clickResetPasswordLink();
            System.out.println("clicked reset password link");
            Thread.sleep(3000);
//            loginMsg = hp.getHomePageMessageText();
//            Assert.assertEquals(loginMsg, expectedMsg + strUserID, "Login is not successful");
//            String actualHPTtitle = hp.getHomePageTitle();
//            Assert.assertEquals(actualHPTtitle, homePageTitle, "HomePage title is not correct");
        } catch (Exception f) {
            System.out.println("Exception due to unhandled alert");
            Assert.fail("Exception occured, undhandled alert");
        }
    }


}
