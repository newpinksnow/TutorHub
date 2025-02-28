package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "points")
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private User student;

    @Column(name = "points")
    private Integer points;

    public Points() {}

    public Points(User student, Integer points) {
        this.student = student;
        this.points = points;
    }

    public Integer getStudentId() { return studentId; }
    public User getStudent() { return student; }
    public Integer getPoints() { return points; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public void setStudent(User student) { this.student = student; }
    public void setPoints(Integer points) { this.points = points; }

    @Override
    public String toString() {
        return "Points{" +
                "studentId=" + studentId +
                ", student=" + student +
                ", points=" + points +
                '}';
    }
}
