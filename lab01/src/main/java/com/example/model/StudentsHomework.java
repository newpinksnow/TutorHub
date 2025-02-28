package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students_homework")
public class StudentsHomework {
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @Id
    @ManyToOne
    @JoinColumn(name = "homework_id", nullable = false)
    private Homework homework;

    @Column(name = "score", nullable = false)
    private Integer score;

    public StudentsHomework() {}

    public StudentsHomework(User student, Homework homework, Integer score) {
        this.student = student;
        this.homework = homework;
        this.score = score;
    }

    public User getStudent() { return student; }
    public Homework getHomework() { return homework; }
    public Integer getScore() { return score; }

    public void setStudent(User student) { this.student = student; }
    public void setHomework(Homework homework) { this.homework = homework; }
    public void setScore(Integer score) { this.score = score; }

    @Override
    public String toString() {
        return "StudentsHomework{" +
                "student=" + student +
                ", homework=" + homework +
                ", score=" + score +
                '}';
    }
}
