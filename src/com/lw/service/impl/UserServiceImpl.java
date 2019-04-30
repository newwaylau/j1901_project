package com.lw.service.impl;

import com.lw.dao.UserDao;
import com.lw.dao.impl.UserDaoImpl;
import com.lw.entity.Page;
import com.lw.entity.User;
import com.lw.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userDao.getUserByUsernameAndPassword(username,password);
    }

    @Override
    public int registerByUsernameAndPassword(String username, String password) {
        return userDao.registerByUsernameAndPassword(username,password);
    }


    @Override
    public int checkUsername(String username) {
        return userDao.checkUsername(username);
    }

    @Override
    public Page getPage(String currentPage) {
        //1.创建page对象
        Page page = new Page();
        //设置当前页
        if(currentPage != null){
            page.setCurrentPage(Integer.parseInt(currentPage));
        }
        //设置总条数
        page.setTotalCount(userDao.getUserTotalCount());
        page.setUrl("/user");
        page.setList(userDao.getUserList((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize()));
        return page;
    }

    @Override
    public int addUser(String username, String password, String phone, String email, String is_role) {
        return userDao.addUser(username,password,phone,email,is_role);
    }

    @Override
    public int deleteUser(int parseInt) {
        return userDao.deleteUser(parseInt);
    }


    @Override
    public int updateUser(int parseInt, String username, String password, String phone, String email, String is_role) {
        return userDao.updateUser(parseInt,username,password,phone,email,is_role);
    }

    @Override
    public void batchDel(String[] ids) {
        userDao.batchDel(ids);
    }


}
