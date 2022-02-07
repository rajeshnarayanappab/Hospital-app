package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.PersonDao;
import com.ty.dto.Person;

@WebServlet("/createperson")
public class CreatePersonServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Person person=new Person();
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String cno = req.getParameter("cno");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");

		person.setName(name);
		person.setEmail(email);
		person.setGender(gender);
		person.setCno(Long.parseLong(cno));
		person.setAge(Integer.parseInt(age));
		
		PersonDao dao=new PersonDao();
		dao.savePerson(person);
		
		PrintWriter pw =resp.getWriter();
		pw.print("<html><body><h1>Person Added</h1></body></html>");
	}
}
