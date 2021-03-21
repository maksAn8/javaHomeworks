package autotests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static autotests.Constant.*;

public class RegPageUI {

    private WebDriver wd;
    private WebDriverWait driverWait;
    private static ChromeOptions options;
    private WebElement submit;
    private WebElement login;
    private WebElement password;
    private WebElement confirmPassword;
    private WebElement email;
    private WebElement phoneNumber;
    private WebElement companyName;
    private WebElement signIn;
    private static RandomString randomString;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        options = new ChromeOptions();
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        randomString = new RandomString();
    }

    @BeforeEach
    public void open() {
        wd = new ChromeDriver(options);
        wd.get(REG_PAGE_URL);
        driverWait = new WebDriverWait(wd, 3);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        login = wd.findElement(By.id(LOGIN));
        password = wd.findElement(By.id(PASSWORD));
        confirmPassword = wd.findElement(By.id(CONFIRM_PASSWORD));
        email = wd.findElement(By.id(EMAIL));
        phoneNumber = wd.findElement(By.id(PHONE_NUM));
        companyName = wd.findElement(By.id(COMPANY_NAME));
        submit = wd.findElement(By.id(SUBMIT_BTN));
        signIn = wd.findElement(By.id(SIGN_IN_BTN));
    }

    @AfterEach
    public void close() {
        wd.quit();
    }

    @Test
    public void testUI_allFields_Reg() {
        for(int i = 0; i < VALID_PASSWORDS.length; i++) {
            //driverWait.until(ExpectedConditions.titleIs(REG_TITLE));
            wd.findElement(By.id(LOGIN)).sendKeys(randomString.getRandomString(RANDOM_STR_LEN));
            wd.findElement(By.id(PASSWORD)).sendKeys(VALID_PASSWORDS[i]);
            wd.findElement(By.id(CONFIRM_PASSWORD)).sendKeys(VALID_PASSWORDS[i]);
            wd.findElement(By.id(EMAIL)).sendKeys(randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[i]));
            wd.findElement(By.id(PHONE_NUM)).sendKeys(VALID_PHONE_NUM[i]);
            wd.findElement(By.id(COMPANY_NAME)).sendKeys(VALID_COMPANY_NAME[i]);
            wd.findElement(By.id(SUBMIT_BTN)).click();
            wd.switchTo().alert().accept();
            Assertions.assertEquals(AUTH_TITLE, wd.getTitle());
            wd.findElement(By.id(SIGN_IN_BTN)).click();
        }
    }

    @Test
    public void testUI_existingLogin_Reg() {
        login.sendKeys(VALID_LOGINS[0]);
        password.sendKeys(VALID_PASSWORDS[0]);
        confirmPassword.sendKeys(VALID_PASSWORDS[0]);
        email.sendKeys(randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]));
        submit.click();
        wd.switchTo().alert().accept();
        Assertions.assertEquals(REG_TITLE, wd.getTitle());
    }

    @Test
    public void testUI_existingEmail_Reg() {
        login.sendKeys(randomString.getRandomString(RANDOM_STR_LEN));
        password.sendKeys(VALID_PASSWORDS[0]);
        confirmPassword.sendKeys(VALID_PASSWORDS[0]);
        email.sendKeys(EXISTING_EMAIL);
        submit.click();
        wd.switchTo().alert().accept();
//        wd.switchTo().alert().accept();
//        wd.switchTo().alert().accept();
        Assertions.assertEquals(REG_TITLE, wd.getTitle());
    }

    @Test
    public void testUI_invalidLogin_Reg() {
        password.sendKeys(VALID_PASSWORDS[0]);
        confirmPassword.sendKeys(VALID_PASSWORDS[0]);
        email.sendKeys(randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]));
        testValidation(login, INVALID_LOGINS);
    }

    @Test
    public void testUI_invalidPassword_Reg() {
        login.sendKeys(randomString.getRandomString(RANDOM_STR_LEN));
        confirmPassword.sendKeys(VALID_PASSWORDS[0]);
        email.sendKeys(randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]));
        testValidation(password, INVALID_PASSWORDS);
    }

    @Test
    public void testUI_invalidConfirmPassword_Reg() {
        login.sendKeys(randomString.getRandomString(RANDOM_STR_LEN));
        password.sendKeys(VALID_PASSWORDS[0]);
        email.sendKeys(randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]));
        testValidation(confirmPassword, INVALID_PASSWORDS);
    }

    @Test
    public void testUI_invalidEmail_Reg() {
        login.sendKeys(randomString.getRandomString(RANDOM_STR_LEN));
        password.sendKeys(VALID_PASSWORDS[0]);
        confirmPassword.sendKeys(VALID_PASSWORDS[0]);
        testValidation(email, INVALID_DOMAINS);
    }

    @Test
    public void testUI_invalidPhoneNumber_Reg() {
        login.sendKeys(randomString.getRandomString(RANDOM_STR_LEN));
        password.sendKeys(VALID_PASSWORDS[0]);
        confirmPassword.sendKeys(VALID_PASSWORDS[0]);
        email.sendKeys(randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]));
        testValidation(phoneNumber, INVALID_PHONE_NUM);
    }

    @Test
    public void testUI_invalidCompanyName_Reg() {
        login.sendKeys(randomString.getRandomString(RANDOM_STR_LEN));
        password.sendKeys(VALID_PASSWORDS[0]);
        confirmPassword.sendKeys(VALID_PASSWORDS[0]);
        email.sendKeys(randomString.getRandomEmail(RANDOM_STR_LEN, VALID_DOMAINS[0]));
        testValidation(companyName, INVALID_COMPANY_NAME);
    }

    public void testValidation(WebElement invalidTxtFld, String[] invalidData) {
        WebElement invalidInput;
        for (String data : invalidData) {
            if(invalidData[0].equals(INVALID_DOMAINS[0])) {
                invalidTxtFld.sendKeys(randomString.getRandomEmail(RANDOM_STR_LEN, data));
            } else {
                invalidTxtFld.sendKeys(data);
            }
            submit.click();
            invalidInput = wd.findElement(By.cssSelector("input:invalid"));
            Assertions.assertTrue(invalidInput.isDisplayed());
            invalidTxtFld.clear();
        }
    }
}
