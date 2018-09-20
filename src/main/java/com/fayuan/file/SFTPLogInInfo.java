/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.file;

/**
 * SFTP连接信息
 *
 * @author fayuan.fzw
 * @version $Id: SFTPLogInInfo.java, v 0.1 2018年06月27日 上午11:25 fayuan.fzw Exp $
 */
public class SFTPLogInInfo {

    /** 登录用户名 */
    private String       userName;

    /** 登录密码 */
    private String       password;

    /** sftp服务器地址 */
    private String       host;

    /** sftp服务器端口 */
    private int          port;

    /** 登录私钥 */
    private String       privateKey;

    public SFTPLogInInfo() {
    }

    /**
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName  value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method for property <tt>password</tt>.
     *
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     *
     * @param password  value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property <tt>host</tt>.
     *
     * @return property value of host
     */
    public String getHost() {
        return host;
    }

    /**
     * Setter method for property <tt>host</tt>.
     *
     * @param host  value to be assigned to property host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Getter method for property <tt>port</tt>.
     *
     * @return property value of port
     */
    public int getPort() {
        return port;
    }

    /**
     * Setter method for property <tt>port</tt>.
     *
     * @param port  value to be assigned to property port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Getter method for property <tt>privateKey</tt>.
     *
     * @return property value of privateKey
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * Setter method for property <tt>privateKey</tt>.
     *
     * @param privateKey  value to be assigned to property privateKey
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String toString() {
        return "SFTPLogInInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", privateKey='" + privateKey + '\'' +
                '}';
    }
}