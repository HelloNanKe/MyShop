package com.zt.Utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zt on 2017/7/4.
 */
public class ServiceUtils {

    /**
     * MD5加密
     * @param meassge
     * @return
     */
    public static String md5(String meassge){

        try {
            MessageDigest md=MessageDigest.getInstance("md5");
            byte md5[]=md.digest(meassge.getBytes());

            BASE64Encoder encoder=new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
