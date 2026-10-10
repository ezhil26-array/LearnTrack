package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentService {

    private static List<Student> students =  new ArrayList<Student>();

    public static void addStudent(Student student) {
        students.add(student);
    }
    public static Student getStudent(long id) throws StudentNotFoundException {
        Student student = students.stream().filter(Student::isActive).filter(s -> s.getId() == id).findFirst().orElse(null);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        return student;
    }

    public static void updateStudent(Student student) {
        students.remove(student);
        students.add(student);
    }

    public static List<Student> getList() {
        List<Student> activeStudents = students.stream().filter(Student::isActive).toList();
        return Collections.unmodifiableList(activeStudents);
    }

    public static String removeStudent(long id) {
        Student student = null;
        String message = "";
        try {
            student = getStudent(id);
            student.setActive(false);
            message = student.getDisplayName() + " removed successfully.";
        } catch (StudentNotFoundException e) {
            message = "Student not found.";
        }
        return message;
    }
}
