package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import services.DriverService;

public class ScrollService {

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverService.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) DriverService.getWebDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
