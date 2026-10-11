package com.airtribe.learntrack.util;

public class IdGenerator {

    private static long uniqueStudentId = 1000;
    private static long uniqueCourseId = 100;
    private static long uniqueEnrollmentId = 10000;

    public synchronized static long getNextStudentId() {
        return uniqueStudentId++;
    }

    public synchronized static long getNextCourseId() {
        return uniqueCourseId++;
    }
    public synchronized static long getNextEnrollmentId() {
        return uniqueEnrollmentId++;
    }
}
