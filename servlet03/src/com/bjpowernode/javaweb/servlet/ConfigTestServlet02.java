package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author byteme
 * @date 2021/12/81835
 * 描述：
 */
public class ConfigTestServlet02 extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        ServletConfig servletConfig = getServletConfig();
        writer.print(servletConfig);
    }
}
