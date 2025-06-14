package org.homework.student_management_system.config;

import org.homework.student_management_system.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class InMemoryDatabase {

    @Bean
    public List<Student> studentList() {
        return Arrays.asList(
                new Student(1L, "Dilireba", "Female", 85.5),
                new Student(2L, "Zhao Lu Si", "Female", 92.0),
                new Student(3L, "Bai Lu", "Female", 78.3),
                new Student(4L, "Esther Yu", "Female", 88.7),
                new Student(5L, "Zhou Dong Yu", "Female", 76.2),
                new Student(6L, "Yang Mi", "Female", 95.0),
                new Student(7L, "Dylan Wang", "Male", 81.4),
                new Student(8L, "Ren Jialun", "Male", 89.6),
                new Student(9L, "Hou Minghao", "Male", 72.8),
                new Student(10L, "Chen ZheYuan", "Male", 84.1)
        );
    }
}