/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package automation.api.test;

import automation.api.domain.User;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class UserTest extends BaseTest {

    private static final String LIST_USER_ENDPOINT = "/users";
    private static final String CREATE_USER_ENDPOINT = "/users";


    @Test public void testListUserData() {
        given().
                params("page", "2").
        when().
                get(LIST_USER_ENDPOINT).
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
                post(CREATE_USER_ENDPOINT).
        then().
                statusCode(HttpStatus.SC_CREATED).
                body("name", is("morpheus"));

    }

    @Test public void testCheckPerPageSize() {
        given().
                params("page", "2").
        when().
                get(LIST_USER_ENDPOINT).
        then().
                statusCode(HttpStatus.SC_OK).
                body(
                        "page", is(2),
                        "data.size()", is(6),
                        "data.findAll { it.avatar.startsWith('https://reqres.in') }.size()", is(6)
                );

    }

}
