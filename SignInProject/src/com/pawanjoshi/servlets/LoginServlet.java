package com.pawanjoshi.servlets;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import com.pawanjoshi.dao.LoginDao;

public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass().getName() + " POST");
		
		LoginDao loginDao = new LoginDao();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("username");
		String p=request.getParameter("userpass");
		
		//creates a new session
		HttpSession session = request.getSession(false);
		
		if(session != null){
			session.setAttribute("name", n);
		}
		
		if(loginDao.validate(n, p)) {
			System.out.println("validated");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}
		else {
			System.out.print("Sorry username or password error");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp?status=fail");
			rd.include(request, response);
					
		}
		out.close();
	}
}