package org.homework.student_management_system.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String id) {
        super("student could not found with Id: " + id);
    }
}
