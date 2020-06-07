package com.roma.models;

import javax.persistence.*;

@Entity
@Table(name = "users2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 45, nullable = false)
    private String name;
    @Column(name = "age", nullable = false)
    private Long age;

    public User() {
    }

//    public User(String name, Long age) {
//        this.name = name;
//        this.age = age;
//    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
