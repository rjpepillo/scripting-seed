package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import services.DriverService;

import java.util.List;

public class DriverUtil {

    public static WebElement findElementById(String id) {
        return DriverService.getWebDriver().findElement(By.id(id));
    }

    public static WebElement findElementById(WebElement parentElement, String id) {
        return parentElement.findElement(By.id(id));
    }

    public static WebElement findElementByClassName(String className) {
        return DriverService.getWebDriver().findElement(By.className(className));
    }

    public static WebElement findElementByClassName(WebElement parentElement, String className) {
        return parentElement.findElement(By.className(className));
    }

    public static List<WebElement> findElementsByClassName(String className) {
        return DriverService.getWebDriver().findElements(By.className(className));
    }

    public static List<WebElement> findElementsByClassName(WebElement parentElement, String className) {
        return parentElement.findElements(By.className(className));
    }

    public static WebElement findElementByTagName(String tagName) {
        return DriverService.getWebDriver().findElement(By.tagName(tagName));
    }

    public static WebElement findElementByTagName(WebElement parentElement, String tagName) {
        return parentElement.findElement(By.tagName(tagName));
    }

    public static List<WebElement> findElementsByTagName(String tagName) {
        return DriverService.getWebDriver().findElements(By.tagName(tagName));
    }

    public static List<WebElement> findElementsByTagName(WebElement parentElement, String tagName) {
        return parentElement.findElements(By.tagName(tagName));
    }

    public static WebElement findElementByXPath(String xpath) {
        return DriverService.getWebDriver().findElement(By.xpath(xpath));
    }

    public static WebElement findElementByXPath(WebElement parentElement, String xpath) {
        return parentElement.findElement(By.xpath(xpath));
    }

    public static List<WebElement> findElementsByXPath(String xpath) {
        return DriverService.getWebDriver().findElements(By.xpath(xpath));
    }

    public static List<WebElement> findElementsByXPath(WebElement parentElement, String xpath) {
        return parentElement.findElements(By.xpath(xpath));
    }

}
