package testcases.preg;

import com.github.javafaker.Faker;
import core.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PregCookieConsentModal;
import pages.PregHomepage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomepageTest extends BaseTest {

    protected static PregCookieConsentModal modal;
    protected static PregHomepage homepage;
    protected static Faker faker;

    @BeforeClass
    public static void initialize() {
        modal = new PregCookieConsentModal();
        waitForElementNotVisible(modal.getLoader());
        homepage = modal.clickAcceptButton();
        Faker faker = new Faker();
    }

    @Test
    public void test_homepage() {
        homepage.inputFirstName(faker.name().firstName());
        homepage.setLoginForm(faker.name().firstName(), "asdadasfdasfsd");
        // ASSERT HERE
    }

    @Test
    public void test_homepage_2() {
        homepage.inputFirstName(faker.name().firstName());

        homepage.setLoginForm(faker.name().firstName(), "asdadasfdasfsd")
                .clickLogin();

        homepage.clickClickHere();
        // ASSERT HERE
    }

}
