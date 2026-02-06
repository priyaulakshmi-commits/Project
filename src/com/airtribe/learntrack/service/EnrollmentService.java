package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;

public class EnrollmentService {

    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public void enrollStudent(Enrollment e) {
        enrollments.add(e);
    }

    public ArrayList<Enrollment> getAllEnrollments() {
        return enrollments;
    }

    public ArrayList<Enrollment> getEnrollmentsByStudent(int studentId) {
        ArrayList<Enrollment> result = new ArrayList<>();

        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }
        return result;
    }

    public Enrollment findById(int id) throws EntityNotFoundException {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EntityNotFoundException("Enrollment not found!");
    }

    public void updateStatus(int enrollmentId, String status)
            throws EntityNotFoundException {
        Enrollment e = findById(enrollmentId);
        e.setStatus(status);
    }

}
