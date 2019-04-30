package com.lw.dao.impl;

import com.lw.dao.UserDao;
import com.lw.entity.User;
import com.lw.utils.DBCP;
import com.lw.utils.DBUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 登录用户名,密码
     * @param username
     * @param password
     * @return
     */
    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username=? and password=?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            User query = queryRunner.query(sql, new BeanHandler<>(User.class),username,password);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注册用户名,密码
     * @param username
     * @param password
     * @return
     */
    @Override
    public int registerByUsernameAndPassword(String username, String password) {
        String sql = "insert into t_user(username,password) values(?,?)";
        Connection connection = DBUtils.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int checkUsername(String username) {
        String sql= "select count(*) from t_user where username=?";
        Connection connection = DBUtils.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            int anInt = resultSet.getInt(1);
            return anInt;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 0;
    }

    @Override
    public Integer getUserTotalCount() {
        String sql="select count(*) from t_user where flag = 1";
        Connection connection = DBUtils.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            int anInt = resultSet.getInt(1);
            return anInt;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> getUserList(int i, Integer pageSize) {
        String sql ="select * from t_user where flag = 1 limit ?,?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            List<User> query = queryRunner.query(sql, new BeanListHandler<User>(User.class),i,pageSize);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int addUser(String username, String password, String phone, String email, String is_role) {

        String sql = "insert into t_user(username,password,phone,email,is_role) values(?,?,?,?,?)";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            int update = queryRunner.update(sql, username, password, phone, email, is_role);
            return update;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(int parseInt) {

        String sql="update t_user set flag = 0 where id = ?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        int update = 0;
        try {
            update = queryRunner.update(sql, parseInt);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User getUserById(int id) {
        String sql="select * from t_user where id=?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            User query = queryRunner.query(sql, new BeanHandler<User>(User.class),id);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public int updateUser(int parseInt, String username, String password, String phone, String email, String is_role) {
        String sql="update t_user set username=?,password=?,phone=?,email=?,is_role=? where id=?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            int update = queryRunner.update(sql, username, password, phone, email, is_role, parseInt);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void batchDel(String[] ids) {
        StringBuffer sb = new StringBuffer("update t_user set flag = 0 where id in(");
        for (int i = 0;i <ids.length;i++){
            if(i == ids.length -1){
                sb.append("?)");
            }else{
                sb.append("?,");
            }
        }
        String sql = sb.toString();
        System.out.println(sql);
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            int update = queryRunner.update(sql, ids);
            System.out.println(update);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
