package com.airtribe.learntrack.handler;

import com.airtribe.learntrack.entity.Course;

import java.util.Scanner;

public abstract class Handler<T> {

    public void start() {
        do{
            System.out.println("Please enter 1 to list.");
            System.out.println("Please enter 2 to add.");
            System.out.println("Please enter 3 to update.");
            System.out.println("Please enter 4 to remove.");
            System.out.println("Please enter 0 to go to main menu.");
            System.out.print("Please entire your option : ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(input.equals("0")){
                break;
            }
            if(input.equals("1")){
                list();
            }
            if(input.equals("2")){
                add();
            }
            if(input.equals("3")){
                update();
            }
            if(input.equals("4")){
                remove();
            }
            System.out.print("please any key to display menu");
            scanner.nextLine();
        }while(true);
    }

    public abstract void list() ;

    public abstract void add();

    public abstract void update();

    public abstract void remove();

    public abstract T getData();
}
