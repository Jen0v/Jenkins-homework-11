package pages;

import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;
import pages.component.TableResults;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            userSubjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            userStateInput = $("#react-select-3-input"),
            userCityInput = $("#react-select-4-input"),
            submitInput = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        calendarInput.click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        userSubjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserState(String value) {
        userStateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setUserCity(String value) {
        userCityInput.setValue(value).pressEnter();
        return this;
    }

    public void clickSubmit() {
        submitInput.click();
    }

    public RegistrationPage checkSuccessResult(String key, String value) {
        new TableResults().checkTableResults(key, value);
        return this;
    }
}
