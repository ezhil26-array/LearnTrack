package com.airtribe.learntrack;

import com.airtribe.learntrack.component.LearnTrackComponent;
import com.airtribe.learntrack.handler.CourseHandler;
import com.airtribe.learntrack.handler.EnrollmentHandler;
import com.airtribe.learntrack.handler.Handler;
import com.airtribe.learntrack.handler.StudentHandler;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class  Main {
    /**
     * This class is the entry point for the LearnTrack Application.
     * Lists out all management options.
     * Dispatches to the right management of corresponding input.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Welcome to LearnTrack Management System");
        // Init Component
        LearnTrackComponent learnTrackComponent = LearnTrackComponent.getInstance();
        // Init Services
        StudentService studentService = new StudentService(learnTrackComponent);
        CourseService courseService = new CourseService(learnTrackComponent);
        EnrollmentService enrollmentService = new EnrollmentService(learnTrackComponent);
        // Init Handlers
        StudentHandler studentHandler = new StudentHandler(studentService);
        CourseHandler courseHandler = new CourseHandler(courseService);
        EnrollmentHandler enrollmentHandler = new EnrollmentHandler(enrollmentService, courseService, studentService);
        do{
            System.out.println("Press 1 for Student Management.");
            System.out.println("Press 2 for Course Management.");
            System.out.println("Press 3 for Enrollment service.");
            System.out.println("Press 0 to exit.");
            System.out.print("Please entire your option : ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            Handler handler = null;

            if(input.equals("0")){
                break;
            }
            if(input.equals("1")){
                handler = studentHandler;
            }
            if(input.equals("2")){
                handler = courseHandler;
            }
            if(input.equals("3")){
                handler = enrollmentHandler;
            }
            if (handler != null) {
                handler.start();
            }
        } while(true);

    }
}