package com.example.model;
import java.util.Objects;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "timetable")
public class Timetable {
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_lesson", nullable = false)
    private Date dateLesson;

    public Timetable() {}

    public Timetable(User student, Date dateLesson) {
        this.student = student;
        this.dateLesson = dateLesson;
    }

    public User getStudent() { return student; }
    public Date getDateLesson() { return dateLesson; }

    public void setStudent(User student) { this.student = student; }
    public void setDateLesson(Date dateLesson) { this.dateLesson = dateLesson; }

    @Override
    public String toString() {
        return "Timetable{" +
                "student=" + student +
                ", dateLesson=" + dateLesson +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable that = (Timetable) o;
        return Objects.equals(student, that.student) && Objects.equals(dateLesson, that.dateLesson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, dateLesson);
    }
}

