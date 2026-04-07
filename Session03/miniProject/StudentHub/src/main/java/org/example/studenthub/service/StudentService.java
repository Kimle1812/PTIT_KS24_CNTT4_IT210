package org.example.studenthub.service;

import org.example.studenthub.models.Student;
import org.example.studenthub.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // UC-01 & UC-03: Lấy danh sách, Lọc và Sắp xếp
    public List<Student> getFilteredAndSortedStudents(String search, String faculty, String sortBy) {
        List<Student> list = repository.findAll();

        // 1. Lọc (Filter)
        if (search != null && !search.trim().isEmpty()) {
            list = list.stream()
                    .filter(s -> s.getFullName().toLowerCase().contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (faculty != null && !faculty.trim().isEmpty()) {
            list = list.stream()
                    .filter(s -> s.getFaculty().equalsIgnoreCase(faculty))
                    .collect(Collectors.toList());
        }

        // 2. Sắp xếp (Sort)
        if ("name".equals(sortBy)) {
            list.sort(Comparator.comparing(Student::getFullName));
        } else if ("gpa".equals(sortBy)) {
            list.sort(Comparator.comparing(Student::getGpa).reversed()); // GPA giảm dần
        }

        return list;
    }

    // UC-02: Lấy chi tiết
    public Student getStudentById(int id) {
        return repository.findById(id);
    }

    // UC-04: Các hàm thống kê Dashboard
    public int getTotalStudents() {
        return repository.findAll().size();
    }

    public double getAverageGpa() {
        return repository.findAll().stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }

    public Student getTopStudent() {
        return repository.findAll().stream()
                .max(Comparator.comparing(Student::getGpa))
                .orElse(null);
    }

    public Map<String, Double> getStatusPercentages() {
        List<Student> all = repository.findAll();
        if (all.isEmpty()) return new HashMap<>();

        Map<String, Long> counts = all.stream()
                .collect(Collectors.groupingBy(Student::getStatus, Collectors.counting()));

        Map<String, Double> percentages = new HashMap<>();
        for (Map.Entry<String, Long> entry : counts.entrySet()) {
            double percent = (entry.getValue() * 100.0) / all.size();
            percentages.put(entry.getKey(), Math.round(percent * 100.0) / 100.0); // Làm tròn 2 chữ số
        }
        return percentages;
    }
}