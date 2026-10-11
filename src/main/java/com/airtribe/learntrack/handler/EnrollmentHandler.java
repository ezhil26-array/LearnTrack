package com.airtribe.learntrack.handler;

import com.airtribe.learntrack.constants.EnrollmentStatus;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EnrollmentNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.Utility;

import java.util.List;
import java.util.Scanner;

import static com.airtribe.learntrack.util.Utility.getId;

public class EnrollmentHandler extends Handler<Enrollment> {

    private final EnrollmentService enrollmentService;

    private final CourseService courseService;

    private final StudentService studentService;

    public EnrollmentHandler(EnrollmentService enrollmentService,
                             CourseService courseService,
                             StudentService studentService) {
        this.enrollmentService = enrollmentService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public void start() {
        System.out.print("Loading Enrollment Management Module ");
        Utility.loading();
        super.start();
    }

    public void list() {
        Enrollment reqEnrollment = new Enrollment(0,0);
        System.out.print("Please enter student id or 0: ");
        long studentId = Utility.getId();
        reqEnrollment.setStudentId(studentId);
        List<Enrollment> enrollments = enrollmentService.getList(reqEnrollment);
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found");
        } else {
            System.out.println("Found " + enrollments.size() + " enrollments.");
        }
        for (Enrollment enrollment : enrollments) {
            String studentName = "";
            String courseName = "";
            try {
                studentName = studentService.get(enrollment.getStudentId()).getDisplayName();
                courseName = courseService.get(enrollment.getCourseId()).getCourseName();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(enrollment.getId() + " " + studentName
                    + " " + courseName+ " " + enrollment.getEnrollmentDate() + " " + enrollment.getStatus());
        }
        //enrollments.forEach(System.out::println);
    }


    public void add() {
        System.out.println("Please enter the details of the Enrollment you want to add.");
        Enrollment enrollment = null;
        enrollment = getData();
        List<Enrollment> list = enrollmentService.getList(enrollment);
        if (list.isEmpty()) {
            long nextStudentId = IdGenerator.getNextEnrollmentId();
            enrollment.setId(nextStudentId);
            enrollmentService.add(enrollment);
            System.out.println(enrollment);
            System.out.println("enrollment added successfully.");
        } else {
            System.out.println("enrollment already exists.");
            System.out.println(list.get(0));
        }
    }


    public void update() {
        System.out.println("Please enter the enrollment id you want to update:");
        long id = getId();
        try {
            Enrollment enrollment = enrollmentService.get(id);
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Please enter enrollment new status (ACTIVE/COMPLETED/CANCELLED) : ");
                String status = scanner.nextLine();
                EnrollmentStatus enrollmentStatus = EnrollmentStatus.valueOf(status);
                if (enrollmentStatus != null) {
                    enrollment.setStatus(enrollmentStatus);
                    break;
                } else {
                    System.out.println("Invalid enrollment status.");
                }
            } while(true);
            Enrollment newEnrollment = getData();
            newEnrollment.setId(id);
            newEnrollment.setStatus(enrollment.getStatus());
            String message = enrollmentService.update(enrollment);
            System.out.println(enrollment);
            System.out.println(message);
        } catch (EnrollmentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public void remove() {
        System.out.println("Please enter the enrollment id you want to update:");
        long id = getId();
        try {
            Enrollment enrollment = enrollmentService.get(id);
            enrollmentService.remove(enrollment);
        }  catch (EnrollmentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Enrollment getData() {
        long  studentId = 0;
        long  courseId = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the student id : ");
        studentId = Utility.getId();

        System.out.print("Please enter the course id : ");
        courseId = Utility.getId();

        return new Enrollment(studentId, courseId, EnrollmentStatus.ACTIVE);
    }
}
