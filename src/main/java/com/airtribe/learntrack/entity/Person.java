package com.airtribe.learntrack.entity;

public abstract class Person {

    // Fields: id, firstName, lastName, email
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    public Person( String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    abstract String getDisplayName();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
