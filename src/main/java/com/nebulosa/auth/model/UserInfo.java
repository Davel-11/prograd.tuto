package com.nebulosa.auth.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "user")
@Table(name = "user")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String username;
    private String email;
    private String password;
    private boolean student;
    private boolean tutor;
    private boolean admin;


    //need default constructor for JSON Parsing
    public UserInfo(){ }

    public UserInfo(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    public UserInfo(String username, String email, String password, boolean student, boolean tutor, boolean admin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.student = student;
        this.tutor = tutor;
        this.admin = admin;
    }

    public boolean isStudent() {
        return student;
    }

    public boolean isTutor() {
        return tutor;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    //@Column(name = "student", nullable = true)
    public boolean getStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean getTutor() {
        return tutor;
    }

    public void setTutor(boolean tutor) {
        this.tutor = tutor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", student=" + student +
                ", tutor=" + tutor +
                '}';
    }
}