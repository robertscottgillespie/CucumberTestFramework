package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends Base implements Driver{
    private static ChromeDriver driver;

    public static WebDriver createDriver() {
        String isHeadless =  appProps.getProperty("headless");;
        ChromeOptions chromeOptions = new ChromeOptions();

        // check for Headless browser mode
        if (isHeadless.equals("false")) {
            chromeOptions.addArguments("--start-maximized");
        } else {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("window-size=1920,1080");
        }

        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver");

        driver = new ChromeDriver(chromeOptions);

        return driver;
}
}
