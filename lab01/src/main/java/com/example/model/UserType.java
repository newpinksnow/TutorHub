package com.example.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_name", nullable = false, length = 100)
    private String typeName;

    // 🔹 Связь 1 ко многим: один UserType -> много Users
    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
    private List<User> users;

    // 🔹 Связь 1 ко многим: один UserType -> много UserTypeInfo
    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
    private List<UserTypeInfo> userTypeInfos;

    public UserType() {}

    public UserType(String typeName) {
        this.typeName = typeName;
    }

    public Integer getId() { return id; }
    public String getTypeName() { return typeName; }
    public List<User> getUsers() { return users; }
    public List<UserTypeInfo> getUserTypeInfos() { return userTypeInfos; }

    public void setId(Integer id) { this.id = id; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
    public void setUsers(List<User> users) { this.users = users; }
    public void setUserTypeInfos(List<UserTypeInfo> userTypeInfos) { this.userTypeInfos = userTypeInfos; }

    @Override
    public String toString() {
        return "UserType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
