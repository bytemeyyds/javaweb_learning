package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DBUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author byteme
 * @date 2021/12/111047
 * 描述：
 */
public class DeptListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置响应的内容类型。以及字符型
        response.setContentType("text/html;chatset=UTF-8");
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath();


        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='utf-8'>");
        out.print("        <title>部门列表页面</title>");

        out.print("<script type='text/javascript'>");
        out.print("        function del(dno){");
        out.print("            if(window.confirm('亲，删了不可恢复喔！')){");
        out.print("            document.location.href = '/oa/dept/delete?deptno='+dno");
        out.print("         }");
        out.print("        }");
        out.print("</script>");

        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1 align='center'>部门列表</h1>");
        out.print("        <hr />");
        out.print("        <table border='1px' align='center' width='50%'>");
        out.print("            <tr>");
        out.print("                <th>序号</th>");
        out.print("                <th>部门编号</th>");
        out.print("                <th>部门名称</th>");
        out.print("                <th>操作</th>");
        out.print("            </tr>");
        out.print("            <!--以上是固定的-->");
        //上面一部分是死的





        //连接数据库，查询所有部门
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = DBUtils.getConnection();
            //获取预编译的数据库操作对象
            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            //执行sql语句
            rs = ps.executeQuery();
            //处理结果集
            int i = 0;
            while (rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                //这一部分是动态的
                out.print("            <!--以下是动态的的-->");
                out.print("            <tr>");
                out.print("                <th>"+(++i)+"</th>");
                out.print("                <th>"+deptno+"</th>");
                out.print("                <th>"+dname+"</th>");
                out.print("                <td>");
                out.print("                    <a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>");
                out.print("                    <a href='/oa/dept/edit?deptno="+deptno+"'>修改</a>");
                out.print("<a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>");
                out.print("                </td>");
                out.print("            </tr>");
                out.print("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DBUtils.close(conn,ps,rs);
        }

        //下面一部分是死的
        out.print("        </table>");
        out.print("        <hr />");
        out.print("        <a href='/oa/add.html'>新增部门</a>");
        out.print("    </body>");
        out.print("</html>");


    }
}
