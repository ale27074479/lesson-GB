package Lesson7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfluenceTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    WebDriverWait webDriverWaitSmall;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(16));
        webDriverWaitSmall = new WebDriverWait(driver, Duration.ofSeconds(7));
        actions = new Actions(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://my-atlassian-site-441.atlassian.net/wiki/home/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("cegog77137@shirulo.com");
        driver.findElement(By.xpath("//span[text()[contains(.,'Продолжить')]]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("cegog77137");
        driver.findElement(By.xpath("//span[text()[contains(.,'Войти')]]")).click();
    }

    @Test
    @DisplayName("Проверим создание страницы с различными стилями текста и их комбинациями")
    void newPage() throws InterruptedException {

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//span[text()[contains(.,'Создать')]]")));
        driver.findElement(By.xpath("//span[text()[contains(.,'Создать')]]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//textarea[@data-test-id=\"editor-title\"]")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@data-test-id=\"editor-title\"]")).sendKeys("Test title");

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Common text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Common text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "b"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Bold text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Bold text']/strong[.='Bold text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "i"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Italics text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Italics text']/em[.='Italics text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "u"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Underlined text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Underlined text']/u[.='Underlined text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Strikethrough text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Strikethrough text']/s[.='Strikethrough text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, Keys.SHIFT, "m"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Code text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Code text']/span[@class = 'code']")), isDisplayed());

        driver.findElement(By.xpath("//span[@aria-label=\"Расширенные параметры форматирования\"]")).click();
        driver.findElement(By.xpath("//span[.='Подстрочный']")).click();
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Index text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Index text']/sub[.='Index text']")), isDisplayed());

        driver.findElement(By.xpath("//span[@aria-label=\"Расширенные параметры форматирования\"]")).click();
        driver.findElement(By.xpath("//span[.='Надстрочный']")).click();
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Exponent text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Exponent text']/sup[.='Exponent text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "bi"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Bold Italics text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Bold Italics text']/em/strong[.='Bold Italics text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "bu"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Bold Underlined text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Bold Underlined text']/strong/u[.='Bold Underlined text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "b"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Bold Strikethrough text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Bold Strikethrough text']/strong/s[.='Bold Strikethrough text']")), isDisplayed());

        driver.findElement(By.xpath("//span[@aria-label=\"Расширенные параметры форматирования\"]")).click();
        driver.findElement(By.xpath("//span[.='Подстрочный']")).click();
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "b"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Bold Index text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Bold Index text']/strong/sub[.='Bold Index text']")), isDisplayed());

        driver.findElement(By.xpath("//span[@aria-label=\"Расширенные параметры форматирования\"]")).click();
        driver.findElement(By.xpath("//span[.='Надстрочный']")).click();
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "b"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Bold Exponent text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Bold Exponent text']/strong/sup[.='Bold Exponent text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "iu"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Italics Underlined text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Italics Underlined text']/em/u[.='Italics Underlined text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "i"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Italics Strikethrough text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Italics Strikethrough text']/em/s[.='Italics Strikethrough text']")), isDisplayed());

        driver.findElement(By.xpath("//span[@aria-label=\"Расширенные параметры форматирования\"]")).click();
        driver.findElement(By.xpath("//span[.='Подстрочный']")).click();
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "i"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Italics Index text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Italics Index text']/em/sub[.='Italics Index text']")), isDisplayed());

        driver.findElement(By.xpath("//span[@aria-label=\"Расширенные параметры форматирования\"]")).click();
        driver.findElement(By.xpath("//span[.='Надстрочный']")).click();
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "i"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Italics Exponent text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Italics Exponent text']/em/sup[.='Italics Exponent text']")), isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "u"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Strikethrough Underline text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Strikethrough Underline text']/s/u[.='Strikethrough Underline text']")), isDisplayed());

        driver.findElement(By.xpath("//span[@aria-label=\"Расширенные параметры форматирования\"]")).click();
        driver.findElement(By.xpath("//span[.='Надстрочный']")).click();
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "u"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Underlined Exponent text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Underlined Exponent text']/sup/u[.='Underlined Exponent text']")), isDisplayed());

        driver.findElement(By.xpath("//span[@aria-label=\"Расширенные параметры форматирования\"]")).click();
        driver.findElement(By.xpath("//span[.='Подстрочный']")).click();
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "u"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Underlined Index text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Underlined Index text']/sub/u[.='Underlined Index text']")), isDisplayed());

        driver.findElement(By.xpath("//span[@aria-label=\"Расширенные параметры форматирования\"]")).click();
        driver.findElement(By.xpath("//span[.='Надстрочный']")).click();
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "u"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Strikethrough Exponent text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Strikethrough Exponent text']/s/sup[.='Strikethrough Exponent text']")), isDisplayed());

        driver.findElement(By.xpath("//span[@aria-label=\"Расширенные параметры форматирования\"]")).click();
        driver.findElement(By.xpath("//span[.='Подстрочный']")).click();
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys(
                Keys.chord(Keys.CONTROL, "u"));
        driver.findElement(By.xpath("//div[@aria-label=\"Main content area\"]")).sendKeys("Strikethrough Index text\n");
        assertThat(driver.findElement(By.xpath(
                "//div[@aria-label=\"Main content area\"]/p[.='Strikethrough Index text']/s/sub[.='Strikethrough Index text']")), isDisplayed());
    }

    @Test
    @DisplayName("Создание и удаление раздела")
    void newSection() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//span[text()[contains(.,'Создать')]]")));
        driver.findElement(By.xpath("//span[.='Разделы']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Создать раздел']")));
        driver.findElement(By.xpath("//span[.='Создать раздел']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[text()[contains(.,'Раздел документации')]]")));
        driver.findElement(By.xpath("//div[text()[contains(.,'Раздел документации')]]")).click();
        driver.findElement(By.xpath("//button[text()[contains(.,'Далее')]]")).click();
        driver.findElement(By.xpath("//label[@for='name']/following-sibling::input")).sendKeys("Test Section");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()[contains(.,'Создать')]]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Настройки раздела']")));
        driver.findElement(By.xpath("//span[.='Настройки раздела']")).click();
        driver.findElement(By.xpath("//span[.='Управление разделом']")).click();
        webDriverWait.until(ExpectedConditions.jsReturnsValue("return document.querySelector(\"#space-settings-v2" +
                "-navigation-portal-container > div > div.css-9jay18.e1678cd51 > div.css-1hycfov.e1678cd52\").textContent == 'Управление разделом'"));
        ((JavascriptExecutor)driver).executeScript("document.querySelectorAll(\"#space-settings-inner-nav-tabs-0\").item(3).click()");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Удалить этот раздел']")));
        driver.findElement(By.xpath("//span[.='Удалить этот раздел']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid=\"delete-space-button\"]")));
        driver.findElement(By.xpath("//button[@data-testid=\"delete-space-button\"]")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.xpath("//span[.='100']")), isDisplayed());
    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }
}