package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.BranchDao;
import com.ty.dto.Branch;

@WebServlet("/displaybranch")
public class DisplayBranchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BranchDao dao = new BranchDao();
		List<Branch> branchs = dao.getAllBranches();
		
		req.setAttribute("myBranch", branchs);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_branch.jsp");
		dispatcher.forward(req, resp);
	}

}
