package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.PersonDao;
import com.ty.dto.Person;

@WebServlet("/display")
public class DisplayPersonServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		PersonDao dao = new PersonDao();
		List<Person> persons = dao.getAllPerson();
		
		req.setAttribute("myPerson", persons);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_person.jsp");
		dispatcher.forward(req, resp);
	}
}
