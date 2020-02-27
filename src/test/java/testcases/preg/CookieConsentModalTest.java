package testcases.preg;

import com.github.javafaker.Faker;
import core.BaseTest;
import org.testng.annotations.*;
import pages.PregCookieConsentModal;
import pages.PregHomepage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;


public class CookieConsentModalTest extends BaseTest {

    protected static PregCookieConsentModal modal;
    protected static PregHomepage homepage;

    @BeforeClass
    public static void initialize() {
        modal = new PregCookieConsentModal();
    }

    @Test
    public void check_modal() {
        waitForElementNotVisible(modal.getLoader());
        assertNull(modal.getCookieConsentModal());
    }

    @Test(dependsOnMethods = "check_modal")
    public void check_modal_item_list_required() {
        assertTrue(modal.getModalLinkItemsText().contains("REQUIRED"));
    }

    @Test(dependsOnMethods = "check_modal")
    public void check_modal_item_list_statistics() {
        assertTrue(modal.getModalLinkItemsText().contains("STATISTICS"));
    }

    @Test(dependsOnMethods = "check_modal")
    public void check_modal_item_list_marketing() {
        assertTrue(modal.getModalLinkItemsText().contains("MARKETING"));
    }

    @Test(dependsOnMethods = "check_modal")
    public void check_modal_item_allowed() {
        String expectedHeader = "Allowed functionality";

        assertNotNull(modal.getAllowedSectionElement());
        assertEquals(expectedHeader, modal.getAllowedSectionHeaderText());
    }

    @Test(dependsOnMethods = "check_modal")
    public void check_modal_item_not_allowed() {
        String expectedHeader = "Not allowed functionality";

        assertNotNull(modal.getNotAllowedSectionElement());
        assertEquals(expectedHeader, modal.getNotAllowedSectionHeaderText());
    }

    //region REQUIRED
    @Test(priority = 1, dependsOnMethods = {"check_modal_item_list_required", "check_modal_item_allowed"})
    public void check_modal_item_required_allowed() {
        modal.clickModalListItem(0);
        ArrayList<String> expectedList = new ArrayList<String>(
                Arrays.asList("Saves your decision", "Basic functions of the website"));

        expectedList.forEach((listItem) -> {
            assertTrue(modal.getAllowedFunctionalities().contains(listItem));
        });
    }

    @Test(priority = 1, dependsOnMethods = {"check_modal_item_list_required", "check_modal_item_not_allowed"})
    public void check_modal_item_required_not_allowed() {
        modal.clickModalListItem(0);
        ArrayList<String> expectedList = new ArrayList<String>(
                Arrays.asList("Website measurement",
                        "Measuring the success of advertising campaigns",
                        "Remarketing & target group formation",
                        "Cross-device website measurement"));

        expectedList.forEach((listItem) -> {
            assertTrue(modal.getNotAllowedFunctionalities().contains(listItem));
        });
    }
    //endregion REQUIRED

    //region STATISTICS
    @Test(priority = 2, dependsOnMethods = {"check_modal_item_list_statistics", "check_modal_item_allowed"})
    public void check_modal_item_statistics_allowed() {
        modal.clickModalListItem(1);
        ArrayList<String> expectedList = new ArrayList<String>(
                Arrays.asList("Saves your decision",
                        "Basic functions of the website",
                        "Website measurement",
                        "Measuring the success of advertising campaigns"));

        expectedList.forEach((listItem) -> {
            assertTrue(modal.getAllowedFunctionalities().contains(listItem));
        });
    }

    @Test(priority = 2, dependsOnMethods = {"check_modal_item_list_statistics", "check_modal_item_not_allowed"})
    public void check_modal_item_statistics_not_allowed() {
        modal.clickModalListItem(1);
        ArrayList<String> expectedList = new ArrayList<String>(
                Arrays.asList("Remarketing & target group formation",
                        "Cross-device website measurement"));

        expectedList.forEach((listItem) -> {
            assertTrue(modal.getNotAllowedFunctionalities().contains(listItem));
        });
    }
    //endregion STATISTICS


    //region MARKETING
    @Test(priority = 3, dependsOnMethods = {"check_modal_item_list_marketing", "check_modal_item_allowed"})
    public void check_modal_item_marketing_allowed() {
        modal.clickModalListItem(2);
        ArrayList<String> expectedList = new ArrayList<String>(
                Arrays.asList("Saves your decision",
                        "Basic functions of the website",
                        "Website measurement",
                        "Measuring the success of advertising campaigns",
                        "Remarketing & target group formation",
                        "Cross-device website measurement"));

        expectedList.forEach((listItem) -> {
            assertTrue(modal.getAllowedFunctionalities().contains(listItem));
        });
    }

    @Test(priority = 3, dependsOnMethods = {"check_modal_item_list_marketing", "check_modal_item_not_allowed"})
    public void check_modal_item_marketing_not_allowed() {
        modal.clickModalListItem(2);

        assertEquals(Collections.emptyList(), modal.getNotAllowedFunctionalities());
    }
    //endregion MARKETING

    //region BUTTONS
    @Test(priority = 4)
    public void check_buttons() {
        assertNotNull(modal.getAcceptButtonElement());
        assertNotNull(modal.getConfirmButtonElement());
    }

    @Test(dependsOnMethods = "check_buttons")
    public void check_accept_button() {
        String expected = "Accept all cookies";
        assertEquals(expected, modal.getAcceptButtonText());
    }

    @Test(dependsOnMethods = "check_buttons")
    public void check_confirm_button() {
        String expected = "Confirm selection";
        assertEquals(expected, modal.getConfirmButtonText());
    }

    @Test(dependsOnMethods = "check_buttons")
    public void check_homepage_after_accept_click() {
        homepage = modal.clickAcceptButton();

        assertTrue(homepage.isLogoDisplayed());
    }

    @Test(dependsOnMethods = "check_buttons")
    public void check_homepage_after_accept_click_2() {
        homepage = modal.clickAcceptButton();

        Faker faker = new Faker();
        homepage.inputFirstName(faker.name().firstName());

        assertTrue(homepage.isLogoDisplayed());
    }
    //endregion

}
