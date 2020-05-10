package com.gestion.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gestion.beans.Client;
import com.gestion.beans.Employe;
import com.gestion.beans.UsersComptes;
import com.gestion.dao.ClientDAO;
import com.gestion.dao.EmployeDAO;
import com.gestion.dao.UsersDAO;

public class ServiceAuthentification {

	public static UsersComptes CheckingTheExistantce(HttpServletRequest request) {
		String login = request.getParameter("Login");
		String password = request.getParameter("Password");

		UsersDAO userDAO = new UsersDAO();
		UsersComptes user = userDAO.findByLogin_Password(login, password); 
		System.out.println(user);
		return user;

	}

	public static void CreateClientSession(HttpServletRequest request, UsersComptes user) {
	
		HttpSession session = request.getSession();

		ClientDAO clientdao = new ClientDAO();
		Client client = clientdao.findByIdUser(user.getId_user());
		System.out.println("creation de la session : "+client);
		session.setAttribute("role", user.getId_user());
		session.setAttribute("client", client);
		
		System.out.println("Session Id : "+session.getId());

	}
	
	public static void CreateEmployeSession(HttpServletRequest request, UsersComptes user)
	{
		HttpSession session = request.getSession();

		EmployeDAO employeDAO = new EmployeDAO();
		Employe employe = employeDAO.findByIdUser(user.getId_user());
		session.setAttribute("role", user.getId_user());
		session.setAttribute("employe", employe);
		System.out.println("Session Id : "+session.getId());

		System.out.println("Employee ... : "+employe);
	}
	
	public static void CreateAdminSession(HttpServletRequest request, UsersComptes user)
	{
		
	}
	

}
