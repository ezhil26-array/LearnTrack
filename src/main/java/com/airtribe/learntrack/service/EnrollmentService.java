package com.airtribe.learntrack.service;

import com.airtribe.learntrack.component.LearnTrackComponent;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EnrollmentNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class EnrollmentService implements LearnTrackService<Enrollment>{

    private final LearnTrackComponent learnTrackComponent;

    public EnrollmentService(LearnTrackComponent learnTrackComponent) {
        this.learnTrackComponent = learnTrackComponent;
    }

    public List<Enrollment> getEnrollments() {
        return learnTrackComponent.getEnrollments();
    }

    public List<Enrollment> getList(Enrollment enrollment) {
        List<Enrollment> filteredEnrollments = getEnrollments();
        List<Enrollment> studentEnrollments = new ArrayList<>();
        if (enrollment.getStudentId() != 0) {
            studentEnrollments =  getEnrollments().stream()
                    .filter(e -> e.getStudentId() == enrollment.getStudentId()).toList();
            return (studentEnrollments);
        }
//
//        if (!studentEnrollments.isEmpty() && enrollment.getCourseId() != 0) {
//            List<Enrollment> studentCourseEnrollments =
//                    studentEnrollments.stream()
//                            .filter(e -> e.getCourseId() == enrollment.getCourseId()).toList();
//            filteredEnrollments.clear();
//            filteredEnrollments.addAll(studentCourseEnrollments);
//        }
        return filteredEnrollments;
    }

    @Override
    public Enrollment get(Enrollment enrollment) throws EnrollmentNotFoundException {
        List<Enrollment> filteredList = null;
        if (enrollment.getId() != 0) {
            filteredList = getEnrollments().stream()
                    .filter(e -> e.getId() == enrollment.getId()).toList();
            if (filteredList.isEmpty())  {
                throw new EnrollmentNotFoundException("No enrollment found with id "+enrollment.getId());
            }
            return filteredList.get(0);
        }

        return null;
    }

    @Override
    public Enrollment get(long id) throws EnrollmentNotFoundException {
        return get(new Enrollment(id));
    }

    @Override
    public String add(Enrollment enrollment) {
        learnTrackComponent.update(enrollment);
        return "Enrollment added successfully.";
    }

    @Override
    public String remove(Enrollment enrollment) {
        learnTrackComponent.update(enrollment);
        return "Enrollment removed.";
    }

    @Override
    public String update(Enrollment enrollment) {
        learnTrackComponent.update(enrollment);
        return "Enrollment updated.";
    }
}
