package com.bjpowernode.oa.web.action; /**
 * @author byteme
 * @date 2021/12/111132
 * 描述：
 */


import com.bjpowernode.oa.utils.DBUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端请求的部门编号
        String deptno = request.getParameter("deptno");


        //设置响应的内容类型。以及字符型
        response.setContentType("text/html;chatset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='utf-8'>");
        out.print("        <title>部门详情</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>部门详情</h1>");
        out.print("        <hr >");
        //以上部分是死的






        //连接数据库，查询所有部门
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = DBUtils.getConnection();
            //获取预编译的数据库操作对象
            String sql = "select deptno,dname,loc from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            //执行sql语句
            rs = ps.executeQuery();
            //处理结果集
            int i = 0;
            while (rs.next()){
                String deptno1 = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.print("                部门编号:"+deptno1+" <br>");
                out.print("                部门名称："+dname+"<br>");
                out.print("        部门位置："+loc+" <br>");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DBUtils.close(conn,ps,rs);
        }


        //以下部分是死的
        out.print("        <input type='button' value='后退' onclick='window.history.back()' />");
        out.print("    </body>");
        out.print("</html>");
    }

}
