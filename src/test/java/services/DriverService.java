package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverService {
    private WebDriver driver;
    public static DriverService driverService;

    public DriverService() {
        driver = new ChromeDriver();
    }

    public static void initialize() {
        setChromeDriverProperty();
        driverService = new DriverService();
    }

    public static WebDriver getWebDriver() {
        return driverService.driver;
    }

    public static void openBrowser(String url) {
        driverService.driver.get(url);
    }

    public static void closeBrowser() {
        driverService.driver.close();
    }

    private static void setChromeDriverProperty(){
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/assets/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\assets\\chromedriver.exe");
        }
    }
}
