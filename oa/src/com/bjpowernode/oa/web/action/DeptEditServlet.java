package com.bjpowernode.oa.web.action; /**
 * @author byteme
 * @date 2021/12/112253
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

public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='utf-8'>");
        out.print("        <title>修改部门</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>修改部门</h1>");
        out.print("        <hr />");
        out.print("        <form action='/oa/dept/modify' method='post'>");




        String deptno = request.getParameter("deptno");



        //连接数据库，查询所有部门
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = DBUtils.getConnection();
            //获取预编译的数据库操作对象
            String sql = "select * from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);

            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("                部门编号<input type='text' name='deptno' value='"+deptno+"' readonly='readonly'/><br />");
                out.print("                部门名称<input type='text' name='dname' value='"+dname+"' /><br>");
                out.print("                部门位置<input type='text' name='loc'  value='"+loc+"' /><br>");

            }





        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DBUtils.close(conn,ps,rs);
        }


        out.print("            <input type='submit'  value='修改' />");
        out.print("        </form>");
        out.print("    </body>");
        out.print("</html>");


    }


}
