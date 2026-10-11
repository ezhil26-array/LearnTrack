package com.airtribe.learntrack.service;

import com.airtribe.learntrack.component.LearnTrackComponent;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StudentService implements LearnTrackService<Student> {

    private final LearnTrackComponent learnTrackComponent;

    public StudentService(LearnTrackComponent learnTrackComponent) {
        this.learnTrackComponent = learnTrackComponent;
    }

    public List<Student> getStudents() {
        return learnTrackComponent.getStudents();
    }

    public String add(Student student) {
        learnTrackComponent.update(student);
        return "Student added successfully.";
    }

    public Student get(Student student) throws StudentNotFoundException {
        Student existingStudent = getStudents().stream()
                .filter(Student::isActive)
                .filter(s -> s.getId() == student.getId()).findFirst().orElse(null);
        if (existingStudent == null) {
            throw new StudentNotFoundException();
        }
        return existingStudent;
    }

    @Override
    public Student get(long id) throws Exception {
        return get(new Student(id));
    }

    public String update(Student student) {
        learnTrackComponent.update(student);
        return "Student updated.";
    }

    public List<Student> getList(Student student) {
        List<Student> activeStudents = getStudents().stream().filter(Student::isActive).toList();
        return Collections.unmodifiableList(activeStudents);
    }

    public String remove(Student student) {
        String message = "";
        try {
            student = get(student);
            student.setActive(false);
            message = "Student "+student.getDisplayName() + " removed successfully.";
        } catch (StudentNotFoundException e) {
            message = "Student not found.";
        }
        return message;
    }
}
