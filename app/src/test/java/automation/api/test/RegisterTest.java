package automation.api.test;

import automation.api.domain.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RegisterTest extends BaseTest {

    private static final String REGISTER_USER_ENDPOINT = "/register";

    @Test
    public void testMissingPassword() {
        User user = new User();
        user.setEmail("sydney@fife");

        given().
                body(user).
        when().
                post(REGISTER_USER_ENDPOINT).
        then().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                body("error", is("Missing password"));

    }

}
