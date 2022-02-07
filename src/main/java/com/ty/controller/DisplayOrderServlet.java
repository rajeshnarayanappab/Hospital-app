package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.OrderDao;
import com.ty.dto.MedOrder;

@WebServlet("/displaymedorder")
public class DisplayOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	OrderDao dao = new OrderDao();
	List<MedOrder> medorders = dao.getAllOrder();
	
	req.setAttribute("myMedorder", medorders);
	RequestDispatcher dispatcher = req.getRequestDispatcher("display_medorder.jsp");
	dispatcher.forward(req, resp);
	}
}
