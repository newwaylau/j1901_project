package com.lw.dao;

import com.lw.entity.User;

import java.util.List;

public interface UserDao {
    User getUserByUsernameAndPassword(String username, String password);

    int registerByUsernameAndPassword(String username, String password);


    int checkUsername(String username);

    Integer getUserTotalCount();

    List<User> getUserList(int i, Integer pageSize);

    int addUser(String username, String password, String phone, String email, String is_role);

    int deleteUser(int parseInt);

    User getUserById(int id);

    int updateUser(int parseInt, String username, String password, String phone, String email, String is_role);

    void batchDel(String[] ids);
}
