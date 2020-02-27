package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import utils.DriverUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage extends BasePage {

    private static final String SITE_TITLE_CLASS = "site-title";

    public WebElement getContentElement() {
        return DriverUtil.findElementById("content");
    }

    //region HEADER
    public WebElement getSiteTitleHeaderElement() {
        return DriverUtil.findElementByClassName(SITE_TITLE_CLASS);
    }

    public WebElement getSiteTitleAnchorElement() {
        return DriverUtil.findElementByTagName(this.getSiteTitleHeaderElement(), "a");
    }

    public String getSiteTitleAnchorLink() {
        return this.getSiteTitleAnchorElement().getAttribute("href");
    }

    public String getSiteTitleAnchorText() {
        return this.getSiteTitleAnchorElement().getText();
    }

    public void clickSiteTitle() {
        this.getSiteTitleAnchorElement().click();
    }
    //endregion

    //region ARTICLES
    public List<WebElement> getArticleElements() {
        return DriverUtil.findElementsByTagName("article");
    }

    protected WebElement getArticleHeaderElement(WebElement articleElement) {
        return DriverUtil.findElementByTagName(articleElement, "header");
    }

    public WebElement getArticleFooterElement(WebElement articleElement) {
        return DriverUtil.findElementByTagName(articleElement, "footer");
    }

    protected WebElement getArticleTitleAnchorElement(WebElement articleElement) {
        return DriverUtil.findElementByTagName(articleElement, "a");
    }

    public String getArticleTitleAnchorLink(WebElement articleElement) {
        return this.getArticleTitleAnchorElement(articleElement).getAttribute("href");
    }

    public String getArticleTitleAnchorText(WebElement articleElement) {
        return this.getArticleTitleAnchorElement(articleElement).getText();
    }

    protected WebElement getArticleContentElement(WebElement articleElement) {
        return DriverUtil.findElementByClassName(articleElement, "entry-content");
    }

    public String getArticleContentText(WebElement articleElement) {
        WebElement element = this.getArticleContentElement(articleElement);
        WebElement paragraph = DriverUtil.findElementByTagName(element, "p");
        return paragraph.getText();
    }

    public boolean isArticleFooterNull(WebElement articleElement) {
        return this.getArticleFooterElement(articleElement) == null;
    }

    public boolean isArticleTitleNull(WebElement articleElement) {
        return this.getArticleHeaderElement(articleElement) == null;
    }


    public boolean isArticleContentNull(WebElement articleElement) {
        return this.getArticleContentElement(articleElement) == null;
    }
    //endregion

    //region SIDEBAR
    protected WebElement getSidebar() {
        return DriverUtil.findElementById("secondary");
    }

    public boolean isSidebarDisplayed() {
        return this.getSidebar().isDisplayed();
    }

    public List<String> getWidgetTitles() {
        List<WebElement> widgetTitleElements = DriverUtil.findElementsByClassName(this.getSidebar(), "widget-title");
        return widgetTitleElements.stream().map(widget -> widget.getText()).collect(Collectors.toList());
    }
    //endregion

}
