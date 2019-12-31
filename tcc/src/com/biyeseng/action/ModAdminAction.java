package com.biyeseng.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biyeseng.db.DBManager;
import java.sql.*;


public class ModAdminAction extends HttpServlet {


	public ModAdminAction() {
		super();
	}


	public void destroy() {
		super.destroy();
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
	 
		DBManager dbm = new DBManager();
		//修改管理员
		String sql = "update admin set userName='"+name+"',userPw='"+pwd+"' where id="+id;
		System.out.println(sql);

		Statement stat = null;
		Connection conn=null;
		try {
			conn=dbm.getConnection();
			stat = conn.createStatement();
			stat.execute(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(stat!=null)
					stat.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		response.sendRedirect("admin/list.jsp");
		out.flush();
		out.close();
	}


	public void init() throws ServletException {
		
	}

}
