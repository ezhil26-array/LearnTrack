package com.airtribe.learntrack.component;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LearnTrackComponent {

    private static final List<Course> courses = new ArrayList<Course>();

    private static final List<Enrollment> enrollments = new ArrayList<Enrollment>();

    private static final List<Student> students =  new ArrayList<Student>();

    private static LearnTrackComponent learnTrackComponent;

    private LearnTrackComponent(){

    }

    public static LearnTrackComponent getInstance(){
        if(learnTrackComponent == null) {
            synchronized (LearnTrackComponent.class){
                if(learnTrackComponent == null) {
                    learnTrackComponent = new LearnTrackComponent();
                }
            }
        }

        return learnTrackComponent;
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public List<Enrollment> getEnrollments() {
        return Collections.unmodifiableList(enrollments);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void update(Student student) {
        synchronized (students) {
            int i = students.indexOf(student);
            if (i >= 0) {
                students.set(i, student);
            } else {
                students.add(student);
            }
        }
    }

    public void update(Enrollment enrollment) {
        synchronized (enrollments) {
            int i = enrollments.indexOf(enrollment);
            if (i >= 0) {
                enrollments.set(i, enrollment);
            } else {
                enrollments.add(enrollment);
            }
        }
    }

    public void update(Course course) {
        synchronized (courses) {
            int i = courses.indexOf(course);
            if (i >= 0) {
                courses.set(i, course);
            } else {
                courses.add(course);
            }
        }
    }
}

