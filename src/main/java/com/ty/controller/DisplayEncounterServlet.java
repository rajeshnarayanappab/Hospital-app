package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.EncounterDao;
import com.ty.dto.Encounter;

@WebServlet("/displayencounter")
public class DisplayEncounterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		EncounterDao dao = new EncounterDao();
		List<Encounter> encounters = dao.getAllEncounter();
		
		req.setAttribute("myEncounter", encounters);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_encounter.jsp");
		dispatcher.forward(req, resp);
	}
}
