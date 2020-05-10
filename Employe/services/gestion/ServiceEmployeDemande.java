package services.gestion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gestion.beans.DemandeCredit;
import com.gestion.dao.DemandeCreditDAO;

public class ServiceEmployeDemande {
	
	private DemandeCreditDAO demandeDAO;
	
	public ServiceEmployeDemande() {
		demandeDAO = new DemandeCreditDAO();
	}
	
	public void ChercherDemande(HttpServletRequest request)
	{
		int idDemande = Integer.parseInt(request.getParameter("idDemande"));
		DemandeCredit demande = demandeDAO.findById(idDemande);
		System.out.println("LA DEMANDE : "+demande);
		request.setAttribute("demande", demande);		
	}
	
	public void AvancerDemande(HttpServletRequest request)
	{
		int idDemande = Integer.parseInt(request.getParameter("idDemande"));
		String etape = request.getParameter("etape");
		demandeDAO.avancerDemandeDAO(idDemande, etape);
		ChercherDemande(request);
	}
	
	public void listeDemandes(HttpServletRequest request)
	{
		DemandeCreditDAO demandedao = new DemandeCreditDAO();
		List<DemandeCredit> demandes = demandedao.find();
		request.setAttribute("demandes", demandes);
	}
	

}
