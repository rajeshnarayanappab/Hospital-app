package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.UserDao;
import com.ty.dto.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
UserDao dao=new UserDao();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user=dao.validateUser(email, password);
		
if(user != null) {
	
	HttpSession httpSession = req.getSession();
	httpSession.setAttribute("name",user.getName());
	httpSession.setAttribute("role", user.getRole());
	
		if(user.getRole().equals("staff")) {
			httpSession.setAttribute("branchId", user.getBranch().getId());
			RequestDispatcher dispatcher = req.getRequestDispatcher("staff_navbar.jsp");
			dispatcher.forward(req, resp);
		}
		else if(user.getRole().equals("admin")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("admin_navbar.jsp");
			dispatcher.forward(req, resp);
		}
		else if(user.getRole().equals("user")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("user_navbar.jsp");
			dispatcher.forward(req, resp);
		}
	}
		else {
			PrintWriter pout=resp.getWriter();
			pout.print("<h1>Invalid email or password</h1>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);

		}
	}
}
