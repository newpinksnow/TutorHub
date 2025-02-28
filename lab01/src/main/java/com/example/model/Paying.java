package com.example.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paying")
public class Paying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payingId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @Column(name = "money")
    private Double money;

    @Column(name = "number_lesson")
    private Integer numberLesson;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_start")
    private Date dataStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_finish")
    private Date dataFinish;

    @Column(name = "status", length = 50)
    private String status;

    // ✅ Пустой конструктор (нужен для Hibernate)
    public Paying() {}

    // ✅ Конструктор с параметрами (исправленный)
    public Paying(User student, Double money, Integer numberLesson, Date dataStart, Date dataFinish, String status) {
        this.student = student;
        this.money = money;
        this.numberLesson = numberLesson;
        this.dataStart = dataStart;
        this.dataFinish = dataFinish;
        this.status = status;
    }

    public Integer getPayingId() { return payingId; }
    public User getStudent() { return student; }
    public Double getMoney() { return money; }
    public Integer getNumberLesson() { return numberLesson; }
    public Date getDataStart() { return dataStart; }
    public Date getDataFinish() { return dataFinish; }
    public String getStatus() { return status; }

    public void setStudent(User student) { this.student = student; }
    public void setMoney(Double money) { this.money = money; }
    public void setNumberLesson(Integer numberLesson) { this.numberLesson = numberLesson; }
    public void setDataStart(Date dataStart) { this.dataStart = dataStart; }
    public void setDataFinish(Date dataFinish) { this.dataFinish = dataFinish; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Paying{" +
                "payingId=" + payingId +
                ", student=" + student +
                ", money=" + money +
                ", numberLesson=" + numberLesson +
                ", dataStart=" + dataStart +
                ", dataFinish=" + dataFinish +
                ", status='" + status + '\'' +
                '}';
    }
}
