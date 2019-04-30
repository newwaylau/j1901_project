package com.lw.entity;

public class User {
    /**
     *
     Create Table

     CREATE TABLE `t_user` (
     `id` int(10) NOT NULL AUTO_INCREMENT,
     `username` varchar(32) DEFAULT NULL,
     `password` varchar(32) DEFAULT NULL,
     `phone` varchar(32) DEFAULT NULL,
     `email` varchar(32) DEFAULT NULL,
     `is_role` int(2) DEFAULT NULL,
     `flag` int(2) DEFAULT '1',
     PRIMARY KEY (`id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8

     */
    private int id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private int is_role;
    private int flag;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", is_role=" + is_role +
                ", flag=" + flag +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIs_role() {
        return is_role;
    }

    public void setIs_role(int is_role) {
        this.is_role = is_role;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public User(int id, String username, String password, String phone, String email, int is_role, int flag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.is_role = is_role;
        this.flag = flag;
    }

    public User() {
    }
}
