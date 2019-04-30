package com.lw.dao.impl;

import com.lw.dao.GoodsTypeDao;
import com.lw.entity.GoodsInfo;
import com.lw.entity.GoodsType;
import com.lw.entity.Page;
import com.lw.utils.DBCP;
import com.lw.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDaoImpl implements GoodsTypeDao {
    @Override
    public List<GoodsType> getGoodsTypeList() {
        String sql = "select * from t_goods_type where flag=1";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        List<GoodsType> query = null;
        try {
            query = queryRunner.query(sql, new BeanListHandler<GoodsType>(GoodsType.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public List<GoodsType> getGoodsTypePage(int start, int pageSize) {
        String sql = "SELECT gt.id,gt.name,gi.goods_name,gt.flag FROM t_goods_type gt LEFT JOIN t_goods_info gi ON gt.`parent_id`=gi.`goods_parentid` where gt.flag=1 LIMIT ?,?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            List<GoodsType> query = queryRunner.query(sql, new ResultSetHandler<List<GoodsType>>() {
                @Override
                public List<GoodsType> handle(ResultSet resultSet) throws SQLException {
                    List<GoodsType> goodsTypes = new ArrayList<>();
                    while (resultSet.next()) {
                        GoodsType goodsType = new GoodsType();
                        goodsType.setId(resultSet.getInt(1));
                        goodsType.setName(resultSet.getString(2));
                        goodsType.setFlag(resultSet.getInt(4));
                        GoodsInfo goodsInfo = new GoodsInfo();
                        goodsInfo.setGoods_name(resultSet.getString(3));
                        goodsType.setGoods_name(goodsInfo);
                        goodsTypes.add(goodsType);
                    }
                    return goodsTypes;
                }
            },start,pageSize);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public int delGoodsType(int id) {
        String sql = "update t_goods_type set flag=0 where id=?";
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
    public Page getPage(String currentPage) {
        return null;
    }

    @Override
    public Integer getUserTotalCount() {
        String sql="select count(*) from t_goods_type where flag = 1";
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
    public List<GoodsType> getUserList(int i, Integer pageSize) {
        String sql ="select * from t_goods_type where flag = 1 limit ?,?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            List<GoodsType> query = queryRunner.query(sql, new BeanListHandler<GoodsType>(GoodsType.class),i,pageSize);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<GoodsType> getGoodsTypeParentList(String parent_id) {
        String sql="select id,name from t_goods_type where flag = 1 and parent_id = ?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            List<GoodsType> query = queryRunner.query(sql, new BeanListHandler<GoodsType>(GoodsType.class),parent_id);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void batchDel(String[] ids) {
        StringBuffer sb = new StringBuffer("update t_goods_type set flag = 0 where id in(");
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
            int update = queryRunner.update(sql,ids);
            System.out.println(update);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<GoodsType> getGoodsTypeParent() {

        String sql="select id,name from t_goods_type where flag = 1";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            List<GoodsType> query = queryRunner.query(sql, new BeanListHandler<GoodsType>(GoodsType.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GoodsType getObjectById(int parseInt) {
        String sql="select * from t_goods_type where id = ?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        GoodsType query = null;
        try {
            query = queryRunner.query(sql, new BeanHandler<>(GoodsType.class), parseInt);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int updateObject(int parseInt, String name, int parseInt1) {

        String sql="update t_goods_type set name=?,parent_id=? where id=?";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            int update = queryRunner.update(sql, name, parseInt1, parseInt);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int addGoodsType(String name, int parseInt) {
        String sql = "insert into t_goods_type(name,parent_id) values(?,?)";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            int update = queryRunner.update(sql, name, parseInt);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public GoodsType getShowByNone() {
        String sql="select * from t_goods_type";
        QueryRunner queryRunner = DBCP.getQueryRunner();
        try {
            GoodsType query = queryRunner.query(sql, new BeanHandler<GoodsType>(GoodsType.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
