package guru.qa.tests.android;

import guru.qa.tests.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

@Tags({ @Tag("functional"), @Tag("android") })
@Feature("Меню навигации")
@Story("Проверка работы пунктов навигационного меню")
@Owner("antonpimnev")
@Severity(SeverityLevel.CRITICAL)
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

    @Test
    @DisplayName("Проверка пункта меню Revision history")
    void checkNavBarMenusRevisionHistoryTest() {
        step("Open NavBar menu button: Revision history", () ->
                $(id("org.wikipedia.alpha:id/page_view_edit_history")).click());

        step("Check Revision history pages Title", () ->
                $(id("org.wikipedia.alpha:id/articleTitleView")).should(text("Revision history: BrowserStack")));
    }

    @Test
    @DisplayName("Проверка пункта меню Talk page")
    void checkNavBarMenusTalkPageElementTest() {
        step("Open NavBar menu button: Talk page", () ->
                $(id("org.wikipedia.alpha:id/page_view_talk_page")).click());

        step("Check Talk pages Title", () ->
                $(id("org.wikipedia.alpha:id/toolbarTitle")).should(text("Talk: BrowserStack")));
    }

    @Test
    @DisplayName("Проверка пункта меню Categories")
    void checkNavBarMenusCategoriesSubmenuTest() {
        step("Open NavBar menu button: Categories", () ->
                $(id("org.wikipedia.alpha:id/page_categories")).click());

        step("Check Categories меню Title", () ->
                $(id("org.wikipedia.alpha:id/categories_dialog_title")).should(text("Categories")));

        step("Check Categories menu elements", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(texts("Web development software",
                        "Load testing tools", "Unit testing frameworks","Graphical user interface testing")));
    }
}