package com.gestion.controllers.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoClient
 */
@WebServlet("/InfoClient")
public class MonProfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MonProfilController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		getServletContext().getRequestDispatcher("/WEB-INF/ClientPages/ClientInfos.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
