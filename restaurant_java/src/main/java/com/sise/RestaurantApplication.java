package com.sise;

import com.sise.utils.FileUploadUtil;
import com.sise.utils.RUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@MapperScan("com.sise.mapper")
@EnableTransactionManagement //开启事务控制
public class RestaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }

    @Bean
    //将文件上传工具类交给Spring管理
    public FileUploadUtil getFileUploadUtil(){
        return new FileUploadUtil();
    }

    @Bean
    public RUtil getRUtil() {
        return new RUtil();
    }
}
