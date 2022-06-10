package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author byteme
 * @date 2021/12/91519
 * 描述：
 */
public class PostServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>from post servlet</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>from post servlet</h1>");
        out.println("    </body>");
        out.println("</html>");


    }
}
