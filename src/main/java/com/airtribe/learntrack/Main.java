package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.StudentNotFoundException;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;
import java.util.Scanner;

import static com.airtribe.learntrack.handler.CourseHandler.courseManagement;
import static com.airtribe.learntrack.handler.StudentHandler.studentManagement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Welcome to LearnTrack Management System");
        do{
            System.out.println("Press 1 for Student Management.");
            System.out.println("Press 2 for Course Management.");
            System.out.println("Press 3 for Enrollment service.");
            System.out.println("Press 0 to exit.");
            System.out.print("Please entire your option : ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if(input.equals("0")){
                break;
            }
            if(input.equals("1")){
                studentManagement();
            }
            if(input.equals("2")){
                courseManagement();
            }
            if(input.equals("3")){
                //enrollment();
            }
        } while(true);

    }



}