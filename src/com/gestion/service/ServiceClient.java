package com.gestion.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gestion.beans.Client;
import com.gestion.beans.CompteBancaire;
import com.gestion.beans.DemandeCredit;
import com.gestion.dao.CompteBancaireDAO;
import com.gestion.dao.DemandeCreditDAO;

public class ServiceClient {
	
	private  Client client;
	private  HttpSession session;
	
	public ServiceClient(HttpServletRequest request, HttpServletResponse response)
	{
		session = request.getSession();
		System.out.println("Session Id : "+session.getId());
		client = (Client) session.getAttribute("client");
	}


	public  void mesComptes()
	{
		CompteBancaireDAO compteDAO = new CompteBancaireDAO();
		//retrouver la liste des comptes
		List<CompteBancaire> mescomptes = compteDAO.findByOwner(client.getIdClient());
		session.setAttribute("nbrComptes", mescomptes.size());
		session.setAttribute("mescomptes", mescomptes);
	}
	
	public static void HistoriqueCompte()
	{
//		System.out.println("Session Id : "+session.getId());
		
		
		

	}
	
	public  void mesDemandes()
	{
		System.out.println("Session Id : "+session.getId());
		
		DemandeCreditDAO demandesDAO = new DemandeCreditDAO();
		List<DemandeCredit> demandes = demandesDAO.findByIdClient(client.getIdClient());
		session.setAttribute("mesdemandes", demandes);
		
	}
	
	public  void EffectuerDemande(HttpServletRequest request, HttpServletResponse response)
	{
//		double montant = Double.valueOf( request.getParameter("montant"));
		
	}
	
	
	public static void mesCredit(HttpServletRequest request, HttpServletResponse response)
	{
		
		
	}
	
	public static void effectuerVirement(double montant, double numCompte)
	{
		
	}
	
}
