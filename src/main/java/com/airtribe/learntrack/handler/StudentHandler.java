package com.airtribe.learntrack.handler;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.StudentNotFoundException;
import com.airtribe.learntrack.service.LearnTrackService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.Utility;
import com.airtribe.learntrack.util.Validator;

import java.util.List;
import java.util.Scanner;

import static com.airtribe.learntrack.util.Utility.getId;

public class StudentHandler extends Handler<Student> {

    private final StudentService studentService;

    public StudentHandler(LearnTrackService<Student> studentService) {
        this.studentService = (StudentService) studentService;
    }

    public void start() {
        System.out.print("Loading Student Management Module ");
        Utility.loading();
        super.start();
    }

    public void add() {
        System.out.println("Please enter the details of the student you want to add.");
        Student student = null;
        student = getData();

        long nextStudentId = IdGenerator.getNextStudentId();
        student.setId(nextStudentId);
        studentService.add(student);
        System.out.println(student);
        System.out.println("Student "+student.getDisplayName() + " added successfully.");
    }

    public void remove() {
        System.out.println("Please enter the student id you want to delete.");
        long id = getId();
        String message = studentService.remove(new  Student(id));
        System.out.println(message);
    }

    public void update() {
        System.out.println("Please enter the student id you want to update.");
        long id = getId();
        Student studentCurr = null;
        try {
            studentCurr = studentService.get(getDummy(id));
            System.out.println("Please enter the details of the student you want to add.");
            Student student = getData();
            student.setId(studentCurr.getId());
            studentService.update(student);
            System.out.println("Student updated successfully.");
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private Student getDummy(long id) {
        return new Student(id);
    }

    public void list() {
        List<Student> list = studentService.getList(null);
        if (list.isEmpty()){
            System.out.println("No students found.");
        }
        list.forEach(System.out::println);
    }

    public Student getData() {
        Student  student = null;
        String firstName = null;
        String lastName =  null;
        String batch = null;
        String email = null;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Please enter the first name : ");
            firstName = scanner.nextLine();
            if (Validator.validateString(firstName)) {
                break;
            }
        } while(true);

        do {
            System.out.print("Please enter the last name : ");
            lastName = scanner.nextLine();
            if (Validator.validateString(lastName)) {
                break;
            }
        } while(true);

        do {
            System.out.print("Please enter the email address : ");
            email = scanner.nextLine();
            if (Validator.validateEmail(email)) {
                break;
            }
        } while(true);

        do {
            System.out.print("Please enter the batch : ");
            batch = scanner.nextLine();
            if (Validator.validateString(batch)) {
                break;
            }
        } while(true);
        student = new Student(firstName, lastName, email, batch, true);
//        do{
//            System.out.println("Please verify the details of the student you want to add.");
//            System.out.println(student);
//            System.out.println("Please N if you want to discard and re-enter.");
//            String input = scanner.nextLine();
//            if (("N").equalsIgnoreCase(input)) {
//                student = null;
//                continue;
//            }
//            break;
//        } while(true);
        return student;
    }
}
