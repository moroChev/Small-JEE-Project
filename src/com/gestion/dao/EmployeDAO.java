package com.gestion.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.gestion.beans.Employe;

public class EmployeDAO extends DAO<Employe> {

	private SessionFactory factory;
	private Session session;
	
	 public EmployeDAO() {
		 super();

			factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employe.class)
					.buildSessionFactory();
	}
	
	@Override
	public boolean add(Employe a) {
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
	public boolean delete(Employe a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Employe a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employe> find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Employe findById(int id)
	{
		session = factory.openSession();
		Employe employe = null;
		try {
			// lookin for the element
			Query<Employe> query = session.createQuery("from Employe where" + " id_employe = :id_employe", Employe.class);
			query.setParameter("id_employe", id);
			System.out.println("id_user cherché :"+id);
			employe =  query.getSingleResult();
			System.out.println("id est trouvéé !!!");
			return employe;
		} catch (NoResultException e) {
			e.getMessage();
			return null;
		} finally {
			session.close();
		}
		
	}
	
	public Employe findByIdUser(int id)
	{
		session = factory.openSession();
		Employe employe = null;
		try {
			// lookin for the element
			Query<Employe> query = session.createQuery("from Employe where" + " id_user = :id_user", Employe.class);
			query.setParameter("id_user", id);
			System.out.println("id_user cherché :"+id);
			employe =  query.getSingleResult();
			System.out.println("id est trouvéé !!!");
			return employe;
		} catch (NoResultException e) {
			e.getMessage();
			return null;
		} finally {
			session.close();
		}
	}

}
