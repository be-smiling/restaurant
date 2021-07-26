package com.sise.configuration.auth;

import org.springframework.security.access.AccessDeniedException;

/**
 * 拒绝访问异常处理类
 */
public class MyAccessDeniedException extends AccessDeniedException {


    public MyAccessDeniedException(String msg) {
        super(msg);
    }
}
