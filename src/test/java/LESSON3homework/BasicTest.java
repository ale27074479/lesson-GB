package LESSON3homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasicTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    String url = "https://www.saucedemo.com/";

    @BeforeEach
    void setUp() {
        webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, 9);
    }
    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}