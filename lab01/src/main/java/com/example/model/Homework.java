package com.example.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "homework")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number_lesson", nullable = false)
    private Integer numberLesson;

    @Column(name = "topic_lesson", length = 255)
    private String topicLesson;

    @Column(name = "homework", columnDefinition = "TEXT")
    private String homeworkText;

    @Lob
    @Column(name = "material_hw")
    private byte[] materialHw;

    @Lob
    @Column(name = "finish_hw")
    private byte[] finishHw;

    // 🔹 Добавляем связь с StudentsHomework
    @OneToMany(mappedBy = "homework", cascade = CascadeType.ALL)
    private List<StudentsHomework> studentsHomeworks;

    public Homework() {}

    public Homework(Integer numberLesson, String topicLesson, String homeworkText, byte[] materialHw, byte[] finishHw) {
        this.numberLesson = numberLesson;
        this.topicLesson = topicLesson;
        this.homeworkText = homeworkText;
        this.materialHw = materialHw;
        this.finishHw = finishHw;
    }

    public Integer getId() { return id; }
    public Integer getNumberLesson() { return numberLesson; }
    public String getTopicLesson() { return topicLesson; }
    public String getHomeworkText() { return homeworkText; }
    public byte[] getMaterialHw() { return materialHw; }
    public byte[] getFinishHw() { return finishHw; }
    public List<StudentsHomework> getStudentsHomeworks() { return studentsHomeworks; }

    public void setNumberLesson(Integer numberLesson) { this.numberLesson = numberLesson; }
    public void setTopicLesson(String topicLesson) { this.topicLesson = topicLesson; }
    public void setHomeworkText(String homeworkText) { this.homeworkText = homeworkText; }
    public void setMaterialHw(byte[] materialHw) { this.materialHw = materialHw; }
    public void setFinishHw(byte[] finishHw) { this.finishHw = finishHw; }
    public void setStudentsHomeworks(List<StudentsHomework> studentsHomeworks) { this.studentsHomeworks = studentsHomeworks; }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", numberLesson=" + numberLesson +
                ", topicLesson='" + topicLesson + '\'' +
                '}';
    }
}
