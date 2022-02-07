package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.ItemDao;
import com.ty.dto.Item;

@WebServlet("/displayitem")
public class DisplayItemServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ItemDao dao = new ItemDao();
		List<Item> items = dao.getAllItem();
		
		req.setAttribute("myItem", items);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_item.jsp");
		dispatcher.forward(req, resp);
	}
}
