package automation.api.test;

import automation.api.domain.User;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Login extends BaseTest{

    private static final String LOGIN_USER_ENDPOINT = "/login";

    @BeforeClass
    public static void setupRegister() {
        RestAssured.responseSpecification = new ResponseSpecBuilder().
                expectStatusCode(HttpStatus.SC_BAD_REQUEST).
                build();

    }

    @Test
    public void testLoginMissingPassword() {
        User user = new User();
        user.setEmail("sydney@fife");

        given().
                body(user).
                when().
                post(LOGIN_USER_ENDPOINT).
                then().
                body("error", is("Missing password"));

    }
}
