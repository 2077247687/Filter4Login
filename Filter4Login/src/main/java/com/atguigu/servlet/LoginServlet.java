package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取Sessino对象
		HttpSession session = request.getSession();
		
		//获取用户名和密码
		String username = request.getParameter("username");
		
		//如果希望服务器记录用户的登录状态，那么需要将用户的登录信息放入到一个域对象中存储起来
		session.setAttribute("loginUser", username);
		
		//默认登录成功
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

}
