package guru.qa.tests.android;

import guru.qa.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

@Tag("android")
public class NavBarMenuTests extends TestBase {
    @BeforeEach
    void clickMoreOptionsForOpenNavBarMenu() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Open first article", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_title")).click());
        step("Click 'More options' for open NavBar menu", () ->
                $(accessibilityId("More options")).click());
    }

    @DisplayName("Check navBar menu button Share")
    @Test
    void checkNavBarMenusShareButtonTest() {
        step("Open NavBar menu button: Share", () ->
                $(id("org.wikipedia.alpha:id/page_share")).click());

        step("Check Share menu elements", () ->
                $$(id("android:id/text1")).shouldHave(texts("Bluetooth", "Gmail", "Messages", "Drive")));
    }

    @DisplayName("Check navBar menu button Revision history")
    @Test
    void checkNavBarMenusRevisionHistoryTest() {
        step("Open NavBar menu button: Revision history", () ->
                $(id("org.wikipedia.alpha:id/page_view_edit_history")).click());

        step("Check Revision history pages Title", () ->
                $(id("org.wikipedia.alpha:id/articleTitleView")).should(text("Revision history: BrowserStack")));
    }

    @DisplayName("Check navBar menu button CustomizeToolbar")
    @Test
    void checkNavBarMenusCustomizeToolbarTest() {
        step("Open NavBar menu button: CustomizeToolbar", () ->
                $(id("org.wikipedia.alpha:id/customize_toolbar")).click());

        step("Check header Title elements of menu", () ->
                $$(id("org.wikipedia.alpha:id/headerTitle")).shouldHave(texts("Toolbar", "Menu")));

        step("Check list Item elements of submenu", () ->
                $$(id("org.wikipedia.alpha:id/listItem")).shouldHave(texts("Save", "Language", "Find in article", "Theme", "Contents",
                        "Share", "Watch", "Talk page", "Edit history", "New tab"/*, "Explore", "Categories","Edit article"*/)));
    }

    @DisplayName("Check navBar menu button Talk page")
    @Test
    void checkNavBarMenusTalkPageElementTest() {
        step("Open NavBar menu button: Talk page", () ->
                $(id("org.wikipedia.alpha:id/page_view_talk_page")).click());

        step("Check Talk pages Title", () ->
                $(id("org.wikipedia.alpha:id/toolbarTitle")).should(text("Talk: BrowserStack")));
    }

    @DisplayName("Check navBar menu button Categories")
    @Test
    void checkNavBarMenusCategoriesSubmenuTest() {
        step("Open NavBar menu button: Categories", () ->
                $(id("org.wikipedia.alpha:id/page_categories")).click());

        step("Check Categories меню Title", () ->
                $(id("org.wikipedia.alpha:id/categories_dialog_title")).should(text("Categories")));

        step("Check Categories menu elements", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(texts("Web development software",
                        "Load testing tools", "Unit testing frameworks","Graphical user interface testing")));
    }
//
//    @DisplayName("Check navBar menu button Edit History")
//    @Test
//    void checkNavBarMenusEditHistoryElementTest() {
//        step("Open NavBar menu button: Edit History", () ->
//                $(id("org.wikipedia.alpha:id/page_view_edit_history")).click());
//
//        step("Check Edit History pages Title", () ->
//                $(id("org.wikipedia.alpha:id/articleTitleView")).should(text("Revision history: BrowserStack")));  //Talk: BrowserStack
//    }
}