package com.hgq.javaweb.servlet.generateCookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie/generate")
public class GenerateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建cookie对象
        Cookie cookie = new Cookie("productid", "123456");
        Cookie cookie1 = new Cookie("nameid", "hgq");

        //设置cookie在1小时过后失效 （国际标准时间）
        cookie.setMaxAge(60 * 60);

        //设置cookie=0
//        cookie.setMaxAge(0);

        //设置cookie<0
//        cookie.setMaxAge(-1);

        // 默认情况下，没有设置path得时候，cookie默认关联的路径是http://localhost:8080/servlet13/cookie 以及它的子路径。
        cookie.setPath(request.getContextPath()); // 将当前cookie关联的url设置成当前项目名
        cookie1.setPath(request.getContextPath());
        //将cookie响应到浏览器
        response.addCookie(cookie);
        response.addCookie(cookie1);

        //
    }
}
