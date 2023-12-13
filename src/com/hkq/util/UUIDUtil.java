package com.hkq.util;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author LP
 */
public class UUIDUtil {
    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            System.out.println(randomUUID());
        }

    }

    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}


