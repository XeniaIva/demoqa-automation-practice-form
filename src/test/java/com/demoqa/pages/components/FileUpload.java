package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

public class FileUpload {
    public FileUpload uploadFile(String file, SelenideElement location) {
        location.uploadFromClasspath(file);

        return this;
    }
}
