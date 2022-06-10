package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author byteme
 * @date 2021/12/91007
 * 描述：
 */
public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //获取ServletContext对象

        ServletContext application = this.getServletContext();
        out.print("ServletContext对象："+application); //org.apache.catalina.core.ApplicationContextFacade@6598b3e0

        // log
        // 这个日志会自动记录到哪里呢？
        // CATALINA_HOME/logs目录下。
        //application.log("大家好，我是动力节点杜老师，欢迎大家和我一起学习Servlet规范！");

        int age = 17; // 17岁
        // 当年龄小于18岁的时候，表示非法，记录日志
        if(age < 18) {
            application.log("对不起，您未成年，请绕行！", new RuntimeException("小屁孩，快走开，不适合你！"));
        }

        //在AServlet中向向ServletContext应用域当中存储数据
        //在BServlet中也可以取出来

        Object userObj = application.getAttribute("userObj");
//         输出到浏览器
        out.print(userObj + "<br>");
    }
}
