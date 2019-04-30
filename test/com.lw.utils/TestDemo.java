package com.lw.utils;

import org.junit.Test;

import java.sql.Connection;

public class TestDemo {
    @Test
    public void test1() {
        Connection connection = DBUtils.getConnection();
        System.out.println(connection);
    }
}
