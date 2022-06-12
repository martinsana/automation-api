/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package automation.api.test;

import automation.api.domain.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class UserTest extends BaseTest {

    @Test public void testListUserData() {
        given().
                params("page", "2").
        when().
                get("/users").
        then().
                statusCode(HttpStatus.SC_OK).
                body("page", is(2)).
                body("data", is(notNullValue()));
    }

    @Test public void testCreateUser() {
        User user = new User();
        user.setName("morpheus");
        user.setJob("leader");
        given().
               body(user).
        when().
                post("/users").
        then().
                statusCode(HttpStatus.SC_CREATED).
                body("name", is("morpheus"));

    }

}
