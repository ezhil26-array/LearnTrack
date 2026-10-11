package com.airtribe.learntrack.exception;

public class CourseNotFoundException extends Exception {

    public CourseNotFoundException() {
        super("Course Not Found");
    }

    @Override
    public String getMessage() {
        return "Course Not Found";
    }
}
