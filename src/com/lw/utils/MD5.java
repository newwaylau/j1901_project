package com.lw.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {

    public static String getMD5(String value){
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] digest =md5.digest(value.getBytes());
            String s = new BigInteger(1,digest).toString(16);
            // 长度不够时前面补0
            for (int i = 0; i < 32 - s.length() ;i++) {
                s = "0" + s;
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
