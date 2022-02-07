package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.AddressDao;
import com.ty.dao.BranchDao;
import com.ty.dto.Address;
import com.ty.dto.Branch;

@WebServlet("/createaddress")
public class CreateAddressServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
                 HttpSession httpSession = req.getSession();
		
//		Integer hospitalid = (Integer)httpSession.getAttribute("hospitalid");
		
		Address address = new Address();
		String city_name = req.getParameter("city_name");
		String pincode = req.getParameter("pincode");
		String state = req.getParameter("state");
	

		address.setCity_name(city_name);
		address.setState(state);
		address.setPincode(Integer.parseInt(pincode));
		int branchid=Integer.parseInt(req.getParameter("branchid"));
		
		AddressDao branchDao = new AddressDao();
		branchDao.createAdress(branchid, address);
		
		PrintWriter pw =resp.getWriter();
		pw.print("<html><body><h1>Address Added</h1></body></html>");

		
	}

}
