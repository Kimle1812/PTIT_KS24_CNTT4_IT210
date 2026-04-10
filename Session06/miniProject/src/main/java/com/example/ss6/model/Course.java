package com.example.ss6.model;

import java.time.LocalDate;

public class Course {
    private int id;
    private String name;
    private String code;
    private String level;
    private double price;
    private String description;
    private String instructor;
    private String duration;
    private boolean isFull;
    private int studentCount;
    private LocalDate startDate;

    public Course() {}

    public Course(int id, String name, String code, String level, double price, String description, String instructor, String duration, boolean isFull, int studentCount, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.level = level;
        this.price = price;
        this.description = description;
        this.instructor = instructor;
        this.duration = duration;
        this.isFull = isFull;
        this.studentCount = studentCount;
        this.startDate = startDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public boolean isFull() { return isFull; }
    public void setFull(boolean full) { isFull = full; }
    public int getStudentCount() { return studentCount; }
    public void setStudentCount(int studentCount) { this.studentCount = studentCount; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
}
