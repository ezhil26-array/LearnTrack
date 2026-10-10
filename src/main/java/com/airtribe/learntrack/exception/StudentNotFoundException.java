package com.airtribe.learntrack.exception;

public class StudentNotFoundException extends Exception {

    public StudentNotFoundException() {
        super("Student Not Found");
    }

    @Override
    public String getMessage() {
        return "Student Not Found";
    }
}
