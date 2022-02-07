package com.ty.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.ItemDao;
import com.ty.dto.Item;

@WebServlet("/createitem")
public class CreateItemServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession=req.getSession();
//		Integer branchId=(Integer)httpSession.getAttribute("branchid");
		String name=(String)httpSession.getAttribute("name");
		String msg = req.getParameter("msg");
		String qty=req.getParameter("qty");
		String cost=req.getParameter("cost");
		
//		String dateTime= req.getParameter("localDateTime");
//		LocalDateTime localDateTime=LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);

		Item item=new Item();
		item.setMsg(msg);
		item.setCost(Double.parseDouble(cost));
		item.setName(name);
	    
		item.setQty(Integer.parseInt(qty));
		
		int orderid=Integer.parseInt(req.getParameter("orderid"));
		
		ItemDao dao=new ItemDao();
		dao.createItem(orderid, item);
	}
}
