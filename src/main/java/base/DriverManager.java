package base;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    public abstract WebDriver createDriver(String browser);
    public abstract void quitDriver();

}
