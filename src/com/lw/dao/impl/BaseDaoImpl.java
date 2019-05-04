package com.lw.dao.impl;

import com.lw.dao.BaseDao;
import com.lw.utils.DBCP;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    QueryRunner queryRunner = DBCP.getQueryRunner();
    Class clazz = null;
    public BaseDaoImpl() {
        Class aClass = this.getClass();
        Type type = aClass.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            Type[] types = parameterizedType.getActualTypeArguments();
            clazz = (Class) types[0];
        }
    }

    @Override
    public T getIntroductionByIds(int id, String table) {

        String sql="select * from "+table+" where id = ?";
        try {
            T query = queryRunner.query(sql, new BeanHandler<T>(clazz), id);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> findByAddress(int id, String table) {
        String sql = "select * from "+table+" where userid=?";
        try {
            List<T> query = queryRunner.query(sql, new BeanListHandler<T>(clazz), id);

            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T getAddressByPhone(String phone, String table) {
        String sql="select * from "+table+" where phone = ?";
        try {
            T query = queryRunner.query(sql, new BeanHandler<T>(clazz), phone);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
