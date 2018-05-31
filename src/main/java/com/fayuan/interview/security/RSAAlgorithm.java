/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.security;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA算法
 *
 * @author fayuan.fzw
 * @version $Id: RSAAlgorithm.java, v 0.1 2018年04月03日 下午6:47 fayuan.fzw Exp $
 */
public class RSAAlgorithm {

    public static final String KEY_ALGORITHM = "RSA";

    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    public static final String PUBLIC_KEY = "RSAPublicKey";

    public static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 解密
     *
     * @param key
     *
     * @return
     *
     * */
    public static byte[] decryptBASE64(String key) {

        return Base64.decodeBase64(key);
    }

    /**
     * 加密
     *
     * @param bytes
     *
     * @return
     *
     * */
    public static String encryptBASE64(byte[] bytes) {

        return Base64.encodeBase64String(bytes);
    }

    /**
     * 用私钥生成数字签名
     *
     * @param data        待生成签名的数据
     * @param privateKey  签名使用的私钥
     *
     * @return            签名结果
     *
     * */
    public static String sign(byte[] data, String privateKey) throws Exception {

        // 解密由base64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);

        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        //生成私钥
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

        //用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);

        signature.initSign(priKey);
        signature.update(data);

        return encryptBASE64(signature.sign());
    }

    /**
     *
     *
     * */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {

        //解密由base64编码的公钥
        byte[] keyBytes = decryptBASE64(publicKey);

        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        //取公钥对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);

        signature.initVerify(pubKey);

        signature.update(data);

        // 验证签名是否正常
        return signature.verify(decryptBASE64(sign));
    }
}