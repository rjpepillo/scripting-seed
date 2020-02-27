package testcases.dashboard;

import core.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DashboardTest extends BaseTest {
    protected static DashboardPage dashboardPage;
    final String headerText = "OPENSOURCECMS";
    final String headerLink = "https://s1.demo.opensourcecms.com/wordpress/";

    @BeforeClass
    public static void initialize() {
        dashboardPage = new DashboardPage();
    }

    @Test
    public void check_site_header_text() {
        assertEquals(headerText, dashboardPage.getSiteTitleAnchorText());
    }

    @Test
    public void check_site_header_link() {
        assertEquals(dashboardPage.getSiteTitleAnchorLink(), headerLink);
    }

    @Test
    public void check_site_header_link_redirect() {
        dashboardPage.clickSiteTitle();

        this.waitForPageLoad(dashboardPage.getSiteTitleHeaderElement());
        assertEquals(getCurrentUrl(), headerLink);
    }

    @Test(priority = 1)
    public void check_sidebar() {
        assertTrue(dashboardPage.isSidebarDisplayed());
    }

    @Test(priority = 1, dependsOnMethods = "check_sidebar")
    public void check_sidebar_widgets_recent_posts() {
        List<String> widgets = dashboardPage.getWidgetTitles();

        List<String> matches = this.searchInList(widgets, "Recent Posts");
        assertNotNull(matches);
    }

    @Test(priority = 1, dependsOnMethods = "check_sidebar")
    public void check_sidebar_widgets_recent_posts_invalid() {
        List<String> widgets = dashboardPage.getWidgetTitles();

        List<String> matches = this.searchInList(widgets, "Recent Postssss");
        assertEquals(new ArrayList<String>(), matches);
    }

    @Test(priority = 1, dependsOnMethods = "check_sidebar")
    public void check_sidebar_widgets_recent_comments() {
        List<String> widgets = dashboardPage.getWidgetTitles();

        List<String> matches = this.searchInList(widgets, "Recent Comments");
        assertNotNull(matches);
    }

    @Test(priority = 1, dependsOnMethods = "check_sidebar")
    public void check_sidebar_widgets_archives() {
        List<String> widgets = dashboardPage.getWidgetTitles();

        List<String> matches = this.searchInList(widgets, "Archives");
        assertNotNull(matches);
    }

    @Test(priority = 1, dependsOnMethods = "check_sidebar")
    public void check_sidebar_widgets_categories() {
        List<String> widgets = dashboardPage.getWidgetTitles();

        List<String> matches = this.searchInList(widgets, "Categories");
        assertNotNull(matches);
    }

    @Test(priority = 1, dependsOnMethods = "check_sidebar")
    public void check_sidebar_widgets_meta() {
        List<String> widgets = dashboardPage.getWidgetTitles();

        List<String> matches = this.searchInList(widgets, "Meta");
        assertNotNull(matches);
    }

}
