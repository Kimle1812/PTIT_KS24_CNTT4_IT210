package org.example.studenthub.repository;

import org.example.studenthub.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private final List<Student> students;
    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student(1, "Nguyễn Văn An", "SV001", "CNTT", 2022, 3.8, "Đang học"));
        students.add(new Student(2, "Trần Thị Bình", "SV002", "Kinh tế", 2021, 3.5, "Tốt nghiệp"));
        students.add(new Student(3, "Lê Cường Nguyen", "SV003", "CNTT", 2023, 2.9, "Đang học"));
        students.add(new Student(4, "Phạm Dung", "SV004", "Ngoại ngữ", 2022, 3.1, "Bảo lưu"));
        students.add(new Student(5, "Hoàng Ewan", "SV005", "CNTT", 2020, 3.9, "Tốt nghiệp"));
    }
    public List<Student> findAll() {
        return new ArrayList<>(students); // Trả về bản sao để tránh bị sửa đổi trực tiếp
    }
    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
