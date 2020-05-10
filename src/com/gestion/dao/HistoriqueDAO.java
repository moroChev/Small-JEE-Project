package com.gestion.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gestion.beans.Historique;

public class HistoriqueDAO extends DAO<Historique> {

	private SessionFactory factory;
	private Session session;

	public HistoriqueDAO() {
		super();

		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Historique.class)
				.buildSessionFactory();

	}
	
	@Override
	public boolean add(Historique a) {
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
	public boolean delete(Historique a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Historique a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Historique> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
