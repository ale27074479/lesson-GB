package LESSON3homework;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.Zip;

import javax.enterprise.inject.New;

public class ShopWithoutPageObjectTest extends BasicTest{
    private final String username = "standard_user";
    private final String password = "secret_sauce";
    private final Faker faker = new Faker();

           @Test
    void selectBackpackClick(){
        webDriver.get("https://www.saucedemo.com/");
        webDriver.findElement(By.id("email")).sendKeys(username);
        webDriver.findElement(By.id("passwd")).sendKeys(password);
        webDriver.findElement(By.id("SubmitLogin")).click();

        Actions actions = new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
    }

        @Test
        void selectBackpack() {
            webDriver.get("https://www.saucedemo.com/");
            webDriver.findElement(By.id("email")).sendKeys(username);
            webDriver.findElement(By.id("passwd")).sendKeys(password);
            webDriver.findElement(By.id("SubmitLogin")).click();


            New Actions (webDriver)
                    .moveToElement(webDriver.findElement(By.xpath("///*[@id=\"item_4_title_link\"]/div")))
                    .build()
                    .perform();
            webDriver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        }

            @Test
            void checkout(){
                webDriver.get("https://www.saucedemo.com/");
                webDriver.findElement(By.id("email")).sendKeys(username);
                webDriver.findElement(By.id("passwd")).sendKeys(password);
                webDriver.findElement(By.id("SubmitLogin")).click();


                New Actions (webDriver)
                        .moveToElement(webDriver.findElement(By.xpath("///*[@id=\"item_4_title_link\"]/div")))
                        .build()
                        .perform();
                webDriver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
                webDriver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
                webDriver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
                String name = faker.name().firstName();
                String name1 = faker.name().lastName();
                String name2 = faker.name().ZipPostalCode();
                webDriver.findElement(By.id("lastname")).sendKeys(name1);
                webDriver.findElement(By.id("firstname")).sendKeys(name);
                webDriver.findElement(By.id("Zip/Postal Code")).sendKeys(name2);
                webDriver.findElement(By.id("continue")).click();

            }


    @Test
    void selectTShirt() {
        webDriver.get("https://www.saucedemo.com/");
        webDriver.findElement(By.id("email")).sendKeys(username);
        webDriver.findElement(By.id("passwd")).sendKeys(password);
        webDriver.findElement(By.id("SubmitLogin")).click();


        New Actions (webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
        webDriver.findElement(By.id("Remove")).click();
    }

}
