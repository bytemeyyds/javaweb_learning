package com.bjpowernode.oa.web.action; /**
 * @author byteme
 * @date 2021/12/140943
 * 描述：
 */

import com.bjpowernode.oa.utils.DBUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtils.getConnection();
            String sql = "update dept set dname=?,loc=? where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setString(3,deptno);
            count = ps.executeUpdate();
            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,null);

        }

        if (count==1){
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }else {
            response.sendRedirect(request.getContextPath() + "/error.html");
        }


    }
}
