package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "400x1028";
    }

    @Test
    void fillPracticeFormTests() {
        open("/automation-practice-form");

        $("#firstName").setValue("Xenia");
        $("#lastName").setValue("Iva");
        $("#userEmail").setValue("xiva@gmail.com");
        $("[for = gender-radio-2]").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("[for = hobbies-checkbox-1]").click();
        $("[for = hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.png"));
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Xenia Iva"), text("xiva@gmail.com"), text("Female"),
                text("1234567890"), text("03 May,1999"), text("Chemistry"), text("Sports, Reading"),
                text("1.png"), text("Moscow"), text("NCR Noida"));
    }
}
