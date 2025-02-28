package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_type_info")
public class UserTypeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    @Column(name = "user_info_name", nullable = false, length = 100)
    private String userInfoName;

    public UserTypeInfo() {}

    public UserTypeInfo(UserType userType, String userInfoName) {
        this.userType = userType;
        this.userInfoName = userInfoName;
    }

    public Integer getId() { return id; }
    public UserType getUserType() { return userType; }
    public String getUserInfoName() { return userInfoName; }

    public void setId(Integer id) { this.id = id; }
    public void setUserType(UserType userType) { this.userType = userType; }
    public void setUserInfoName(String userInfoName) { this.userInfoName = userInfoName; }

    @Override
    public String toString() {
        return "UserTypeInfo{" +
                "id=" + id +
                ", userType=" + userType +
                ", userInfoName='" + userInfoName + '\'' +
                '}';
    }
}

