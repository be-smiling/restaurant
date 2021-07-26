package com.sise.utils;

import com.jcraft.jsch.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//@Configurable
@Component
public class SFTPClientUtils {

    private ChannelSftp sftp;

    private Session session;
    /** FTP 登录用户名*/
    @Value(value ="${sftp.connect.username}")
    private String username;
    /** FTP 登录密码*/
    @Value(value ="${sftp.connect.password}")
    private String password;
    /** 私钥 */
    private String privateKey;
    /** FTP 服务器地址IP地址*/
    @Value(value ="${sftp.connect.host}")
    private String host;
    /** FTP 端口*/
    @Value(value ="${sftp.connect.port}")
    private int port;


    /**
     * 构造基于密码认证的sftp对象
     * @param username
     * @param password
     * @param host
     * @param port
     */
    public SFTPClientUtils(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    /**
     * 构造基于秘钥认证的sftp对象
     * @param username
     * @param host
     * @param port
     * @param privateKey
     */
    public SFTPClientUtils(String username, String host, int port, String privateKey) {
        this.username = username;
        this.host = host;
        this.port = port;
        this.privateKey = privateKey;
    }

    public SFTPClientUtils(){}

    /**
     * 连接sftp服务器
     *
     * @throws Exception
     */
    public void login(){
        try {
            JSch jsch = new JSch();
            if (privateKey != null) {
                jsch.addIdentity(privateKey);// 设置私钥
            }
            session = jsch.getSession(username, host, port);
            if (password != null) {
                session.setPassword(password);
            }
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();

            sftp = (ChannelSftp) channel;
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接 server
     */
    public void logout(){
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

    /**
     * 将输入流的数据上传到sftp作为文件
     *
     * @param directory
     *            上传到该目录
     * @param sftpFileName
     *            sftp端文件名
     * @param in
     *            输入流
     * @throws SftpException
     * @throws Exception
     */
    public void upload(String directory, String sftpFileName, File in) throws SftpException, IOException {
        InputStream input = new FileInputStream(in);
        try {
            sftp.cd(directory);
        } catch (SftpException e) {
            System.out.println("上传失败");
            sftp.mkdir(directory);
            sftp.cd(directory);
        }finally {

        }
        sftp.put(input, sftpFileName);
        input.close();
    }

    /**
     * 删除文件
     *
     * @param directory
     *            要删除文件所在目录
     * @param deleteFile
     *            要删除的文件
     * @throws SftpException
     * @throws Exception
     */
    public void delete(String directory, String deleteFile) throws SftpException{
        sftp.cd(directory);
        sftp.rm(deleteFile);
    }
}
