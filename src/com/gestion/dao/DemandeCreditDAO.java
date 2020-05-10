package com.gestion.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.gestion.beans.DemandeCredit;

public class DemandeCreditDAO extends DAO<DemandeCredit>{
	
	private SessionFactory factory;
	private Session session;
	
	public DemandeCreditDAO()
	{ super();

		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(DemandeCredit.class)
				.buildSessionFactory();
	}


	
	@Override
	public boolean add(DemandeCredit a) {
		session = factory.openSession();
		try {

			// start transaction
			session.beginTransaction();

			// save the object
			session.save(a);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("done !!!");
			return true;

		} catch (NoResultException e) {
			e.getMessage();
			return false;

		} finally {
			session.close();
		}
	}

	@Override
	public boolean delete(DemandeCredit a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DemandeCredit a) {
		session = factory.openSession();		
		try {
		session.beginTransaction();
		session.update(a);
		session.getTransaction().commit();
			return true;
		}catch(NoResultException e)
		{
			e.getMessage();
			return false;
		}finally {
			session.close();
		}
	}

	@Override
	public List<DemandeCredit> find() {
		List<DemandeCredit> demandes = null;
		session = factory.openSession();

		try {
			// lookin for the element
			Query<DemandeCredit> query = session.createQuery("from DemandeCredit",DemandeCredit.class);
			
			demandes = query.getResultList();
			System.out.println("id est trouvéé !!!");
		

			return demandes;

		} catch (NoResultException e) {
			e.getMessage();
			return null;
		} finally {
			session.close();
		}
	}
	
	public DemandeCredit findById(int id)
	{
		session = factory.openSession();
		try {
			session.beginTransaction();
			DemandeCredit demande = session.get(DemandeCredit.class, id);
			return demande;	
		}catch(NoResultException e)
		{
			e.getMessage();
			return null;
		}finally {
			session.close();
		}
	}

	public List<DemandeCredit> findByIdClient(int id)
	{
		List<DemandeCredit> demandes = null;
		session = factory.openSession();

		try {
			// lookin for the element
			Query<DemandeCredit> query = session.createQuery("from DemandeCredit where" + " idClient = :idClient",
					DemandeCredit.class);
			query.setParameter("idClient", id);
			System.out.println("Id_proprietaire cherché :" + id);
			demandes = query.getResultList();
			System.out.println("id est trouvéé !!!");
		

			return demandes;

		} catch (NoResultException e) {
			e.getMessage();
			return null;
		} finally {
			session.close();
		}
	}
	
	
	public boolean avancerDemandeDAO(int idDemande, String etape)
	{
		DemandeCredit demande = null;
		session = factory.openSession();
		try {
			// start session
			session.beginTransaction();
			// selection des données
			demande = session.get(DemandeCredit.class, idDemande);			
			demande.setEtatDemande(etape);
			session.update(demande);
			session.getTransaction().commit();
			return true;
		} catch (NoResultException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();

		}
	}
}
