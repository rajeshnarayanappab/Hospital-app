package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.HospitalDao;
import com.ty.dto.Hospital;

@WebServlet("/createhospital")
public class CreateHospitalServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Hospital hosp=new Hospital();		
		String name = req.getParameter("name");
		String website = req.getParameter("website");
		String gst = req.getParameter("gst");

		hosp.setName(name);
		hosp.setWebsite(website);
		hosp.setGst(gst);

		HospitalDao hospitalDao=new HospitalDao();
		hospitalDao.saveHospital(hosp);
		
		PrintWriter pw =resp.getWriter();
		pw.print("<html><body><h1>Hospital Added</h1></body></html>");
}
}
