package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.BranchDao;
import com.ty.dao.PersonDao;
import com.ty.dto.Branch;
import com.ty.dto.Hospital;
import com.ty.dto.Person;


@WebServlet("/createbranch")
public class CreateBranchServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
                 HttpSession httpSession = req.getSession();
		
//		Integer hospitalid = (Integer)httpSession.getAttribute("hospitalid");
		
		Branch branch = new Branch();
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
	

		branch.setName(name);
		branch.setEmail(email);
		branch.setCno(Long.parseLong(phone));
		int hospitalid=Integer.parseInt(req.getParameter("hospitalid"));

		
		BranchDao branchDao = new BranchDao();
		branchDao.saveBranch(branch, hospitalid);
		
		PrintWriter pw =resp.getWriter();
		pw.print("<html><body><h1>Branch Added</h1></body></html>");

		
	}

}