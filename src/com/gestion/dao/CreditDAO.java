package com.gestion.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.gestion.beans.Credit;

public class CreditDAO extends DAO<Credit>{

	private SessionFactory factory;
	private Session session;

	public CreditDAO() {
		super();

		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Credit.class)
				.buildSessionFactory();

	}

	public boolean add(Credit a) {

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
			System.out.println("finnally l3aaaz");
		}
	}
	
	


	@Override
	public boolean delete(Credit a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Credit a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Credit> find() {
		
		session = factory.openSession();
		List<Credit> credits = null;
		try {
			// start session
			session.beginTransaction();

			// selection des données
			Query<Credit> query = session.createQuery("from Credit", Credit.class);

			credits = query.getResultList();

			return credits;
		} catch (NoResultException e) {

			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
		
	}
	
	public Credit findById(int id)
	{
		Credit credit = null;
		session = factory.openSession();

		try {
			// start session
			session.beginTransaction();

			// selection des données
			credit = session.get(Credit.class, id);

			return credit;
		} catch (NoResultException e) {

			e.printStackTrace();
			return null;
		} finally {
			session.close();

		}
	}

	public boolean payerTraiteDAO(int idcredit, double montant)
	{
		Credit credit = null;
		session = factory.openSession();
		try {
			// start session
			session.beginTransaction();
			// selection des données
			credit = session.get(Credit.class, idcredit);
			
			double mnt = credit.getMontantRestant()-montant;
			
			double montantrestant = mnt >= 0 ? mnt : 0;
			credit.setMontantRestant(montantrestant);
			session.update(credit);
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
