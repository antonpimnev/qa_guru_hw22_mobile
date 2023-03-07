package guru.qa.tests.ios;

import guru.qa.tests.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;

@Tags({ @Tag("functional"), @Tag("ios") })
@Feature("Поиск")
@Story("Проверка поиска по ключевому слову")
@Owner("antonpimnev")
@Severity(SeverityLevel.CRITICAL)
public class SearchTests extends TestBase {

    @Test
    @DisplayName("Проверка поиска по ключевому слову")
    void checkOutputTextTest() {
        step("Нажатие на Text Button", () -> {
            $(id("Text Button")).click();
        });

        step("Проверка начального состояния", () -> {
            assertEquals("Waiting for text input.", $(id("Text Output")).getText());
        });

        step(format("Установка значения %s поля и нажатие Enter", "Selenium"), () -> {
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys("Selenium");
            $(id("Text Input")).pressEnter();
        });

        step("Проверка Output text", () -> {
            assertEquals("Selenium", $(id("Text Output")).getText());
        });
    }
}