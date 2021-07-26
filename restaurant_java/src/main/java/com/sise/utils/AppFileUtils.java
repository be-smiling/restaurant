package com.sise.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class AppFileUtils {
    /**
     * @param file     文件
     * @param path     文件存放路径
     * @param fileName 保存的文件名
     * @return
     */
    public static boolean upload(MultipartFile file, String path, String fileName) {

        //确定上传的文件名
        String realPath = path + "\\" + fileName;

        File dest = new File(realPath);

        //判断文件父目录是否存在,如果不存在就创建
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 根据老路径删除图片
     * @param oldPath
     */

    public static void removeFileByPath(String oldPath) {
        // TODO Auto-generated method stub
//        //判断一下原先的图片是不是默认图片(不是则删除)
//        if(!oldPath.equals(Constast.IMAGES_DEFAULTGOODSIMG_PNG)){
            //1、在服务器中找到文件(父路径，子路径)
            File file=new File(oldPath);
            //2、判断文件是否存在
            if(file.exists()){
                //3、如果存在就删掉
                file.delete();
            }
//        }
    }

    public File transferToFile(MultipartFile multipartFile) throws IOException {
//        选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
        File toFile = null;
        if (multipartFile.equals("") || multipartFile.getSize() <= 0) {
            multipartFile = null;
        } else {
            InputStream ins = null;
            ins = multipartFile.getInputStream();
            toFile = new File(multipartFile.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    /**
     * 获取流文件
     * @param ins
     * @param file
     */
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
        }
    }

}
