package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();
    public void addStudent(Student s) {
        students.add(s);
    }

    public ArrayList<Student> listStudents() {
        return students;
    }

    public Student findById(int id) throws EntityNotFoundException {
        for (Student s : students) {
            if (s.getId() == id)
                return s;
        }
        throw new EntityNotFoundException("Student not found!");
    }

    public void deactivate(int id) throws EntityNotFoundException {
        Student s = findById(id);
        s.setActive(false);
    }
}
