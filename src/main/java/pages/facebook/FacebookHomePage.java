package pages.facebook;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommonPageClass;
import utils.LoggerUtils;

public class FacebookHomePage extends CommonPageClass {

    private static final String HOME_URL = "https://www.facebook.com/";

    private final By createNewAccountBtn = By.xpath("//a[@data-testid='open-registration-form-button']");

    public FacebookHomePage(WebDriver driver) {
        super(driver);
    }

    public FacebookHomePage open(boolean verify) {
        LoggerUtils.log.debug("open(" + HOME_URL + ")");
        openUrl(HOME_URL);
        if (verify) {
            verifyHomePage();
        }
        return this;
    }

    public FacebookHomePage verifyHomePage() {
        LoggerUtils.log.debug("verifyHomePage()");
        waitUntilPageIsReady(Time.TIME_SHORTER);
        return this;
    }

    public void clickCreateNewAccount() {
        clickOnWebElement(getWebElement(createNewAccountBtn, Time.TIME_SHORTER));
    }
}
