package com.example;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class HelloForm {
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
