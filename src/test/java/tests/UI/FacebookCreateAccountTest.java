package tests.UI;

import data.Time;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.facebook.FacebookHomePage;
import pages.facebook.FacebookSignUpPage;
import utils.DateTimeUtils;
import utils.LoggerUtils;

public class FacebookCreateAccountTest extends BaseTestClass {

    private WebDriver driver;
    private final String sTestName = this.getClass().getName();
    private FacebookHomePage facebookHomePage;
    private FacebookSignUpPage facebookSignUpPage;

    // Test data variables
    private final String firstName = "Test";
    private final String lastName = "User";
    private final String email = "testuser" + System.currentTimeMillis() + "@example.com";
    private final String password = "Password123!";
    private final String birthDay = "10";
    private final String birthMonth = "May";
    private final String birthYear = "1990";
    private final String gender = "Female";

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        driver = setUpMaxResolution();
        testContext.setAttribute(sTestName + ".drivers", new WebDriver[]{driver});
        facebookHomePage = new FacebookHomePage(driver);
        facebookSignUpPage = new FacebookSignUpPage(driver);
        facebookHomePage.open(true);
        DateTimeUtils.wait(Time.TIME_SHORTER);
        facebookHomePage.clickCreateNewAccount();
        facebookSignUpPage.verifySignUpPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        LoggerUtils.log.debug("[END TEST] " + sTestName);
        tearDown(driver, result);
    }

    @Test
    public void testCreateAccountFlow() {
        facebookSignUpPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .selectBirthDate(birthDay, birthMonth, birthYear)
                .selectGender(gender)
                .submitForm();
        // Additional verifications could be added here (e.g., check for success or error messages)
    }
}
