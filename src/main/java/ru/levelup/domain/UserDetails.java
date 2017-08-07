package ru.levelup.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "AGE")
    private int age;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;


    /*************/
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
