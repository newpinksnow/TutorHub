package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_type_info_id", nullable = false)
    private UserTypeInfo userTypeInfo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "value", nullable = false, length = 100)
    private String value;

    public UserInfo() {}

    public UserInfo(UserTypeInfo userTypeInfo, User user, String value) {
        this.userTypeInfo = userTypeInfo;
        this.user = user;
        this.value = value;
    }

    public Integer getId() { return id; }
    public UserTypeInfo getUserTypeInfo() { return userTypeInfo; }
    public User getUser() { return user; }
    public String getValue() { return value; }

    public void setId(Integer id) { this.id = id; }
    public void setUserTypeInfo(UserTypeInfo userTypeInfo) { this.userTypeInfo = userTypeInfo; }
    public void setUser(User user) { this.user = user; }
    public void setValue(String value) { this.value = value; }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userTypeInfo=" + userTypeInfo +
                ", user=" + user +
                ", value='" + value + '\'' +
                '}';
    }
}
