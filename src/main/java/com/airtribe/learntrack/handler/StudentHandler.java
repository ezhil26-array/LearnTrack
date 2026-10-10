package com.airtribe.learntrack.handler;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.StudentNotFoundException;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.Utility;
import com.airtribe.learntrack.util.Validator;

import java.util.List;
import java.util.Scanner;

public class StudentHandler {

    public static void studentManagement() throws InterruptedException {
        do{
            System.out.print("Loading Student Management System ");
            Utility.loading();
            System.out.println("Please enter 1 to list students.");
            System.out.println("Please enter 2 to add a student.");
            System.out.println("Please enter 3 to remove a student.");
            System.out.println("Please enter 4 to update student.");
            System.out.println("Please enter 0 to go to main menu.");
            System.out.print("Please entire your option : ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(input.equals("0")){
                break;
            }
            if(input.equals("1")){
                listStudents();
            }
            if(input.equals("2")){
                addStudent();
            }
            if(input.equals("3")){
                removeStudent();
            }
            if(input.equals("4")){
                updateStudent();
            }
        }while(true);
    }

    private static void addStudent() {
        System.out.println("Please enter the details of the student you want to add.");
        Student student = null;
        student = getStudentData();

        long nextStudentId = IdGenerator.getNextStudentId();
        student.setId(nextStudentId);
        StudentService.addStudent(student);
        System.out.println(student);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.println("Please enter the student id you want to delete.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String message = StudentService.removeStudent(Long.parseLong(input));
        System.out.println(message);
    }

    private static void updateStudent() {
        System.out.println("Please enter the student id you want to update.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Student studentCurr = null;
        try {
            studentCurr = StudentService.getStudent(Long.parseLong(input));
            System.out.println("Please enter the details of the student you want to add.");
            Student student = getStudentData();
            student.setId(studentCurr.getId());
            StudentService.updateStudent(student);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void listStudents() {
        List<Student> list = StudentService.getList();
        if (list.isEmpty()){
            System.out.println("No students found.");
        }
        list.forEach(System.out::println);
    }


    private static Student getStudentData() {
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
        do{
            System.out.println("Please verify the details of the student you want to add.");
            System.out.println(student);
            System.out.println("Please N if you want to discard and re-enter.");
            String input = scanner.nextLine();
            if (("N").equalsIgnoreCase(input)) {
                student = null;
                continue;
            }
            break;
        } while(true);
        return student;
    }
}
