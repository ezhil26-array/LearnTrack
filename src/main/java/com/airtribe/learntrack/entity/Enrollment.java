package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constants.EnrollmentStatus;

import java.util.Date;

public class Enrollment {

    // Fields: id, studentId, courseId, enrollmentDate, status

    private long id;
    private long courseId;
    private long studentId;
    private Date enrollmentDate;
    private EnrollmentStatus status;

    public Enrollment(long id) {
        this.id = id;
    }
    public Enrollment(long studentId, long courseId, EnrollmentStatus active) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = active;
        this.enrollmentDate = new Date();
    }

    public Enrollment(long studentId, long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
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

    @Override
    public String toString() {
        return this.getId() + " " +this.getCourseId() + " " +this.getStudentId()+ " " +this.getEnrollmentDate() + " " +this.getStatus();
    }
}
