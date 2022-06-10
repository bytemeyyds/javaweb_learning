<%--
  Created by IntelliJ IDEA.
  User: yiya
  Date: 2022/4/15
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>cookie</title>
  </head>
  <body>
  <a href="<%=request.getContextPath()%>/cookie/generate">服务器生成cookie，然后将cookie响应给浏览器，浏览器接受cookie，将cookie放到客户端上</a>
  <a href="<%=request.getContextPath()%>/sendCookie">发送cookie</a>
  </body>
</html>
