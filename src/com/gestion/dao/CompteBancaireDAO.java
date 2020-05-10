package com.gestion.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.gestion.beans.CompteBancaire;

public class CompteBancaireDAO extends DAO<CompteBancaire> {

	private SessionFactory factory;
	private Session session;

	public CompteBancaireDAO() {
		super();

		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CompteBancaire.class)
				.buildSessionFactory();

	}

	@Override
	public boolean add(CompteBancaire a) {
		
		session = factory.openSession();
		try {

			// start transaction
			session.beginTransaction();

			System.out.println("transaction begin!");

			// save the object
			session.save(a);
			System.out.println("save done !");

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("done !!!");
			return true;
		} catch (NoResultException e) {
			e.getMessage();
			return false;
		} finally {
			session.close();
			System.out.println("finnally l3aaaz");
		}
		
	}

	@Override
	public boolean delete(CompteBancaire a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CompteBancaire a) {
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
	public List<CompteBancaire> find() {

		session = factory.openSession();

		List<CompteBancaire> comptes = null;
		try {
			// start session
			session.beginTransaction();

			// selection des données
			Query<CompteBancaire> query = session.createQuery("from CompteBancaire", CompteBancaire.class);

			comptes = query.getResultList();

			return comptes;
		} catch (NoResultException e) {

			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	public CompteBancaire findById(int id)
	{
		CompteBancaire compte = null;
		session = factory.openSession();

		try {
			// lookin for the element
			Query<CompteBancaire> query = session.createQuery("from CompteBancaire where" + " idCompte = :idCompte",
					CompteBancaire.class);
			query.setParameter("idCompte", id);
			System.out.println("Id_proprietaire cherché :" + id);
			compte = query.getSingleResult();
			System.out.println("id est trouvéé !!!");


			return compte;

		} catch (NoResultException e) {
			e.getMessage();
			return null;
		} finally {
			session.close();
		}
	}

	public List<CompteBancaire> findByOwner(int idclient) {
		List<CompteBancaire> comptes = null;
		session = factory.openSession();

		try {
			// lookin for the element
			Query<CompteBancaire> query = session.createQuery("from CompteBancaire where" + " idClient = :idClient",
					CompteBancaire.class);
			query.setParameter("idClient", idclient);
			System.out.println("Id_proprietaire cherché :" + idclient);
			comptes = query.getResultList();
			System.out.println("id est trouvéé !!!");
			// trying to return one element
//			if (comptes.size() == 1) {
//				for (CompteBancaire a : comptes) {
//					compte = a;
//				}
//			} else {
//				System.out.println("I didn't find him");
//			}

			return comptes;

		} catch (NoResultException e) {
			e.getMessage();
			return null;
		} finally {
			session.close();
		}
	}

}
