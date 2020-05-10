package services.gestion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gestion.beans.Credit;
import com.gestion.dao.CreditDAO;

public class ServiceEmployeCredit {

	private CreditDAO creditDAO ;
	
	public ServiceEmployeCredit() {
		creditDAO = new CreditDAO();
	}
	
	public void chercherCredit(HttpServletRequest request)
	{
		int idCredit = Integer.parseInt(request.getParameter("idCredit"));	
		Credit credit = creditDAO.findById(idCredit);
		request.setAttribute("credit", credit); 
	}
	
	public void payerTraite(HttpServletRequest request)
	{
		int idCredit = Integer.parseInt(request.getParameter("idCredit"));
		double montant = Double.parseDouble(request.getParameter("montant"));
		creditDAO.payerTraiteDAO(idCredit, montant);
		chercherCredit(request);
	}
	
	public void listeCredit(HttpServletRequest request)
	{
		List<Credit> credits = creditDAO.find();
		request.setAttribute("credits", credits);
	}
	
}
