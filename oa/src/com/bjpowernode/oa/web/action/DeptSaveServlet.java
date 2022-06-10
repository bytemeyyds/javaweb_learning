package com.bjpowernode.oa.web.action; /**
 * @author byteme
 * @date 2021/12/121137
 * 描述：
 */

import com.bjpowernode.oa.utils.DBUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptSaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取部门信息
        //注意乱码问题
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        //连接数据库执行insert语句
        Connection conn = null;
        PreparedStatement ps = null;

        int count = 0;
        try {
            conn= DBUtils.getConnection();
            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,loc);

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,null);
        }

        if (count==1){
            //保存成功跳转到列表页面
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }else {
            //保存失败跳转到失败页面
            response.sendRedirect(request.getContextPath() + "/error.html");

        }

    }
}
