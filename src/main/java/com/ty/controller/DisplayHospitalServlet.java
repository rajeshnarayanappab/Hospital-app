package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.HospitalDao;
import com.ty.dto.Hospital;

@WebServlet("/displayhospital")
public class DisplayHospitalServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HospitalDao dao = new HospitalDao();
		List<Hospital> hospitals = dao.getAllHospital();
		
		req.setAttribute("myHospital", hospitals);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_hospital.jsp");
		dispatcher.forward(req, resp);
	}
}
