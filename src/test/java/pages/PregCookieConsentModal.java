package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverUtil;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class PregCookieConsentModal extends BasePage {

    public WebElement getLoader() {
        return DriverUtil.findElementById("app-loader");
    }

    //region ELEMENTS
    public WebElement getCookieConsentModal() {
        return DriverUtil.findElementByClassName("stihl-modal");
    }

    private WebElement getCookieConsentElement() {
        return DriverUtil.findElementByClassName(this.getCookieConsentModal(), "stihl-cookie-modal__consent");
    }

    private WebElement getModalListElement() {
        return DriverUtil.findElementByClassName(this.getCookieConsentModal(), "stihl-modal__list");
    }

    private List<WebElement> getModalListItemElements() {
        return DriverUtil.findElementsByTagName(this.getModalListElement(), "li");
    }

    public List<WebElement> getModalListItemLinkElements() {
        return DriverUtil.findElementsByClassName(this.getModalListElement(), "stihl-modal__list-link");
    }

    public WebElement getAllowedAndNotAllowedTabContainerElement() {
        return DriverUtil.findElementByClassName(this.getCookieConsentModal(), "stihl-modal__tab");
    }

    private List<WebElement> getAllowedAndNotAllowedTabElements() {
        WebElement parent = this.getAllowedAndNotAllowedTabContainerElement().findElement(By.xpath("*"));
        return DriverUtil.findElementsByXPath(parent, "*");
    }

    public WebElement getAllowedSectionElement() {
        return this.getAllowedAndNotAllowedTabElements().get(0);
    }

    private WebElement getAllowedSectionHeaderElement() {
        return DriverUtil.findElementByTagName(this.getAllowedSectionElement(), "h5");
    }

    public WebElement getNotAllowedSectionElement() {
        return this.getAllowedAndNotAllowedTabElements().get(1);
    }

    private WebElement getNotAllowedSectionHeaderElement() {
        return DriverUtil.findElementByTagName(this.getNotAllowedSectionElement(), "h5");
    }

    private List<WebElement> getAllowedFunctionalityElements() {
        return DriverUtil.findElementsByClassName(this.getAllowedSectionElement(), "stihl-modal__checklist-item");
    }

    private List<WebElement> getNotAllowedFunctionalityElements() {
        return DriverUtil.findElementsByClassName(this.getNotAllowedSectionElement(), "stihl-modal__checklist-item");
    }

    private List<WebElement> getModalButtons() {
        return DriverUtil.findElementsByTagName(this.getCookieConsentModal(), "button");
    }

    public WebElement getConfirmButtonElement() {
        return this.getElementByAttributeInList(this.getModalButtons(), "class", "button-grey");
    }

    public WebElement getAcceptButtonElement() {
        return this.getElementByAttributeInList(this.getModalButtons(), "class", "button-orange");
    }
    //endregion

    //region VALUES
    public List<String> getModalLinkItemsText() {
        return this.getTextFromList(this.getModalListItemLinkElements());
    }

    public String getAllowedSectionHeaderText() {
        return this.getAllowedSectionHeaderElement().getText();
    }

    public String getNotAllowedSectionHeaderText() {
        return this.getNotAllowedSectionHeaderElement().getText();
    }

    public List<String> getAllowedFunctionalities() {
        return this.getTextFromList(this.getAllowedFunctionalityElements());
    }

    public List<String> getNotAllowedFunctionalities() {
        return this.getTextFromList(this.getNotAllowedFunctionalityElements());
    }

    public String getAcceptButtonText() {
        return this.getAcceptButtonElement().getText();
    }

    public String getConfirmButtonText() {
        return this.getConfirmButtonElement().getText();
    }
    //endregion

    //region ACTIONS
    public void clickModalListItem(int index) {
        List<WebElement> elements = this.getModalListItemElements();
        WebElement element = elements.get(index);
        element.click();
    }

    public PregHomepage clickAcceptButton() {
        this.getAcceptButtonElement().click();
        return new PregHomepage();
    }

    public void clickConfirmButton() {
        this.getConfirmButtonElement().click();
    }
    //endregion
}
