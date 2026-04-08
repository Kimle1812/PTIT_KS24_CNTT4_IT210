package org.example.session04.model;

public class Student {

    private int id;
    private String fullName;
    private int age;
    private boolean gender;

    public Student() {
    }

    public Student(int id, String fullName, int age, boolean gender) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public boolean isGender() {
        return gender;
    }
}
