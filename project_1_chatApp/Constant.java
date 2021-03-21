package autotests;

public class Constant {
    public static final String AUTH_PAGE_URL = "http://13.49.68.136";
    public static final String REG_PAGE_URL = "http://13.49.68.136/registration.html";
    public static final String CHAT_PAGE_URL = "http://13.49.68.136";
    public static final String APP_AUTH_URL = "http://13.49.68.136:10080/authorization";
    public static final String APP_REG_URL = "http://13.49.68.136:10080/registration";
    public static final String APP_CHAT_URL = "http://13.49.68.136:10080/chat";

    public static final String AUTH_TITLE = "AUTHORIZATION";
    public static final String REG_TITLE = "Registration";
    public static final String CHAT_TITLE = "skin";

    public static final String AUTH_POST_BODY = "{\"login\":\"%s\", \"password\":\"%s\"}";
    public static final String REG_POST_BODY = "{\"login\":\"%s\", \"password\":\"%s\", \"confirmPassword\":\"%s\", \"email\":\"%s\", \"phoneNumber\":\"%s\", \"companyName\":\"%s\"}";
    public static final String MSG_POST_BODY = "{\"login\":\"%s\", \"message\":\"%s\", \"time\":\"%s\"}";

    public static final String[] VALID_LOGINS = {"user0", "qwertyuiop", "123", "loginwith20symbols12", "d"};
    public static final String[] VALID_PASSWORDS = {"12345678", "passwordwith16sb", "Q12345678q", "qwertyuiop", "Q12345678q"};
    public static final String[] VALID_DOMAINS = {"@gmail.com", "@gmail-xz.com.ua", "@xz.asd", "@20.com", "@s.ua"}; //s@s.commmmmmm
    public static final String[] VALID_PHONE_NUM = {"+38012345678999", "0123456789", "099 123 45 67", "(123) 122 23 23"};
    public static final String[] VALID_COMPANY_NAME = {"company", "companyNaMe1234567891234567890", "1", "Xz", "xz1"};

    public static final String[] INVALID_LOGINS = {"", "   ", "uSer", "123456789012345678901", "qwerty/", "us er", "кириллица"};
    public static final String[] INVALID_PASSWORDS = {"       ", "", "1234567", "1234567812345678a", "1234.5678", "1234 5678", "кириллица"};
    public static final String[] INVALID_DOMAINS = {".@gmail.com", "@.gmail.com", "me@xz..asd", "@20.c", "@s.ua.", "@gma/il.com"};
    public static final String[] INVALID_PHONE_NUM = {"123456789", "123456789012345", "  ", "g", "/"};
    public static final String[] INVALID_COMPANY_NAME = {"кириллица", "sdf/", "   "};

    public static final String SERVER_MSG = "{\"message\":\"success\"}\r";

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirmPassword";
    public static final String EMAIL = "email";
    public static final String PHONE_NUM = "phoneNumber";
    public static final String COMPANY_NAME = "companyName";
    public static final String SEND_MSG_BTN = "sendButton";
    public static final String MSG_FLD = "message";
    public static final String SUBMIT_BTN = "submit";
    public static final String SIGN_IN_BTN = "sign-in-link";
    public static final String MSG_TEXT = "div.message-text";
    public static final String MSG_TIME = "div.message-time";
    public static final String MSG_SENDER = "div.message-sender-login";

    public static final int RANDOM_STR_LEN = 20;
    public static final String EXISTING_EMAIL = "test@gmail.com";
}
