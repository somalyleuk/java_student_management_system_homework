package org.homework.student_management_system;

import org.homework.student_management_system.model.Student;
import org.homework.student_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
    private final StudentService studentService;

    @Autowired
    public StudentManagementSystemApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("All Students : ");
        studentService.getAllStudents().forEach(System.out::println);

        System.out.println("\nGet Student By ID :");
        System.out.println(studentService.getStudentById(2L));

        System.out.println("\nCreate New Student:");
        Student newStudent = new Student(null, "New Student", "Male", 90.5);
        Student addedStudent = studentService.createStudent(newStudent);
        System.out.println(addedStudent);

        System.out.println("\nUpdate Student :");
        Student updatedStudent = studentService.updateStudent(3L,
                new Student(null, "Updated Name", "Female", 85.0));
        System.out.println(updatedStudent);

        System.out.println("\nDelete Student :");
        studentService.deleteStudent(5L);
        System.out.println("Student with ID 5 deleted");

        System.out.println("\nAll Students after operations:");
        studentService.getAllStudents().forEach(System.out::println);

        try {
            System.out.println("\nTry to get non-existent student (ID 99):");
            studentService.getStudentById(99L);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

}
