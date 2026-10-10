package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Student;

import java.util.Scanner;

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
                //courseManagement();
            }
            if(input.equals("3")){
                //enrollment();
            }
        } while(true);

    }

    private static void studentManagement() throws InterruptedException {
        do{
            System.out.print("Loading Student Management System ");
            loading();
            System.out.println("Please enter 1 to list students.");
            System.out.println("Please enter 2 to add a student.");
            System.out.println("Please enter 3 to remove a student.");
            System.out.println("Please enter 4 to update student.");
            System.out.println("Press 0 to go to main menu.");
            System.out.print("Please entire your option : ");
            Scanner scanner = new Scanner(System.in);
            if(scanner.next().equals("0")){
                break;
            }
            if(scanner.next().equals("1")){

            }
            if(scanner.next().equals("2")){
                addStudent();
            }
        }while(true);
    }

    private static void addStudent() {
        System.out.println("Please enter the details of the student you want to add.");
        System.out.print("Please enter the first name : ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.print("Please enter the last name : ");
        scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();
        System.out.print("Please enter the email address : ");
        String email = scanner.nextLine();
        System.out.print("Please enter the batch : ");
        String batch = scanner.nextLine();
        System.out.print("Please enter the status - Y for Active & N for Inactive.: ");
        String statusStr = scanner.nextLine();
        boolean status = false;
        if ("Y".equalsIgnoreCase(statusStr)) {
            status = true;
        }
        Student student = new Student(firstName, lastName, email, batch, status);
    }

    private static void loading() throws InterruptedException {
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println();
    }
}