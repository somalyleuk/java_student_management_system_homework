package org.homework.student_management_system.service;

import org.homework.student_management_system.exception.StudentNotFoundException;
import org.homework.student_management_system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentServiceImpl implements StudentService {

    private final List<Student> students;
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public StudentServiceImpl(List<Student> initialStudents) {
        this.students = new CopyOnWriteArrayList<>(initialStudents);
        this.counter.set(initialStudents.stream()
                .mapToLong(Student::getId)
                .max()
                .orElse(0) + 1);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    @Override
    public Student createStudent(Student student) {
        student.setId(counter.getAndIncrement());
        students.add(student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setFullName(student.getFullName());
        existingStudent.setGender(student.getGender());
        existingStudent.setScore(student.getScore());
        return existingStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        students.remove(student);
    }
}
