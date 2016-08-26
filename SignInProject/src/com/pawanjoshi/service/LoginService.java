package com.pawanjoshi.service;

import javax.servlet.http.HttpServletRequest;

import com.pawanjoshi.dao.LoginDao;

public class LoginService {

//	private LoginDao loginDao;
	
	public boolean authenticate(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("userpass");
		
		if (username == null || password == null) {
			return false;
		}
		
		LoginDao loginDao = new LoginDao();
		return loginDao.validate(username, password);		
	}
//
//	public LoginDao getLoginDao() {
//		return loginDao;
//	}
//
//	public void setLoginDao(LoginDao loginDao) {
//		this.loginDao = loginDao;
//	}
}
