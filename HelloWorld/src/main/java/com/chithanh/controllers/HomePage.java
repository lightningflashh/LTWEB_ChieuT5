package com.chithanh.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/trangchu"})
public class HomePage extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String ten = req.getParameter("ten");
		String holot = req.getParameter("holot");
		
		req.setAttribute("fname", ten);
		req.setAttribute("lname", holot);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
        rd.forward(req, resp);

//		PrintWriter writer = resp.getWriter();
//
//		writer.println("<b>First Name</b>: " + ten + "<br/><b>Last Name</b>:" + holot);

//		writer.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}

