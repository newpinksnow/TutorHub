package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students_tutors")
public class StudentsTutors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private User tutor;

    public StudentsTutors() {}

    public StudentsTutors(User student, User tutor) {
        this.student = student;
        this.tutor = tutor;
    }

    public Integer getId() { return id; }
    public User getStudent() { return student; }
    public User getTutor() { return tutor; }

    public void setId(Integer id) { this.id = id; }
    public void setStudent(User student) { this.student = student; }
    public void setTutor(User tutor) { this.tutor = tutor; }

    @Override
    public String toString() {
        return "StudentsTutors{" +
                "id=" + id +
                ", student=" + student +
                ", tutor=" + tutor +
                '}';
    }
}
