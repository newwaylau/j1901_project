package com.lw.dao.impl;

import com.lw.dao.OrderDao;
import com.lw.entity.Order;
import com.lw.entity.OrderDetail;
import com.lw.entity.User;
import com.lw.utils.DBCP;
import com.lw.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {
    @Override
    public Integer getUserTotalCount() {
        String sql="select count(*) from t_order_detail";
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
    public List<OrderDetail> getUserList(int i, Integer pageSize) {
        String sql ="select * from t_order_detail limit ?,?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            List<OrderDetail> query = queryRunner.query(sql, new BeanListHandler<OrderDetail>(OrderDetail.class),i,pageSize);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int deleteOrderById(int id, String table) {
        String sql = "delete from "+table+" where id = ?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            int update = queryRunner.update(sql, id);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
