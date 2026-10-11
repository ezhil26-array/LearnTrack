package com.airtribe.learntrack.handler;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.CourseNotFoundException;
import com.airtribe.learntrack.exception.StudentNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.LearnTrackService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.Utility;
import com.airtribe.learntrack.util.Validator;

import java.util.Scanner;
import static com.airtribe.learntrack.util.Utility .getId;

public class CourseHandler extends Handler<Course>{

    private final CourseService courseService;

    public CourseHandler(LearnTrackService<Course> courseService) {
        this.courseService = (CourseService) courseService;
    }

    public void start() {
        System.out.print("Loading Course Management Module ");
        Utility.loading();
        super.start();
    }

    public void list() {
        courseService.getList(null).forEach(System.out::println);
    }

    public void update() {
        System.out.println("Please enter the course id you want to update:");
        long id = getId();
        try {
            Course currCourse = courseService.get(id);
            System.out.println("Please enter the details of the course you want to update.");
            Course course = getData();
            course.setId(currCourse.getId());
            String message = courseService.update(course);
            System.out.println(message);
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove() {
        System.out.println("Please enter the course id you want to delete:");
        long id = Utility.getId();
        String message = "";
        try {
            Course course = courseService.get(id);
            message = courseService.remove(course);
        } catch (CourseNotFoundException e) {
            message = "Course not found.";
        }
        System.out.println(message);
    }

    public void add() {
        System.out.println("Please enter the details of the course you want to add.");
        Course course = null;
        course = getData();
        boolean addCourse = false;
        try {
            Course existing = courseService.get(course);
            if (existing != null){
                System.out.println("Course already exists.");
                System.out.println(existing);
            }
        } catch (CourseNotFoundException e) {
            //throw new RuntimeException(e);
            addCourse = true;
        }
        if(addCourse) {
            long nextCourseId = IdGenerator.getNextCourseId();
            course.setId(nextCourseId);
            courseService.add(course);
            System.out.println(course);
            System.out.println("Course added successfully.");
        }
    }


    public Course getData() {
        Course  course = null;
        String courseName = null;
        String description =  null;
        String strDurationInWeeks = null;
        Integer durationInWeeks = 0;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Please enter the course name : ");
            courseName = scanner.nextLine();
            if (Validator.validateString(courseName)) {
                break;
            }
        } while(true);

        do {
            System.out.print("Please enter the description : ");
            description = scanner.nextLine();
            if (Validator.validateString(description)) {
                break;
            }
        } while(true);

        do {
            System.out.print("Please enter the durationInWeeks : ");
            strDurationInWeeks = scanner.nextLine();
            if (Validator.validateNumber(strDurationInWeeks)) {
                durationInWeeks = Integer.parseInt(strDurationInWeeks);
                break;
            }

        } while(true);

        course = new Course(courseName, description, durationInWeeks, true);
        do{
            System.out.println("Please verify the details of the course you want to add.");
            System.out.println(course);
            System.out.println("Please enter 'N' if you want to discard and re-enter.");
            String input = scanner.nextLine();
            if (("N").equalsIgnoreCase(input)) {
                course = null;
                continue;
            }
            break;
        } while(true);
        return course;
    }
}


