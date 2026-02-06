package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.*;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.*;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LEARNTRACK =====");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management.");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            String input = sc.next();
            try {
                int mainChoice = InputValidator.parseIntSafe(input);

                switch (mainChoice) {

                    // ---------------- STUDENT ----------------
                    case 1:
                        System.out.println("\n1. Add Student");
                        System.out.println("2. View Students");
                        System.out.println("3. Deactivate Student");
                        System.out.print("Enter choice: ");

                        int sChoice = InputValidator.parseIntSafe(sc.next());

                        if (sChoice == 1) {
                            System.out.print("First Name: ");
                            String fn = sc.next();
                            System.out.print("Last Name: ");
                            String ln = sc.next();
                            System.out.print("Batch: ");
                            String batch = sc.next();

                            Student s = new Student(
                                    IdGenerator.getNextStudentId(),
                                    fn, ln, batch
                            );
                            studentService.addStudent(s);
                            System.out.println("Student added successfully!");

                        } else if (sChoice == 2) {
                            for (Student st : studentService.listStudents()) {
                                System.out.println(st.getId() + " - " + st.getDisplayName());
                            }

                        } else if (sChoice == 3) {
                            System.out.print("Enter Student ID: ");
                            int id = InputValidator.parseIntSafe(sc.next());
                            studentService.deactivate(id);
                            System.out.println("Student deactivated!");

                        } else {
                            System.out.println("Invalid student option!");
                        }
                        break;

                    // ---------------- COURSE ----------------
                    case 2:
                        System.out.println("\n1. Add Course");
                        System.out.println("2. View Courses");
                        System.out.print("Enter choice: ");

                        int cChoice = InputValidator.parseIntSafe(sc.next());

                        if (cChoice == 1) {
                            System.out.print("Course Name: ");
                            String name = sc.next();
                            System.out.print("Description: ");
                            String desc = sc.next();
                            System.out.print("Duration (weeks): ");
                            int dur = InputValidator.parseIntSafe(sc.next());

                            Course c = new Course(
                                    IdGenerator.getNextCourseId(),
                                    name, desc, dur
                            );
                            courseService.addCourse(c);
                            System.out.println("Course added!");

                        } else if (cChoice == 2) {
                            for (Course c : courseService.listCourses()) {
                                System.out.println(c.getId() + " - " + c.getCourseName()+" - "+ c.getDurations()+"-"+ c.getDescription());
                            }


                        } else {
                            System.out.println("Invalid course option!");
                        }
                        break;

                    // ---------------- ENROLLMENT ----------------
                    case 3:
                        System.out.println("\n1. Enroll Student");
                        System.out.println("2. View Student Enrollments");
                        System.out.println("3. Update Enrollment Status");
                        System.out.print("Enter choice: ");

                        int eChoice = InputValidator.parseIntSafe(sc.next());

                        if (eChoice == 1) {
                            System.out.print("Student ID: ");
                            int sid = InputValidator.parseIntSafe(sc.next());
                            System.out.print("Course ID: ");
                            int cid = InputValidator.parseIntSafe(sc.next());

                            Enrollment e = new Enrollment(
                                    IdGenerator.getNextEnrollmentId(),
                                    sid, cid
                            );
                            enrollmentService.enrollStudent(e);
                            System.out.println("Enrollment successful!");

                        } else if (eChoice == 2) {
                            System.out.print("Student ID: ");
                            int sid = InputValidator.parseIntSafe(sc.next());

                            for (Enrollment e : enrollmentService.getEnrollmentsByStudent(sid)) {
                                System.out.println("Course ID: " + e.getCourseId()
                                        + " | Status: " + e.getStatus());
                            }


                        } else if (eChoice == 3) {
                            System.out.print("Enrollment ID: ");
                            int eid = InputValidator.parseIntSafe(sc.next());
                            System.out.print("New Status: ");
                            String status = sc.next();

                            enrollmentService.updateStatus(eid, status);
                            System.out.println("Enrollment updated!");

                        } else {
                            System.out.println("Invalid enrollment option!");
                        }
                        break;

                    case 4:
                        System.out.println("Thank you for using LearnTrack!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid main menu choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
