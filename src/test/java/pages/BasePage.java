package pages;

import org.openqa.selenium.WebDriver;

public class BasePage extends BaseView {

    @Getter
    private HeaderBlock headerBlock = new HeaderBlock(webDriver);

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }
}
