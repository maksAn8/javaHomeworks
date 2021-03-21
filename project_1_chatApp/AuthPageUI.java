package autotests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static autotests.Constant.*;

public class AuthPageUI {
    private WebDriver wd;
    private static ChromeOptions options;
    private WebElement submit;
    private WebElement login;
    private WebElement password;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        options = new ChromeOptions();
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
    }

    @BeforeEach
    public void open() {
        wd = new ChromeDriver(options);
        wd.get(AUTH_PAGE_URL);
        login = wd.findElement(By.id(LOGIN));
        password = wd.findElement(By.id(PASSWORD));
        submit = wd.findElement(By.id(SUBMIT_BTN));
    }

    @AfterEach
    public void close() {
        wd.quit();
    }

    @Test  //test passed in debug mode only
    public void testUI_existingUsers_Auth() {
        //WebDriverWait wait = new WebDriverWait(wd, 3);
        for (int i = 0; i < VALID_LOGINS.length; i++) {
            wd.findElement(By.id(LOGIN)).sendKeys(VALID_LOGINS[i]);
            wd.findElement(By.id(PASSWORD)).sendKeys(VALID_PASSWORDS[i]);
            wd.findElement(By.id(SUBMIT_BTN)).click();
//            String winHandleBefore = wd.getWindowHandle();
            wd.switchTo().alert().accept();
//            for(String winHandle : wd.getWindowHandles()){
//                if (!winHandle.equals(winHandleBefore)) {
//                    wd.switchTo().window(winHandle);
//                }
//                if(wd.getTitle().equals("skin")){
//                    System.out.println("Ura!");
//                }
//            }
//            wd.get("http://13.49.68.136/chat.html");
            //wait.until(ExpectedConditions.titleIs(CHAT_TITLE));
            Assertions.assertEquals(CHAT_TITLE, wd.getTitle());
            wd.get(AUTH_PAGE_URL);
        }
    }

    @Test
    public void testUI_nonExistingUser_Auth() {
        login.sendKeys("nonexistinguser");
        password.sendKeys("Q12345678q");
        submit.click();
        wd.switchTo().alert().accept();
        Assertions.assertEquals(AUTH_TITLE, wd.getTitle());
    }

    @Test
    public void testUI_invalidLogin_Auth() {
        testValidation(password, login, VALID_PASSWORDS[0], INVALID_LOGINS);
    }

    @Test
    public void testUI_invalidPassword_Auth() {
        testValidation(login, password, VALID_LOGINS[0], INVALID_PASSWORDS);
    }

    public void testValidation(WebElement validTxtFld, WebElement invalidTxtFld, String validData, String[] invalidData) {
        WebElement invalidInput;
        validTxtFld.sendKeys(validData);
        for (String data : invalidData) {
            invalidTxtFld.sendKeys(data);
            submit.click();
            invalidInput = wd.findElement(By.cssSelector("input:invalid"));
            Assertions.assertTrue(invalidInput.isDisplayed());
            invalidTxtFld.clear();
        }
    }
}
