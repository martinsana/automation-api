package automation.api.test;

import automation.api.domain.User;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class RegisterTest extends BaseTest {

    private static final String REGISTER_USER_ENDPOINT = "/register";
    private static final String LOGIN_USER_ENDPOINT = "/login";

    @BeforeClass
    public static void setupRegister() {
        RestAssured.responseSpecification = new ResponseSpecBuilder().
                expectStatusCode(HttpStatus.SC_BAD_REQUEST).
                build();

    }

    @Test
    public void testMissingPassword() {
        User user = new User();
        user.setEmail("sydney@fife");

        given().
                body(user).
        when().
                post(LOGIN_USER_ENDPOINT).
        then().
                body("error", is("Missing password"));

    }

    @Test
    public void testLoginMissingPassword() {
        User user = new User();
        user.setEmail("sydney@fife");

        given().
                body(user).
                when().
                post(REGISTER_USER_ENDPOINT).
                then().
                body("error", is("Missing password"));

    }

}
