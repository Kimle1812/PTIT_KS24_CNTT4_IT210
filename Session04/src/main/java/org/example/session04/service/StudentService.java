package org.example.session04.service;

import org.example.session04.dao.StudentDao;
import org.example.session04.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;
    public List<Student> getAllStudent(){
        List<Student> students = studentDao.findAll();
        return students;
    }
}
