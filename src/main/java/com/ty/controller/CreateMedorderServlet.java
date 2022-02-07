package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.OrderDao;
import com.ty.dto.MedOrder;

@WebServlet("/createmedorder")
public class CreateMedorderServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {HttpSession httpSession=req.getSession();
//Integer branchId=(Integer)httpSession.getAttribute("branchid");
String name=(String)httpSession.getAttribute("name");
String msg = req.getParameter("msg");

String dateTime= req.getParameter("localDateTime");
LocalDateTime localDateTime=LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);

MedOrder medOrder=new MedOrder();
medOrder.setMsg(msg);
medOrder.setCreatedDateTime(localDateTime);
medOrder.setCreatorName(name);

int encounterid=Integer.parseInt(req.getParameter("encounterid"));

OrderDao dao=new OrderDao();
dao.createMedOrder(encounterid, medOrder);
}
}
