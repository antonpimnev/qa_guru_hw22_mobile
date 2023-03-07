package guru.qa.tests.android;

import guru.qa.tests.TestBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tags({ @Tag("functional"), @Tag("android") })
@Feature("Онбординг")
@Story("Проверка работы экранов онбординга")
@Owner("antonpimnev")
@Severity(SeverityLevel.CRITICAL)
public class GettingStartedTests extends TestBase {

    @Test
    @DisplayName("Проверка отображения элементов экранов онбординга")
    void checkGttingStartedOonboardingScreenTest() {
        step("Проверка 'The Free Encyclopedia …in over 300 languages' отображения текста", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Нажать 'Сontinue'", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Проверка 'New ways to explore' отображения текста", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });

        step("Нажать 'Сontinue'", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Проверка 'Reading lists with sync' отображения текста", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });

        step("Нажать 'Сontinue'", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Проверка 'Send anonymous data' отображения текста", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });
    }
}