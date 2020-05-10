package services.gestion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestion.beans.Client;
import com.gestion.beans.UsersComptes;
import com.gestion.dao.ClientDAO;

public class ServiceEmployeClient {
	
	private ClientDAO clientdao;
	
	public ServiceEmployeClient()
	{
		clientdao = new ClientDAO();
	}
	
	public void listeClients(HttpServletRequest request, HttpServletResponse response)
	{
		List<Client> clients = clientdao.find();
		for(Client client : clients)
		{
			System.out.println(client);
		}
		request.setAttribute("clients", clients);
	}
	
	public void creerClient(HttpServletRequest request, HttpServletResponse response)
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
		//l'ajout du client dans la base 
		clientdao.add(client);
		System.out.println("Client Added with success");
	}
	
	
	
	
	

}
