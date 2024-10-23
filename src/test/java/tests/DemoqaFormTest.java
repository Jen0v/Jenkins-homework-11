package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class DemoqaFormTest extends TestBase {

    private final RegistrationPage demoqaFormPage = new RegistrationPage();

    String firstName = "Petrov",
            lastName = "Ivan",
            userEmail = "ivan@yandex.com",
            gender = "Male",
            userNumber = "9000000001",
            dayOfBirth = "15",
            monthOfBirth = "October",
            yearOfBirth = "1995",
            subjects = "History",
            hobbies = "Music",
            pictureName = "photo.jpg",
            address = "Some street 1",
            state = "Haryana",
            city = "Karnal";

    @Test
    @Tag("fullFormTest")
    @DisplayName("Проверка заполнения всех полей формы")
    void fullFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть форму", () -> {
            demoqaFormPage.openPage()
                    .removeBanner();
        });

        step("Заполнить firstName", () ->
                demoqaFormPage.setFirstName(firstName));

        step("Заполнить lastName", () ->
                demoqaFormPage.setLastName(lastName));

        step("Заполнить userEmail", () ->
                demoqaFormPage.setEmail(userEmail));
        step("Заполнить gender", () ->
                demoqaFormPage.setGender(gender));
        step("Заполнить userNumber", () ->
                demoqaFormPage.setUserNumber(userNumber));
        step("Заполнить BirthDay", () ->
                demoqaFormPage.setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth));
        step("Заполнить subjects", () ->
                demoqaFormPage.setSubject(subjects));
        step("Заполнить hobbies", () ->
                demoqaFormPage.setHobby(hobbies));
        step("Заполнить pictureName", () ->
                demoqaFormPage.uploadPicture(pictureName));
        step("Заполнить address", () ->
                demoqaFormPage.setCurrentAddress(address));
        step("Заполнить state", () ->
                demoqaFormPage.setUserState(state));
        step("Заполнить city", () ->
                demoqaFormPage.setUserCity(city));
        step("Нажать Submit", demoqaFormPage::clickSubmit);

        step("Проверка заполненных полей", () -> {
            demoqaFormPage.checkSuccessResult("Student Name", firstName + " " + lastName)
                    .checkSuccessResult("Student Email", userEmail)
                    .checkSuccessResult("Gender", gender)
                    .checkSuccessResult("Mobile", userNumber)
                    .checkSuccessResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkSuccessResult("Subjects", subjects)
                    .checkSuccessResult("Hobbies", hobbies)
                    .checkSuccessResult("Picture", pictureName)
                    .checkSuccessResult("Address", address)
                    .checkSuccessResult("State and City", state + " " + city);
        });
    }
}