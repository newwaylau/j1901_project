package com.lw.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.util.Properties;

public class DBCP {
    static QueryRunner queryRunner = null;
        static {
            Properties properties = new Properties();
            try {
                properties.load(DBCP.class.getResourceAsStream("/db.properties"));
                DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
                queryRunner = new QueryRunner(dataSource);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static QueryRunner getQueryRunner(){
            return queryRunner;
        }
}
