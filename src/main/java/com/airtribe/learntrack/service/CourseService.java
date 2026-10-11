package com.airtribe.learntrack.service;

import com.airtribe.learntrack.component.LearnTrackComponent;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.CourseNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseService implements LearnTrackService<Course>{

    private final LearnTrackComponent learnTrackComponent;

    public CourseService(LearnTrackComponent learnTrackComponent) {
        this.learnTrackComponent = learnTrackComponent;
    }

    public List<Course> getAllCourses() {
        return learnTrackComponent.getCourses();
    }

    public List<Course> getList(Course course){

        List<Course> activeCourses = getAllCourses().stream().filter(Course::isActive).toList();
        return Collections.unmodifiableList(activeCourses);
    }

    public Course get(Course course) throws CourseNotFoundException {
        List<Course> activeCourses = getList(null);
        Course existingCourse
                = activeCourses.stream()
                .filter(s -> s.getId() == course.getId()).findFirst().orElse(null);
        if (existingCourse == null){
            existingCourse = activeCourses.stream()
                    .filter(c -> c.getCourseName().equalsIgnoreCase(course.getCourseName()))
                    .findFirst().orElse(null);
        }
        if (existingCourse == null){
            throw new CourseNotFoundException();
        }
        return existingCourse;
    }

    @Override
    public Course get(long id) throws CourseNotFoundException {
        return get(new Course(id));
    }

    public String add(Course course){
        learnTrackComponent.update(course);
        return "Course updated successfully.";
    }

    @Override
    public String remove(Course course) {
        learnTrackComponent.update(course);
        return "Course removed successfully.";
    }

    public String update(Course course){
        learnTrackComponent.update(course);
        return "Course updated successfully.";
    }
}
