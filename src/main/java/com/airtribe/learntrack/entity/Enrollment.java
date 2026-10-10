package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constants.EnrollmentStatus;

import java.util.Date;

public class Enrollment {

    // Fields: id, studentId, courseId, enrollmentDate, status

    private int id;
    private int courseId;
    private int studentId;
    private Date enrollmentDate;
    private EnrollmentStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
}
