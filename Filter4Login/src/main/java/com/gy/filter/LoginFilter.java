package com.gy.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter extends HttpFilter {
	
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		Object loginUser = session.getAttribute("loginUser");
		
		if(loginUser == null){
			request.setAttribute("msg", "请重新登录");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
		
	}

}
