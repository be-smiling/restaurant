package com.sise.utils;

/**
 * 常量接口
 */
public interface Constast {
    //FTP服务器路径
    public static final String IMAGES_FTP_PATH = "http://www.gzsxzh.cn:82/";
    //活动图片下载路径
    public static final String IMAGES_DOWNLOAD_ACTION_PNG = "http://www.gzsxzh.cn:82/act_img/";
    //活动图片上传路径
    public static final String IMAGES_ACTION_PNG_PATH = "/usr/jojo-work/picture_store/act_img";
    //签到二维码上传路径
    public static final String IMAGES_UP_INQRCODE_PNG_PATH = "/usr/jojo-work/picture_store/act_in_qrcode";
    //签退二维码上传路径
    public static final String IMAGES_UP_OUTQRCODE_PNG_PATH = "/usr/jojo-work/picture_store/act_out_qrcode";
    //签到二维码下载路径
    public static final String IMAGES_DOWNLOAD_INQRCODE_PNG_PATH = "http://www.gzsxzh.cn:82/act_in_qrcode/";
    //签退二维码下载路径
    public static final String IMAGES_DOWNLOAD_OUTQRCODE_PNG_PATH = "http://www.gzsxzh.cn:82/act_out_qrcode/";

    //身份证上传路径
    public static final String IMAGES_UP_IDENTITYCARD_PNG_PATH = "/usr/jojo-work/picture_store/identitycard";
    //身份证下载路径
    public static final String IMAGES_DOWNLOAD_IDENTITYCARD_PNG_PATH = "http://www.gzsxzh.cn:82/identitycard/";

    //商品图片下载路径
    public static final String IMAGES_DOWNLOAD_GOODS_PNG_PATH = "http://www.gzsxzh.cn:82/goods_img/";
    //商品图片上传路径
    public static final String IMAGES_UP_GOODS_PNG_PATH = "/usr/jojo-work/picture_store/goods_img";


    //sftp的用户名
    public static final String SFTP_USERNAME = "root";

    //sftp的密码
    public static final String SFTP_PASSWORD = "1234Jkl;";
    //sftp的ip地址
//    public static final String SFTP_HOST = "www.gzsxzh.cn";
    public static final String SFTP_HOST = "47.103.218.111";

    //sftp的端口地址
    public static final Integer SFTP_POST = 22;

    //状态码常量
    public static final Integer OK=200;

    public static final Integer ERROR=-1;

}
