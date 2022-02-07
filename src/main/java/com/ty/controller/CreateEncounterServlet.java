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

import com.ty.dao.EncounterDao;
import com.ty.dto.Encounter;

@WebServlet("/createencounter")
public class CreateEncounterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession=req.getSession();
		int branchId=(Integer)httpSession.getAttribute("branchId");
		String name=(String)httpSession.getAttribute("name");
		String reason = req.getParameter("reason");
		
		String dateTime= req.getParameter("localDateTime");
		LocalDateTime localDateTime=LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
		
		Encounter encounter=new Encounter();
		encounter.setReason(reason);
		encounter.setCreatedDateTime(localDateTime);
		encounter.setCreatorName(name);
		
		int personId=Integer.parseInt(req.getParameter("personId"));
		EncounterDao dao=new EncounterDao();
		dao.createEncounter(personId, branchId, encounter);
	}
}
