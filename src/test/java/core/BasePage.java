package core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class BasePage {

    public boolean hasAnchorElements(WebElement parentElement) {
        return parentElement.findElements(By.tagName("a")) != null;
    }

    public boolean hasTimeElements(WebElement parentElement) {
        return parentElement.findElements(By.tagName("time")) != null;
    }

    public boolean containsText(WebElement parentElement, String searchText) {
        return parentElement.getText().contains(searchText);
    }

    public List<String> getTextFromList(List<WebElement> directParent) {
        return directParent.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public WebElement getElementByAttributeInList(List<WebElement> list, String attribute, String searchAttribute) {
        ListIterator<WebElement> iterator = list.listIterator();
        WebElement searchItem = null;

        while(iterator.hasNext() && searchItem == null) {
            WebElement currentElement = iterator.next();
            if (currentElement.getAttribute(attribute).contains(searchAttribute)) {
                searchItem = currentElement;
            }
        }
        return searchItem;
    }

}
