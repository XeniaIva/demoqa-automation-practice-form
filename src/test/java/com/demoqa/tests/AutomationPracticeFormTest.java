package com.demoqa.tests;

import com.github.javafaker.Faker;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static java.lang.String.format;

public class AutomationPracticeFormTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = "Female",
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = faker.number().numberBetween(1, 30) + "",
            month = "May",
            year = faker.number().numberBetween(1940, 2010) + "",
            userSubjects = "Chemistry",
            userHobbies = "Music",
            fileName = "1.png",
            userAddress = faker.address().cityName(),
            userState = "NCR",
            userCity = "Noida";

    @Test
    void fillPracticeFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .uploadFile(fileName)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", format("%s %s", firstName, lastName))
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", format("%s %s,%s", day, month, year))
                .checkResult("Subjects", userSubjects)
                .checkResult("Hobbies", userHobbies)
                .checkResult("Picture", fileName)
                .checkResult("Address", userAddress)
                .checkResult("State and City", format("%s %s", userState, userCity));
    }
}

