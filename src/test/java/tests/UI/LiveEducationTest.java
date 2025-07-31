package tests.UI;

import data.Time;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LiveEducationPage;
import org.testng.Assert;
import utils.DateTimeUtils;
import utils.JavaScriptUtils;
import utils.LoggerUtils;

public class LiveEducationTest extends BaseTestClass {

    private WebDriver driver;
    private final String sTestName = this.getClass().getName();
    private boolean bCreated = false;
    HomePage homePage;
    LiveEducationPage liveEducationPage;
    JavaScriptUtils javaScriptUtils = new JavaScriptUtils();

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        driver = prepareHomePage(testContext, sTestName);
        homePage = new HomePage(driver);
        liveEducationPage = new LiveEducationPage(driver);
        homePage.clickLiveEducation();
        DateTimeUtils.wait(Time.TIME_DEMONSTRATION);
        liveEducationPage.verifyLiveEducationPage();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        LoggerUtils.log.debug("[END TEST] " + sTestName);
        tearDown(driver, result);
    }


    @Test
    public void verifyScheduleTextIsVisible() {
        String expectedText = "Every weekday at 8:00 AM";
        DateTimeUtils.wait(Time.TIME_DEMONSTRATION);
        boolean isDisplayed = liveEducationPage.isTextVisible(expectedText);
        Assert.assertTrue(isDisplayed,
                "Schedule text should be visible on Live Education page");
    }


}
