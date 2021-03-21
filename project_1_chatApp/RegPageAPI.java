package autotests;

import org.junit.jupiter.api.*;


import java.io.IOException;
import java.util.Random;

import static autotests.Constant.*;

public class RegPageAPI {

    private static ChatHttpRequest regRequest;
    private static RandomString randomString;
    private static ChatValidation chatValidation;
    private static Random random;
    private final String CLASS_NAME;

    public RegPageAPI() {
        CLASS_NAME = getClass().getSimpleName();
    }

    @BeforeAll
    public static void setUp() {
        regRequest = new ChatHttpRequest();
        chatValidation = new ChatValidation();
        randomString = new RandomString();
        random = new Random();
    }

    @Test
    public void testAPI_Registration() throws IOException {
        regRequest.createPOSTRequest(APP_REG_URL, String.format(REG_POST_BODY, randomString.getRandomString(RANDOM_STR_LEN),
                VALID_PASSWORDS[0], VALID_PASSWORDS[0], randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[random.nextInt(VALID_DOMAINS.length)]), "", ""));
        int actual = regRequest.getConnection().getResponseCode();
        Assertions.assertEquals(200, actual);
//        Assertions.assertEquals(SERVER_MSG, regRequest.getServerMessage());
    }

    @Test
    public void testAPI_RegistrationAllFields() throws IOException {
        regRequest.createPOSTRequest(APP_REG_URL, String.format(REG_POST_BODY, randomString.getRandomString(RANDOM_STR_LEN),
                VALID_PASSWORDS[0], VALID_PASSWORDS[0], randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[random.nextInt(VALID_DOMAINS.length)]), VALID_PHONE_NUM[0], VALID_COMPANY_NAME[0]));
        int actual = regRequest.getConnection().getResponseCode();
        Assertions.assertEquals(200, actual);
//        Assertions.assertEquals(SERVER_MSG, regRequest.getServerMessage());
    }

    @Test
    public void testAPI_existingLogin_Reg() throws IOException {
        regRequest.createPOSTRequest(APP_REG_URL, String.format(REG_POST_BODY, VALID_LOGINS[0], VALID_PASSWORDS[0],
                VALID_PASSWORDS[0], randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]), "", ""));
        int actual = regRequest.getConnection().getResponseCode();
        Assertions.assertEquals(401, actual);
        //Assertions.assertEquals(SERVER_MSG, regRequest.getServerMessage());
    }

    @Test
    public void testAPI_existingEmail_Reg() throws IOException {
        regRequest.createPOSTRequest(APP_REG_URL, String.format(REG_POST_BODY, randomString.getRandomString(RANDOM_STR_LEN), VALID_PASSWORDS[0],
                VALID_PASSWORDS[0], EXISTING_EMAIL, "", ""));
        int actual = regRequest.getConnection().getResponseCode();
        Assertions.assertEquals(401, actual);
        //Assertions.assertEquals(SERVER_MSG, regRequest.getServerMessage());
    }

    @Test
    public void testAPI_isNotConfirmedPassword_Reg() throws IOException {
        regRequest.createPOSTRequest(APP_REG_URL, String.format(REG_POST_BODY, randomString.getRandomString(RANDOM_STR_LEN), VALID_PASSWORDS[0],
                "", randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]), "", ""));
        int actual = regRequest.getConnection().getResponseCode();
        Assertions.assertEquals(401, actual);
        //Assertions.assertEquals(SERVER_MSG, regRequest.getServerMessage());
    }

    @Test
    public void testAPI_invalidLogin_Reg() throws IOException {
        chatValidation.testValidation(regRequest, CLASS_NAME, INVALID_LOGINS);
    }

    @Test
    public void testAPI_invalidPassword_Reg() throws IOException {
        chatValidation.testValidation(regRequest, CLASS_NAME, INVALID_PASSWORDS);
    }

    @Test
    public void testAPI_invalidEmail_Reg() throws IOException {
        chatValidation.testValidation(regRequest, CLASS_NAME, INVALID_DOMAINS);
    }

    @Test
    public void testAPI_invalidPhoneNum_Reg() throws IOException {
        chatValidation.testValidation(regRequest, CLASS_NAME, INVALID_PHONE_NUM);
    }

    @Test
    public void testAPI_invalidCompanyName_Reg() throws IOException {
        chatValidation.testValidation(regRequest, CLASS_NAME, INVALID_COMPANY_NAME);
    }

    @Test
    public void testAPI_invalidReqBody_Reg() throws IOException {
        String[] invalidReqBodies = {"", "    ", "dfgh"};
        for (String invalidReqBody : invalidReqBodies) {
            regRequest.createPOSTRequest(APP_REG_URL, invalidReqBody);
            int actual = regRequest.getConnection().getResponseCode();
            Assertions.assertEquals(500, actual);
//        Assertions.assertEquals(SERVER_MSG, regRequest.getServerMessage());
        }
    }

}
