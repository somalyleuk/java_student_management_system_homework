package org.homework.student_management_system.model;

public class Student {
    private Long id;
    private String fullName;
    private String gender;
    private double score;

    public Student() {
    }

    public Student(Long id, String fullName, String gender, double score) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public double getScore() {
        return score;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id = " + id +
                ", fullName ='" + fullName + '\'' +
                ", gender = '" + gender + '\'' +
                ", score = " + score +
                '}';
    }
}
