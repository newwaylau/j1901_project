package com.lw.dao.impl;

import com.lw.dao.GoodsInfoDao;
import com.lw.entity.GoodsInfo;
import com.lw.entity.GoodsType;
import com.lw.entity.User;
import com.lw.utils.DBCP;
import com.lw.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GoodsInfoDaoImpl implements GoodsInfoDao {
    @Override
    public List<GoodsInfo> getGoodsInfoList() {
        String sql = "select * from t_goods_info where flag=1";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        List<GoodsInfo> query = null;
        try {
            query = queryRunner.query(sql, new BeanListHandler<GoodsInfo>(GoodsInfo.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Integer getUserTotalCount() {
        String sql="select count(*) from t_goods_info where flag = 1";
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
    public List<GoodsInfo> getUserList(int i, Integer pageSize) {
        String sql ="select * from t_goods_info where flag = 1 limit ?,?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            List<GoodsInfo> query = queryRunner.query(sql, new BeanListHandler<GoodsInfo>(GoodsInfo.class),i,pageSize);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateObject(GoodsInfo goodsInfo) {
        String sql="update t_goods_info set goods_name=?," +
                "goods_description=?," +
                "goods_pic=?," +
                "goods_price=?," +
                "goods_price_off=?," +
                "goods_fatherid=?," +
                "goods_parentid=? where id = ?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            int update = queryRunner.update(sql, goodsInfo.getGoods_name(),
                    goodsInfo.getGoods_description(),
                    goodsInfo.getGoods_pic(),
                    goodsInfo.getGoods_price(),
                    goodsInfo.getGoods_price_off(),
                    goodsInfo.getGoods_fatherid(),
                    goodsInfo.getGoods_parentid(),
                    goodsInfo.getId());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public GoodsInfo getShowById(int id) {

        String sql="select * from t_goods_info where id = ?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        GoodsInfo query = null;
        try {
            query = queryRunner.query(sql, new BeanHandler<GoodsInfo>(GoodsInfo.class), id);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void batchDel(String[] ids) {
        StringBuffer sb = new StringBuffer("update t_goods_info set flag = 0 where id in(");
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int deleteGoodsInfo(int id) {

        String sql="update t_goods_info set flag = 0 where id = ?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            int update = queryRunner.update(sql, id);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<GoodsInfo> getGoodsInfoParent() {

        String sql="select id,goods_name from t_goods_info where flag = 1";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            List<GoodsInfo> query = queryRunner.query(sql, new BeanListHandler<GoodsInfo>(GoodsInfo.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addGoodsInfo(String goods_name, int goods_parentid, int goods_fatherid, int goods_price, int goods_price_off, String goods_pic, String goods_description) {
        String sql = "insert into t_goods_info(goods_name,goods_parentid,goods_fatherid,goods_price,goods_price_off,goods_pic,goods_description) values(?,?,?,?,?,?,?)";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            int update = queryRunner.update(sql, goods_name, goods_parentid, goods_fatherid, goods_price, goods_price_off, goods_pic, goods_description);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public GoodsInfo getShowByNone() {
        String sql="select * from t_goods_info";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            GoodsInfo query = queryRunner.query(sql, new BeanHandler<GoodsInfo>(GoodsInfo.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public int addGoodsInfo1(String goods_name1, String goods_price1, String goods_price_off1, String goods_description1, String goods_pic1) {
        String sql ="insert into t_goods_info(goods_name,goods_price,goods_price_off,goods_description,goods_pic) values(?,?,?,?,?)";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            int update = queryRunner.update(sql, goods_name1, goods_price1, goods_price_off1, goods_description1, goods_pic1);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
