package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class BServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException,ServletException{

		//使用了转发机制后，是可以取到的
		Object obj = request.getAttribute("sysTime");


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(obj);

		//HttpServletRequest接口的其他常用方法
		// 获取应用的根路径
		String contextPath=request.getContextPath();
		out.println(contextPath);   //   /servlet08

		// 获取请求方式
		String method=request.getMethod();
		out.println(method);  // GET

		// 获取请求的URI
		String uri=request.getRequestURI();
		out.println(uri);// /servlet08/b

		// 获取servlet path
		String servletPath=request.getServletPath();
		out.println(servletPath);//   /b
	}
}