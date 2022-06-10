package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author byteme
 * @date 2021/12/91006
 * 描述：
 */
public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // 获取ServletContext对象
        ServletContext application = this.getServletContext();
        out.print("ServletContext对象是：" + application + "<br>");

        // 获取上下文的初始化参数
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = application.getInitParameter(name);
            out.print(name + "=" + value + "<br>");
        }

        // 获取context path （获取应用上下文的根）
        String contextPath = application.getContextPath();
        out.print(contextPath + "<br>");   //    /context  返回当前webapp的根

        // 获取文件的绝对路径
        // 后面的这个路径，加了一个“/”，这个“/”代表的是web的根
        //String realPath = application.getRealPath("/index.html"); // 可以
        // 你不加“/”，默认也是从根下开始找。
        //String realPath = application.getRealPath("index.html"); // 不加“/”也可以
        //out.print(realPath + "<br>");

        // C:\Users\Administrator\IdeaProjects\javaweb\out\artifacts\servlet04_war_exploded\common\common.html
        String realPath = application.getRealPath("/common/common.html");
        out.print(realPath + "<br>"); // D:\JAVAthing\javaweblaodu\javaweb\out\artifacts\servlet04_war_exploded\common\common.html

        // 准备数据
        User user = new User("jack", "123");
        // 向ServletContext应用域当中存储数据
        application.setAttribute("userObj", user);
        // 取出来
        //Object userObj = application.getAttribute("userObj");
        // 输出到浏览器
        //out.print(userObj + "<br>");
    }
}
