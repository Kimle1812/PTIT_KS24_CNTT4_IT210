package com.example.ss6.repository;

import com.example.ss6.model.Course;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        // Mock Data
        courses.add(new Course(1, "IELTS Foundation", "IELTS-F", "Beginner", 3500000, "Lộ trình học IELTS cơ bản cho người mới bắt đầu.", "Mr. Alex", "2 tháng", false, 5, LocalDate.of(2024, 7, 15)));
        courses.add(new Course(2, "IELTS 6.5 Target", "IELTS-6.5", "Intermediate", 6000000, "Khóa học nâng cao band điểm IELTS lên 6.5.", "Ms. Emily", "3 tháng", false, 12, LocalDate.of(2024, 8, 1)));
        courses.add(new Course(3, "Advanced Speaking", "ADV-SPK", "Advanced", 4000000, "Phát triển kỹ năng nói chuyên sâu cho IELTS.", "Mr. David", "1.5 tháng", true, 20, LocalDate.of(2024, 7, 20)));
        courses.add(new Course(4, "Grammar for IELTS", "GR-IELTS", "Beginner", 2000000, "Củng cố ngữ pháp cần thiết cho kỳ thi IELTS.", "Ms. Sarah", "1 tháng", false, 8, LocalDate.of(2024, 9, 1)));
        courses.add(new Course(5, "Writing Masterclass", "WRI-MC", "Advanced", 5500000, "Khóa học chuyên sâu về kỹ năng viết IELTS.", "Dr. John", "2.5 tháng", false, 10, LocalDate.of(2024, 8, 10)));
        courses.add(new Course(6, "TOEFL Preparation", "TOEFL-P", "Intermediate", 7000000, "Luyện thi TOEFL iBT toàn diện.", "Mr. Alex", "4 tháng", false, 7, LocalDate.of(2024, 9, 15)));
    }

    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

    public Optional<Course> findByCode(String code) {
        return courses.stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    public List<Course> filterCourses(String level, Double maxPrice) {
        return courses.stream()
                .filter(course -> level == null || level.isEmpty() || course.getLevel().equalsIgnoreCase(level))
                .filter(course -> maxPrice == null || course.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public void updateCourse(Course updatedCourse) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == updatedCourse.getId()) {
                courses.set(i, updatedCourse);
                return;
            }
        }
    }

    public boolean deleteCourse(int id) {
        Optional<Course> courseToDelete = courses.stream().filter(course -> course.getId() == id).findFirst();
        if (courseToDelete.isPresent() && courseToDelete.get().getStudentCount() == 0) {
            return courses.remove(courseToDelete.get());
        }
        return false;
    }
}
