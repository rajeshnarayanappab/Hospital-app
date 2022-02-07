package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.AddressDao;
import com.ty.dto.Address;
@WebServlet("/displayaddress")
public class DisplayAddressServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AddressDao dao = new AddressDao();
		List<Address> addresses = dao.getAllAddresses();
		
		req.setAttribute("myAddress", addresses);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_address.jsp");
		dispatcher.forward(req, resp);
	}

}
