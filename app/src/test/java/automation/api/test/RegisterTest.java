package automation.api.test;

import automation.api.domain.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RegisterTest extends BaseTest {


    @Test
    public void testMissingPassword() {
        User user = new User();
        user.setEmail("sydney@fife");

        given().
                contentType(ContentType.JSON).
                body(user).
        when().
                post("/register").
        then().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                body("error", is("Missing password"));

    }

}