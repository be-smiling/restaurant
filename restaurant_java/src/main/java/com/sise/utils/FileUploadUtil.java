package com.sise.utils;


import com.sise.utils.Constast;
import com.sise.utils.Status;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadUtil {

    //上传图片并返回图片的完整路径
    public String uploadImg(MultipartFile img) {
        String fileName = UUID.randomUUID() + ".jpg";

        //创建SFTP连接
        SFTPClientUtils sftp = new SFTPClientUtils(Constast.SFTP_USERNAME, Constast.SFTP_PASSWORD, Constast.SFTP_HOST, Constast.SFTP_POST);
        //登录FTP服务器
        sftp.login();
        //创建文件工具类
        AppFileUtils fileUtils = new AppFileUtils();
        File excelFile = null;
        try {
            //将前台上传的图片文件（MultipartFile）转换为（File）
            excelFile = fileUtils.transferToFile(img);
            //将图片上传到图片服务器（图片服务器的路径，保存的文件名，保存的文件）
            sftp.upload(Status.SAVE_PATH, fileName, excelFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //删除活动图片的临时文件
        AppFileUtils.delteTempFile(excelFile);
        sftp.logout();

        return Status.VISIT_PATH+fileName;
    }
}
