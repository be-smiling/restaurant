package com.sise.controller;
import com.baomidou.mybatisplus.extension.api.R;
import com.sise.entity.Result;
import com.sise.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 统一异常处理类
 */
@ControllerAdvice //异常通知=>出现异常会执行
public class BaseExceptionHandler {
	
    @ExceptionHandler(value = Exception.class)//描述该方法作为通知代码处理方法,表标识异常类型
    @ResponseBody
    public R error(HttpServletResponse httpServletResponse, Exception e) throws IOException, ServletException {
        e.printStackTrace();        
        System.out.println( "出错信息："+ e.getMessage());
        return new R().setCode(-1).setData(null).setMsg(e.getMessage());
    }
}
