package com.airtribe.learntrack.entity;

public class Student extends Person{

    // Fields: id, firstName, lastName, email, batch, active (boolean)

    private String batch;
    private boolean active;

    public Student(String firstName, String lastName,  String email, String batch, boolean active) {
        super(firstName,  lastName, email);
        this.batch = batch;
        this.active = active;
    }

    public Student(String firstName, String lastName, String batch, boolean active) {
        super(firstName, lastName);
        this.batch = batch;
        this.active = active;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getDisplayName() {
        return "Student: " + getFirstName() + " " + getLastName();
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return this.getId() == student.getId();
    }

    @Override
    public String toString() {
        return getId() + " " + getFirstName() + " " + getLastName() + " " + getEmail() + " " + getBatch();
    }
}
