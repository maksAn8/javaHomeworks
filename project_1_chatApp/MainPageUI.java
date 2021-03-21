package autotests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static autotests.Constant.*;

public class MainPageUI {
    private WebDriver wd;
    private WebDriverWait driverWait;
    private WebElement sendMsg;
    private WebElement messageFld;
    private static String myLogin;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        myLogin = "tester";
    }

    @BeforeEach
    public void open() {
        wd = new ChromeDriver();
        driverWait = new WebDriverWait(wd, 3);
        wd.get(CHAT_PAGE_URL);
        sendMsg = wd.findElement(By.id(SEND_MSG_BTN));
        messageFld = wd.findElement(By.id(MSG_FLD));
    }

    @AfterEach
    public void close() {
        wd.quit();
    }

    @Test
    public void test_sendMsg() {
        String myRandomMsg = new RandomString().getRandomString(RANDOM_STR_LEN);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        messageFld.sendKeys(myRandomMsg);
        sendMsg.click();
        driverWait.until(ExpectedConditions.textToBe(By.cssSelector(MSG_SENDER), myLogin));
        driverWait.until(ExpectedConditions.textToBe(By.cssSelector(MSG_TEXT), myRandomMsg));
        driverWait.until(ExpectedConditions.textToBe(By.cssSelector(MSG_TIME), getTime()));
    }

    @Test
    public void test_sendEmptyMsg() {
        sendMsg.click();
        Assertions.assertFalse(isElementPresent("div.message message-send"));
    }

    @Test
    public void test_sendBlankMsg() {
        messageFld.sendKeys("       ");
        sendMsg.click();
        Assertions.assertFalse(isElementPresent("div.message message-send"));
    }

    @Test
    public void test_sendMsgWithSpaces() {
        messageFld.sendKeys("I     like       bananas");
        sendMsg.click();
        Assertions.assertTrue(isElementPresent("div.message message-send"));
        WebElement myMsg = wd.findElement(By.cssSelector("div.message message-send div:nth-of-type(2)"));
        Assertions.assertEquals("I like bananas", myMsg.getText());
    }

    private String getTime() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm");
        return df.format(date);
    }

    public boolean isElementPresent(String selector) {
        try {
            wd.findElement(By.cssSelector(selector));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
