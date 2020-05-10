package com.gestion.authentification;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestion.beans.UsersComptes;
import com.gestion.service.ServiceAuthentification;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(
				"Les données envoyé : " + request.getParameter("Login") + " " + request.getParameter("Password"));

		UsersComptes user = ServiceAuthentification.CheckingTheExistantce(request);
		System.out.println("Auth : "+user);
		if (user != null) {
			System.out.println("Auth 2 : "+user);
			if (user.getRole().equals("1")) {
				System.out.println("l'user est un Client");
				ServiceAuthentification.CreateClientSession(request, user);
				getServletContext().getRequestDispatcher("/ClientPages/AcceuilClient.jsp").forward(request,response);
			} else if (user.getRole().equals("2")) {
				System.out.println("l'user est un employe");
				ServiceAuthentification.CreateEmployeSession(request, user);
				getServletContext().getRequestDispatcher("/EmployePages/AcceuilEmploye.jsp").forward(request,response);
			}
		} else {
			
			getServletContext().getRequestDispatcher("/ErrorLog.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
