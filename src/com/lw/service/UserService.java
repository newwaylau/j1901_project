package com.lw.service;

import com.lw.entity.Page;
import com.lw.entity.User;

public interface UserService {
    User getUserById(int id);

    /**
     * 登录 用户名 密码
     * @param username
     * @param password
     * @return
     */
    User getUserByUsernameAndPassword(String username, String password);

    int registerByUsernameAndPassword(String username, String password);


    /**
     *查用户名
     * @param username
     */
    int checkUsername(String username);

    Page getPage(String currentPage);

    int addUser(String username, String password, String phone, String email, String is_role);

    int deleteUser(int parseInt);


    int updateUser(int parseInt, String username, String password, String phone, String email, String is_role);

    void batchDel(String[] ids);
}
