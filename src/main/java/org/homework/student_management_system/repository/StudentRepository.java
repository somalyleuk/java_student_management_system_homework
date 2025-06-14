package org.homework.student_management_system.repository;

import org.homework.student_management_system.exception.InvalidStudentDataException;
import org.homework.student_management_system.exception.StudentNotFoundException;
import org.homework.student_management_system.model.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public StudentRepository(List<Student> initialStudents) {
        students.addAll(initialStudents);
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public Student findById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student create(Student student) {
        validateStudent(student);
        students.add(student);
        return student;
    }

    public Student update(String id, Student student) {
        validateStudent(student);
        Student existing = findById(id);
        existing.setFullName(student.getFullName());
        existing.setGender(student.getGender());
        existing.setScore(student.getScore());
        return existing;
    }

    public void deleteById(String id) {
        Student student = findById(id);
        students.remove(student);
    }

    private void validateStudent(Student student) {
        if (student.getId() == null ) {
            throw new InvalidStudentDataException("Student ID cannot be null or empty");
        }
        if (student.getFullName() == null || student.getFullName().isEmpty()) {
            throw new InvalidStudentDataException("Student name cannot be null or empty");
        }
        if (student.getScore() < 0 || student.getScore() > 100) {
            throw new InvalidStudentDataException("Score must be between 0 and 100");
        }
    }
}
