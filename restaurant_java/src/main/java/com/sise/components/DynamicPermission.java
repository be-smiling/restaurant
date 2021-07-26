package com.sise.components;

import com.sise.configuration.auth.MyAccessDeniedException;
import com.sise.entity.SysBackendApiTable;
import com.sise.service.SysBackendApiTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class DynamicPermission {

    @Autowired
    SysBackendApiTableService service;


    /**
     * 判断有访问API的权限
     *
     * @param request
     * @param authentication
     * @return
     * @throws MyAccessDeniedException
     */
    public boolean checkPermisstion(HttpServletRequest request,
                                    Authentication authentication) throws MyAccessDeniedException {

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {

            UserDetails userDetails = (UserDetails) principal;
            //得到当前的账号
            String username = userDetails.getUsername();

            //通过账号获取资源鉴权
            List<SysBackendApiTable> apiUrls = service.getApiUrlByUserName(username);

            AntPathMatcher antPathMatcher = new AntPathMatcher();
            //当前请求路径
            String requestURI = request.getRequestURI();
            //当前请求方式
            String urlMethod = request.getMethod();

            //判断当前路径中是否在数据库权限表中
            boolean rs = apiUrls.stream().anyMatch(item -> {
                //判断URL是否匹配
                boolean hashAntPath = antPathMatcher.match(item.getBackendApiUrl(), requestURI);

                //判断请求方式是否和数据库中匹配（数据库存储：GET,POST,PUT,DELETE）
                String dbMethod = item.getBackendApiMethod();

                //处理数据库中存的请求方式为null
                dbMethod = (dbMethod == null) ? "" : dbMethod;
                int hasMethod = dbMethod.indexOf(urlMethod);

                //两者都成立，返回真，否则返回假
                return hashAntPath && (hasMethod != -1);
            });
            //返回
            if (rs) {
                return rs;
            } else {
                throw new MyAccessDeniedException("您没有访问该API的权限！");
            }

        } else {
            throw new MyAccessDeniedException("不是UserDetails类型！");
        }
    }
}