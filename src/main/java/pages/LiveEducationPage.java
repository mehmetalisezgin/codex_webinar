package pages;

import data.Time;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtils;

import org.openqa.selenium.By;
import static data.PageUrlPaths.lIVE_EDUCATION_PAGE;

public class LiveEducationPage extends CommonPageClass {

    public LiveEducationPage(WebDriver driver) {
        super(driver);
    }

    public LiveEducationPage verifyLiveEducationPage() {
        LoggerUtils.log.debug("verifyLiveEducationPage()");
        waitForUrlChange(lIVE_EDUCATION_PAGE, Time.TIME_SHORTER);
        waitUntilPageIsReady(Time.TIME_SHORTER);
        return this;
    }

    public boolean isTextVisible(String text) {
        LoggerUtils.log.debug("isTextVisible(" + text + ")");
        By locator = By.xpath("//*[contains(text(), '" + text + "')]");
        return isWebElementDisplayed(locator, Time.TIME_SHORTER);
    }
}
