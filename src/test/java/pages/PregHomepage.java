package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import utils.DriverUtil;

import java.util.List;

public class PregHomepage extends BasePage {

    //region ELEMENT
    private WebElement getLogo() {
        return DriverUtil.findElementByClassName("logo");
    }

    private WebElement getFirstNameElement() {
        return DriverUtil.findElementById("firstName");
    }

    private WebElement getLoginForm() {
        return DriverUtil.findElementById("login-form");
    }

    private WebElement getEmailElement() {
        return DriverUtil.findElementByClassName("email");
    }

    private WebElement getPasswordElement() {
        return DriverUtil.findElementByClassName("password");
    }

    private WebElement getLoginButtonElement() {
        return DriverUtil.findElementById("login-button");
    }

    private List<WebElement> getStartLinkElements() {
        return DriverUtil.findElementsByClassName("start-link");
    }

    private WebElement getClickHere() {
        return this.getStartLinkElements().get(0);
    }

    private WebElement getDataProtectionPolicy() {
        return this.getStartLinkElements().get(1);
    }

    private WebElement getRegisterContainer() {
        return DriverUtil.findElementByClassName("register-container");
    }
    //endregion ELEMENTS

    //region VALUE AND ACTIONS
    public boolean isLogoDisplayed() {
        return this.getLogo().isDisplayed();
    }

    public void inputFirstName(String input) {
        this.getFirstNameElement().sendKeys(input);
    }

    public PregHomepage setLoginForm(String email, String password) {
        this.getEmailElement().sendKeys(email);
        this.getPasswordElement().sendKeys(password);
        return this;
    }

    public PregHomepage clickLogin() {
        this.getLoginButtonElement().click();
        return this;
    }

    public void clickClickHere() {
        this.getClickHere().click();
    }
    //endregion VALUE AND ACTIONS



}
