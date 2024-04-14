package org.example.common.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseBrowser {
    public static WebDriver driver;

    public void setUpDriver(String browserName){
        switch (browserName.toLowerCase()) {
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
    }
    public WebDriver getDriver(){
        if (driver==null){
            System.out.println("Web Driver was not initialized");
            System.out.println("Edge Was initialized as default");
            setUpDriver("edge");
        }
        return driver;
    }
    public void navigateToHome(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }
    public  void closeDriver() {
        driver.quit();
    }

}
