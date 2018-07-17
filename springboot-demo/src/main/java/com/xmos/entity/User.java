package com.xmos.entity;

public class User {
    private String name;

    private String password;

    private String age;

    private String dept;

    private String level;

    public User() {
    }

    public User(String name, String password, String age, String dept, String level) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.dept = dept;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", dept='" + dept + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}