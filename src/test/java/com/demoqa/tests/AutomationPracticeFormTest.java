package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "400x1028";
    }

    @Test
    void fillPracticeFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Xenia")
                .setLastName("Iva")
                .setEmail("xiva@gmail.com")
                .setGender("Female")
                .setNumber("1234567890")
                .setBirthDate("15", "May", "1999")
                .setSubjects("Chemistry")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .uploadFile("1.png")
                .setAddress("Moscow")
                .setState("NCR")
                .setCity("Noida")
                .submit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Xenia Iva")
                .checkResult("Student Email", "xiva@gmail.com")
                .checkResult("Gender","Female")
                .checkResult("Mobile","1234567890")
                .checkResult("Date of Birth", "15 May,1999")
                .checkResult("Subjects","Chemistry")
                .checkResult("Hobbies","Sports, Reading")
                .checkResult("Picture","1.png")
                .checkResult("Address","Moscow")
                .checkResult("State and City","NCR Noida");
    }
}

