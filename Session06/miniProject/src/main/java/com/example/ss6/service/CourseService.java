package com.example.ss6.service;

import com.example.ss6.model.Course;
import com.example.ss6.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseByCode(String code) {
        return courseRepository.findByCode(code);
    }

    public List<Course> filterCourses(String level, Double maxPrice) {
        return courseRepository.filterCourses(level, maxPrice);
    }

    public void updateCourse(Course course) {
        courseRepository.updateCourse(course);
    }

    public boolean deleteCourse(int id) {
        return courseRepository.deleteCourse(id);
    }
}
