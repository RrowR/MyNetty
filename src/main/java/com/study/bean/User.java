package com.study.bean;

import java.util.Date;

/**
 * atlan 2022/1/8 2:17
 */
public class User {
    private String name;
    private Integer age;
    private Date birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    public User() {
    }

    public User(String name, Integer age, Date birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }
}
