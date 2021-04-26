package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import base.BrowserType;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public static Properties appProps;


    //@BeforeTest
    public static void launchApplication()  {
        //Runtime.getRuntime().exec("taskkill /f /im chrome.exe");
        //Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
        loadPropertiesFile();
        DriverManagerFactory dm = new DriverManagerFactory();
        driver  = dm.createDriver(BrowserType.CHROME);
        //driver = DriverManager.setBrowser(); this should replace above statement
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    public static void loadPropertiesFile() {
        try (InputStream input = Base.class.getClassLoader().getResourceAsStream("SeleniumConfig.properties")) {
            appProps = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            appProps.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            //Assert.fail("Unable to load properties file: " + ex.getMessage());
        }
    }

    //@AfterTest
    public static void closeBrowser(){
        driver.quit();
    }
}
