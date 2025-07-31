package pages.facebook;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommonPageClass;
import utils.LoggerUtils;

public class FacebookSignUpPage extends CommonPageClass {

    private final By firstNameInput = By.name("firstname");
    private final By lastNameInput = By.name("lastname");
    private final By emailInput = By.name("reg_email__");
    private final By emailConfirmInput = By.name("reg_email_confirmation__");
    private final By passwordInput = By.name("reg_passwd__");
    private final By birthDaySelect = By.id("day");
    private final By birthMonthSelect = By.id("month");
    private final By birthYearSelect = By.id("year");
    private final By femaleRadio = By.xpath("//input[@name='sex' and @value='1']");
    private final By maleRadio = By.xpath("//input[@name='sex' and @value='2']");
    private final By customRadio = By.xpath("//input[@name='sex' and @value='-1']");
    private final By signUpButton = By.name("websubmit");

    public FacebookSignUpPage(WebDriver driver) {
        super(driver);
    }

    public FacebookSignUpPage verifySignUpPage() {
        LoggerUtils.log.debug("verifySignUpPage()");
        waitUntilPageIsReady(Time.TIME_SHORTER);
        return this;
    }

    public FacebookSignUpPage enterFirstName(String firstName) {
        clearAndTypeTextToWebElement(getWebElement(firstNameInput, Time.TIME_SHORTER), firstName);
        return this;
    }

    public FacebookSignUpPage enterLastName(String lastName) {
        clearAndTypeTextToWebElement(getWebElement(lastNameInput, Time.TIME_SHORTER), lastName);
        return this;
    }

    public FacebookSignUpPage enterEmail(String email) {
        clearAndTypeTextToWebElement(getWebElement(emailInput, Time.TIME_SHORTER), email);
        WebElement confirm = getWebElement(emailConfirmInput, Time.TIME_SHORTER);
        if (isWebElementDisplayed(confirm)) {
            clearAndTypeTextToWebElement(confirm, email);
        }
        return this;
    }

    public FacebookSignUpPage enterPassword(String password) {
        clearAndTypeTextToWebElement(getWebElement(passwordInput, Time.TIME_SHORTER), password);
        return this;
    }

    public FacebookSignUpPage selectBirthDate(String day, String month, String year) {
        selectDropDownListOptionByText(getWebElement(birthDaySelect, Time.TIME_SHORTER), day);
        selectDropDownListOptionByText(getWebElement(birthMonthSelect, Time.TIME_SHORTER), month);
        selectDropDownListOptionByText(getWebElement(birthYearSelect, Time.TIME_SHORTER), year);
        return this;
    }

    public FacebookSignUpPage selectGender(String gender) {
        WebElement option;
        gender = gender.toLowerCase();
        switch (gender) {
            case "female" -> option = getWebElement(femaleRadio, Time.TIME_SHORTER);
            case "male" -> option = getWebElement(maleRadio, Time.TIME_SHORTER);
            default -> option = getWebElement(customRadio, Time.TIME_SHORTER);
        }
        clickOnWebElement(option);
        return this;
    }

    public void submitForm() {
        clickOnWebElement(getWebElement(signUpButton, Time.TIME_SHORTER));
    }
}
