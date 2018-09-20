/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.file;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author fayuan.fzw
 * @version $Id: SFTPHelper.java, v 0.1 2018年06月22日 下午3:48 fayuan.fzw Exp $
 */
public class SFTPHelper {

    /**
     * 连接sftp服务器
     *
     * @param host     主机
     * @param port     端口
     * @param userName 用户名
     * @param password 密码
     *
     * @return
     * */
    public ChannelSftp connect(String host, int port, String userName, String password) {

        ChannelSftp channelSftp = null;

        try {
            JSch jSch = new JSch();
            jSch.getSession(userName, password, port);
            Session session = jSch.getSession(userName, password, port);
            System.out.println("创建session成功！");

            session.setPassword(password);
            Properties properties = new Properties();
            properties.put("StrictHostKeyChecking", "no");
            session.setConfig(properties);
            session.connect();
            System.out.println("连接session成功！");

            System.out.println("开启channel");
            Channel channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return channelSftp;
    }

    /**
     * 上传文件
     *
     * @param directory  待上传的文件所在目录
     * @param uploadFile 待上传的文件
     * */
    public void upload(String directory, String uploadFile, ChannelSftp channelSftp) {

        try {
            channelSftp.cd(directory);
            File file = new File(uploadFile);
            channelSftp.put(new FileInputStream(file), file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载文件
     *
     * @param directory    待下载的文件所在目录
     * @param downloadFile 待下载的文件
     * @param saveFile     存在本地的路径
     * @param channelSftp
     * */
    public void download(String directory, String downloadFile, String saveFile, ChannelSftp channelSftp) {

        try {
            channelSftp.cd(directory);
            File file = new File(saveFile);
            channelSftp.get(downloadFile, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}