package com.example.PersonInformation.Entities;

public class ErrorHandling {
    public String summary;
    public String detail;

    public ErrorHandling(String summary, String detail) {
        this.summary = summary;
        this.detail = detail;
    }

    public ErrorHandling(String detail) {
        this.summary = "Error Occurred";
        this.detail = detail;
    }
}
