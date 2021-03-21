package autotests;

import org.junit.jupiter.api.*;

import java.io.*;

import static autotests.Constant.*;

public class AuthPageAPI {
    private static ChatHttpRequest authRequest;
    private static ChatValidation chatAPIValidation;
    private final String CLASS_NAME;

    public AuthPageAPI() {
        CLASS_NAME = getClass().getSimpleName();
    }

    @BeforeAll
    public static void setUp() {
        authRequest = new ChatHttpRequest();
        chatAPIValidation = new ChatValidation();
    }

    @Test
    public void testAPI_existingUsers_Auth() throws IOException {
        for (int i = 0; i < VALID_LOGINS.length; i++) {
            authRequest.createPOSTRequest(APP_AUTH_URL, String.format(AUTH_POST_BODY, VALID_LOGINS[i], VALID_PASSWORDS[i]));
            int actual = authRequest.getConnection().getResponseCode();
            Assertions.assertEquals(200, actual);
            Assertions.assertEquals(SERVER_MSG, authRequest.getServerMessage());
        }
    }

    @Test
    public void testAPI_nonExistingUser_Auth() throws IOException {
        authRequest.createPOSTRequest(APP_AUTH_URL, String.format(AUTH_POST_BODY, "nonexistinguser", VALID_PASSWORDS[0]));
        int actual = authRequest.getConnection().getResponseCode();
        Assertions.assertEquals(401, actual);
//        Assertions.assertEquals(SERVER_MSG, authRequest.getServerMessage());
    }

    @Test
    public void testAPI_incorrectPassword_Auth() throws IOException {
        authRequest.createPOSTRequest(APP_AUTH_URL, String.format(AUTH_POST_BODY, VALID_LOGINS[0], "incorrectpswrd"));
        int actual = authRequest.getConnection().getResponseCode();
        Assertions.assertEquals(401, actual);
//        Assertions.assertEquals(SERVER_MSG, authRequest.getServerMessage());
    }

    @Test
    public void testAPI_invalidLogin_Auth() throws IOException {
        chatAPIValidation.testValidation(authRequest, CLASS_NAME, INVALID_LOGINS);
    }

    @Test
    public void testAPI_invalidPassword_Auth() throws IOException {
        chatAPIValidation.testValidation(authRequest, CLASS_NAME, INVALID_PASSWORDS);
    }

    @Test
    public void testAPI_invalidReqBody_Auth() throws IOException {
        String[] invalidReqBodies = {"", "    ", "dfgh"};
        for (String invalidReqBody : invalidReqBodies) {
            authRequest.createPOSTRequest(APP_AUTH_URL, invalidReqBody);
            int actual = authRequest.getConnection().getResponseCode();
            Assertions.assertEquals(500, actual);
//        Assertions.assertEquals(SERVER_MSG, authRequest.getServerMessage());
        }
    }

//    public void testValidation(String validData, String[] invalidData) throws IOException {
//        for (String data : invalidData) {
//            if(validData.equals(VALID_LOGINS[0])) {
//                authRequest.createPOSTRequest(APP_AUTH_URL, String.format(AUTH_POST_BODY, validData, data));
//            } else {
//                authRequest.createPOSTRequest(APP_AUTH_URL, String.format(AUTH_POST_BODY, data, validData));
//            }
//            int actual = authRequest.getConnection().getResponseCode();
//            Assertions.assertEquals(401, actual);
////            Assertions.assertEquals(SERVER_MSG, authRequest.getServerMessage());
//        }
//    }

}

