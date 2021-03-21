package autotests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static autotests.Constant.*;
import static autotests.Constant.VALID_LOGINS;

public class ChatValidation {
    private RandomString randomString;

    public ChatValidation() {
        randomString = new RandomString();
    }

    public void testValidation(ChatHttpRequest request, String className, String[] invalidData) throws IOException {
        for (String invData : invalidData) {
            switch (className) {
                case "RegPageAPI":
                    if(invalidData[0].equals(INVALID_LOGINS[0])) {
                        request.createPOSTRequest(APP_REG_URL, String.format(REG_POST_BODY, invData, VALID_PASSWORDS[0],
                                VALID_PASSWORDS[0], randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]), "", ""));
                    } else if(invalidData[0].equals(INVALID_PASSWORDS[0])) {
                        request.createPOSTRequest(APP_REG_URL, String.format(REG_POST_BODY, randomString.getRandomString(RANDOM_STR_LEN), invData,
                                invData, randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]), "", ""));
                    } else if(invalidData[0].equals(INVALID_PHONE_NUM[0])) {
                        request.createPOSTRequest(APP_REG_URL, String.format(REG_POST_BODY, randomString.getRandomString(RANDOM_STR_LEN), VALID_PASSWORDS[0],
                                VALID_PASSWORDS[0], randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]), invData, ""));
                    } else if(invalidData[0].equals(INVALID_COMPANY_NAME[0])) {
                        request.createPOSTRequest(APP_REG_URL, String.format(REG_POST_BODY, randomString.getRandomString(RANDOM_STR_LEN), VALID_PASSWORDS[0],
                                VALID_PASSWORDS[0], randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]), "", invData));
                    } else if(invalidData[0].equals(INVALID_DOMAINS[0])) {
                        request.createPOSTRequest(APP_REG_URL, String.format(REG_POST_BODY, randomString.getRandomString(RANDOM_STR_LEN), VALID_PASSWORDS[0],
                                VALID_PASSWORDS[0], randomString.getRandomEmail(RANDOM_STR_LEN, invData), "", ""));
                    }
                    break;
                case "AuthPageAPI":
                    if(invalidData[0].equals(INVALID_LOGINS[0])) {
                        request.createPOSTRequest(APP_AUTH_URL, String.format(AUTH_POST_BODY, invData, VALID_PASSWORDS[0]));
                    } else {
                        request.createPOSTRequest(APP_AUTH_URL, String.format(AUTH_POST_BODY, VALID_LOGINS[0], invData));
                    }
                    break;
            }
            int actual = request.getConnection().getResponseCode();
            Assertions.assertEquals(401, actual);
//            Assertions.assertEquals(SERVER_MSG, regRequest.getServerMessage());
        }
    }
}
