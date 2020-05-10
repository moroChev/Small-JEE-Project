package services.gestion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestion.beans.Client;
import com.gestion.beans.CompteBancaire;
import com.gestion.beans.UsersComptes;
import com.gestion.dao.ClientDAO;
import com.gestion.dao.CompteBancaireDAO;

public class ServiceEmployeCompte {
	
	private CompteBancaireDAO comptedao;
	
	public ServiceEmployeCompte() {
		comptedao = new CompteBancaireDAO();
	}
	
	public void chercherClient(HttpServletRequest request)
	{
		int idclient = Integer.parseInt(request.getParameter("idClient"));
		ClientDAO clientDAO = new ClientDAO();
		System.out.println("En train de chercher le client ...");
		Client client = clientDAO.findById(idclient);
		System.out.println("CLient trouvé ... :"+client);
		request.setAttribute("client", client);
	}
	
	public void chercherCompte(HttpServletRequest request)
	{
		int idCompte = Integer.parseInt(request.getParameter("idCompte"));
		CompteBancaire compte = comptedao.findById(idCompte);
		request.setAttribute("compte", compte);
	}
	
	
	public void CompteNouveauClient(HttpServletRequest request, HttpServletResponse response)
	{
		
		
		//Creation d'user account
				String login = request.getParameter("Login");
				String password = request.getParameter("Password");
				UsersComptes user = new UsersComptes(login,password,"1");
				
		//Creation du client
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String dateNaissance = request.getParameter("dateNaissance");
				String telephone = request.getParameter("telephone");
				String email = request.getParameter("email");
				int idAgence = Integer.parseInt(request.getParameter("idAgence"));	
				Client client = new Client(nom,prenom,dateNaissance,telephone,email,idAgence);
				client.setUserComptes(user);
				client.setIdAgence(idAgence);
				
		//Creation du compte bancaire		
				double solde = Double.parseDouble(request.getParameter("solde"));
				String libelle = request.getParameter("libelle");
				CompteBancaire compte = new CompteBancaire(solde,libelle);
				compte.setClient(client);
				
		// l'ajout du compte en Database		
				comptedao.add(compte);
				System.out.println("un compte a ete crée");
	}
	
	public void CompteAncienClient(HttpServletRequest request, HttpServletResponse response)
	{
		ClientDAO clientdao = new ClientDAO();
		int idClient = Integer.parseInt(request.getParameter("idClient"));
		Client client = clientdao.findById(idClient);
		
		//Creation du compte bancaire		
		double solde = Double.parseDouble(request.getParameter("solde"));
		String libelle = request.getParameter("libelle");
		CompteBancaire compte = new CompteBancaire(solde,libelle);
		compte.setClient(client);
		
        // l'ajout du compte en Database		
		comptedao.add(compte);
		System.out.println("un compte a ete crée");
	}
	
	public void depot(HttpServletRequest request)
	{
		int idCompte = Integer.parseInt(request.getParameter("idCompte"));
		CompteBancaire compte = comptedao.findById(idCompte);
		double montantAjouter = Double.parseDouble(request.getParameter("montant"));
		double soldeActuel = compte.getSolde();
		compte.setSolde(soldeActuel+montantAjouter);
		comptedao.update(compte);
		chercherCompte(request);
	}
	

}
