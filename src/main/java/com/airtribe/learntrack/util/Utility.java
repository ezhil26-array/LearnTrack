package com.airtribe.learntrack.util;

import java.util.Scanner;

public class Utility {

    public static void loading() {
        try {
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println();
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
        }

    }

    public static long getId() {
        long id;
        do {
            Scanner scanner = new Scanner(System.in);
            String strId = scanner.nextLine();
            if (Validator.validateNumber(strId)) {
                id = Long.parseLong(strId);
                break;
            }
            System.out.println("Please enter a valid id.");
        } while(true);
        return id;
    }
}
