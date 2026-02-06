package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course c) {
        courses.add(c);
    }

    public Course findById(int id) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == id)
                return c;
        }
        throw new EntityNotFoundException("Course not found!");
    }

    public ArrayList<Course> listCourses() {
        return courses;
    }

}
