package guru.qa.helpers;

import guru.qa.config.Config;
import org.aeonbits.owner.ConfigFactory;
import static guru.qa.helpers.CustomListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    public static String getVideoUrl(String sessionId) {
        Config config = ConfigFactory.create(Config.class);
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(config.getBrowserstackUser(),config.getBrowserstackKey())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .path("automation_session.video_url");
    }
}