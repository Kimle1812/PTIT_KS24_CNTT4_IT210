package org.example;

public class Person {
    private int id;
    private String name;
    private String major;

    public Person() {
    }

    public Person(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}