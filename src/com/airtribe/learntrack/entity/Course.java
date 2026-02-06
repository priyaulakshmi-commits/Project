package com.airtribe.learntrack.entity;

public class Course {

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public Course(int id, String name, String desc, int duration) {
        this.id = id;
        this.courseName = name;
        this.description = desc;
        this.durationInWeeks = duration;
        this.active = true;
    }
    // getters & setters
    // public int getId() { return id; }
    public String getDescription() { return description; }
    public int getDurations() { return durationInWeeks; }
    public String getCourseName() { return courseName; }
    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }
}
