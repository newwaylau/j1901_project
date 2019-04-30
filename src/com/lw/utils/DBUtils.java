package com.lw.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

    static  Connection connection;
    static{
        try{
            //获取配置文件的信息
            Properties properties = new Properties();
            properties.load(DBUtils.class.getResourceAsStream("/db.properties"));
            // 通过key 获取 value
            String driver = properties.getProperty("jdbc.driver");
            String url = properties.getProperty("jdbc.url");
            String user = properties.getProperty("jdbc.user");
            String password = properties.getProperty("jdbc.password");

            // 加载驱动
            Class.forName(driver);
            // 通过 url user password 去连接数据库
           connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
        }
    }

    // 获取连接对象
    public static Connection getConnection(){

        return  connection;
    }

    // 关闭连接对象
    public static void close(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
