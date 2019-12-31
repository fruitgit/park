package com.biyeseng.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biyeseng.db.DBManager;


public class AddAdminAction extends HttpServlet {

	
	public AddAdminAction() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		
		DBManager dbm = new DBManager();
		//插入管理员信息表
		String sql = "insert into admin(userName,userPw)  values('"+name+"','"+pwd+"')";

		Statement stat = null;
		Connection conn=null;
		try {
			conn=dbm.getConnection();
			stat = conn.createStatement();
			System.out.println(sql);
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
