package org.example.session04.dao;

import org.example.session04.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentDao {
    private  List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Kim Le", 20, true),
                    new Student(2, "Kim Kim", 20, false),
                    new Student(3, "Kim Nguyen", 20, true)
            )
    );
    public List<Student> findAll() {
        return this.students;
    }

}
