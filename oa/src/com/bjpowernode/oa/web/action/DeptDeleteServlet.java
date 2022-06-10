package com.bjpowernode.oa.web.action; /**
 * @author byteme
 * @date 2021/12/111254
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

public class DeptDeleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端请求的部门编号
        String deptno = request.getParameter("deptno");

        //设置响应的内容类型。以及字符型
        response.setContentType("text/html;chatset=UTF-8");
        PrintWriter out = response.getWriter();

        //连接数据库，查询所有部门
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int count = 0;
        try {
            //获取连接
            conn = DBUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //获取预编译的数据库操作对象
            String sql = "delete from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            //执行sql语句
            count = ps.executeUpdate();
            conn.commit();



            //处理结果集
        } catch (SQLException e) {
            //遇到异常要回滚
            if (conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            //释放资源
            DBUtils.close(conn,ps,rs);
        }

        if (count==1) {
//            out.print("删除成功");
//            out.print("<a href='/oa/dept/list'>查看部门列表</a>");

            //也可以使用转发机制
//            request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }else {
            //删除失败
//            request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/error.html");
        }

    }

}
