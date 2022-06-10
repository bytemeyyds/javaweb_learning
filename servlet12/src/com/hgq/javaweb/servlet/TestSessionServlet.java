package com.hgq.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test/session")
public class TestSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request和session都是服务器端的java对象，都在JVM当中
        // request对象代表了一次请求（一次请求对应了一个request对象，，两次请求就对应了两个不同的request对象）
        // session对象代表了一次会话（一次会话就对应一个session对象）

        // 获取session对象

        // (从web服务器中获取session对象)
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        writer.print(session);

    }
}
