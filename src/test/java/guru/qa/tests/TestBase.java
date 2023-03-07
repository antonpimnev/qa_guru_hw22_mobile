package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.drivers.BrowserstackDriver;
import guru.qa.drivers.MobileDriver;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.helpers.Attach.getSessionId;

public class TestBase {
    public static String deviceHost = System.getProperty("deviceHost");
    @BeforeAll
    static void beforeAll() {
        if (deviceHost == null) {
            deviceHost = "mobile";
        }

        switch (deviceHost) {
            case "android":
            case "ios":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "mobile":
                Configuration.browser = MobileDriver.class.getName();
                break;
        }
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 15000;
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void tearDown() {
        String sessionId = getSessionId();
        Attach.pageSource();
        closeWebDriver();
        if (!System.getProperty("deviceHost").equals("mobile")) Attach.addVideo(sessionId);
    }
}