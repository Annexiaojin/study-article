package com.article.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
    public static String encryptToMD5(String str) {
        return DigestUtils.md5Hex(str);
    }
}
