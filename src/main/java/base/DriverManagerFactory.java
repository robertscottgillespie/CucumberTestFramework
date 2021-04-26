package base;

import org.openqa.selenium.WebDriver;



public class DriverManagerFactory {
    WebDriver driverInstance;



    public WebDriver createDriver(BrowserType browser) {

        //DriverManagerType driverManagerType = DriverManagerType.valueOf(browser);
        //WebDriverManager.getInstance(driverManagerType).setup();
        boolean isHeadless = false;

        switch (browser) {
            case CHROME:
                driverInstance = ChromeDriverManager.createDriver();

                break;
            case FIREFOX:
                driverInstance = FirefoxDriverManager.createDriver();
                break;
            default:
                System.out.println("browser not supported");
        }

        return driverInstance;
    }

    public void quitDriver(){

        driverInstance.quit();
        driverInstance = null;
        };
}
