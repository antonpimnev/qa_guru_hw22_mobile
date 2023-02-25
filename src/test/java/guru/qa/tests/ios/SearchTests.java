package guru.qa.tests.ios;

import guru.qa.tests.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;

public class SearchTests extends TestBase {

    @Tag("ios")
    @Test
    void checkOutputTextTest() {
        step("Click Text Button", () -> {
            $(id("Text Button")).click();
        });

        step("Check initial state Output text", () -> {
            assertEquals("Waiting for text input.", $(id("Text Output")).getText());
        });

        step(format("Set value %s in the input field and press enter", "Selenium"), () -> {
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys("Selenium");
            $(id("Text Input")).pressEnter();
        });

        step("Check Output text", () -> {
            assertEquals("Selenium", $(id("Text Output")).getText());
        });
    }
}