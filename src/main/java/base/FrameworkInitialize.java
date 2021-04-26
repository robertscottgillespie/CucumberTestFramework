package base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FrameworkInitialize {
    public static org.openqa.selenium.WebDriver Driver;

    private static final Logger logger = LogManager.getLogger(FrameworkInitialize.class);

    public static void setDriver(org.openqa.selenium.WebDriver driver) {
        Driver = driver;
    }

    public static org.openqa.selenium.WebDriver InitializeBrowser(BrowserType browser)
    {

        org.openqa.selenium.WebDriver driver = null;
        DriverManagerFactory dm = new DriverManagerFactory();
        driver  = dm.createDriver(browser);
        return driver;


    }


}
