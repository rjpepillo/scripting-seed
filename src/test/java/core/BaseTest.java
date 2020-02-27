package core;

import config.AppConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import services.DriverService;

import java.util.List;
import java.util.stream.Collectors;

public class BaseTest {
    private static BaseTest baseTest;

    public BaseTest() {
        this(false);
    }

    public BaseTest(boolean launch) {
        if(launch) {
            System.out.println(DriverService.getWebDriver());
            DriverService.openBrowser(AppConfig.DEFAULT_APP_URL);
            DriverService.getWebDriver().manage().window().maximize();
        }
    }

    @BeforeClass
    public static void launchApplication()
    {
        DriverService.initialize();
        baseTest = new BaseTest(true);
    }

    @AfterClass
    public static void closeApplication()
    {
        DriverService.closeBrowser();
    }

    protected void waitForPageLoad(WebElement anyElement) {
        WebDriverWait wait = new WebDriverWait(DriverService.getWebDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(anyElement));
    }

    public static String waitForElementNotVisible(WebElement loader) {
        if ((DriverService.getWebDriver() == null) || (loader == null)) {
            return "Wrong usage of waitForElementNotVisible()";
        }
        try {
            WebDriverWait wait = new WebDriverWait(DriverService.getWebDriver(), 5000L);
            wait.until(ExpectedConditions.visibilityOf(loader)); // wait for loader to appear
            wait.until(ExpectedConditions.invisibilityOf(loader)); // wait for loader to disappear
            return null;
        } catch (TimeoutException e) {
            return "Timeed out while waiting for element";
        }
    }

    protected String getCurrentUrl() {
        return DriverService.getWebDriver().getCurrentUrl();
    }

    protected List<String> searchInList(List<String> stringList, String searchText) {
        return stringList.stream().filter(it -> it.contains(searchText)).collect(Collectors.toList());
    }

}
