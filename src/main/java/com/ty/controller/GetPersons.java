
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

@WebServlet("/getpersons")
public class GetPersons extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		PersonDao dao=new PersonDao();
	List<Person> person=dao.getAllPerson();
		
		req.setAttribute("myPerson", person);
		
	RequestDispatcher dispatcher=req.getRequestDispatcher("dispaly_person.jsp");
dispatcher.forward(req, resp);
	}
}
