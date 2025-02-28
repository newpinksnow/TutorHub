package com.example.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate", nullable = false)
    private Date birthDate;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "telegramm", nullable = false, length = 20)
    private String telegram;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    // 🔹 Связь 1 ко многим: один пользователь -> несколько доп. инфо
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserInfo> userInfos;

    // 🔹 Связь 1 ко многим: ученик может иметь несколько репетиторов
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentsTutors> tutors;

    // 🔹 Связь 1 ко многим: репетитор может иметь несколько учеников
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<StudentsTutors> students;

    // 🔹 Связь 1 ко многим: ученик может иметь несколько домашних заданий
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentsHomework> homeworks;

    // 🔹 Связь 1 к 1: один ученик -> доп. материалы
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private AdditionalMaterials additionalMaterials;

    // 🔹 Связь 1 ко многим: один ученик -> несколько занятий
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Timetable> timetable;

    // 🔹 Связь 1 ко многим: один ученик -> несколько платежей
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Paying> payments;

    public User() {}

    public User(String firstName, String lastName, Date birthDate, String email, String phone, String telegram, String passwordHash, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.telegram = telegram;
        this.passwordHash = passwordHash;
        this.userType = userType;
    }

    public Integer getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getBirthDate() { return birthDate; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getTelegram() { return telegram; }
    public String getPasswordHash() { return passwordHash; }
    public UserType getUserType() { return userType; }
    public List<UserInfo> getUserInfos() { return userInfos; }
    public List<StudentsTutors> getTutors() { return tutors; }
    public List<StudentsTutors> getStudents() { return students; }
    public List<StudentsHomework> getHomeworks() { return homeworks; }
    public AdditionalMaterials getAdditionalMaterials() { return additionalMaterials; }
    public List<Timetable> getTimetable() { return timetable; }
    public List<Paying> getPayments() { return payments; }

    public void setId(Integer id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setTelegram(String telegram) { this.telegram = telegram; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setUserType(UserType userType) { this.userType = userType; }
    public void setUserInfos(List<UserInfo> userInfos) { this.userInfos = userInfos; }
    public void setTutors(List<StudentsTutors> tutors) { this.tutors = tutors; }
    public void setStudents(List<StudentsTutors> students) { this.students = students; }
    public void setHomeworks(List<StudentsHomework> homeworks) { this.homeworks = homeworks; }
    public void setAdditionalMaterials(AdditionalMaterials additionalMaterials) { this.additionalMaterials = additionalMaterials; }
    public void setTimetable(List<Timetable> timetable) { this.timetable = timetable; }
    public void setPayments(List<Paying> payments) { this.payments = payments; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
