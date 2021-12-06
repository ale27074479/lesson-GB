import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Login {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        webDriver.get("https://www.saucedemo.com/");

        webDriver.manage().window().setSize(new Dimension(1500, 720));

        webDriver.findElement(By.name("_username")).sendKeys("standard_user");
        webDriver.findElement(By.name("_password")).sendKeys("secret_sauce");
        webDriver.findElement(By.name("_submit")).click();

    }
    Actions actions = new Actions(webDriver);
    actions.moveToElement(webDriver.findElement(By.xpath([@id="add-to-cart-sauce-labs-backpack"]).click();
    webDriver.findElement(By.xpath(*[@id="shopping_cart_container"]/a).click();
}
