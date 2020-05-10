package com.gestion.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.gestion.beans.UsersComptes;

public class UsersDAO extends DAO<UsersComptes> {

	private SessionFactory factory;
	private Session session;

	public UsersDAO() {
		super();

		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UsersComptes.class)
				.buildSessionFactory();
	}

	@Override
	public boolean add(UsersComptes a) {
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
	public boolean delete(UsersComptes a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UsersComptes a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UsersComptes> find() {
		// TODO Auto-generated method stub
		return null;
	}

	public UsersComptes findByLogin_Password(String login, String password) {
		session = factory.openSession();
		UsersComptes user = null;
		try {

			// start transaction
			session.beginTransaction();

			// lookin for the element
			Query<UsersComptes> query = session.createQuery(
					"from UsersComptes where" + " Login = :login AND Password = :password", UsersComptes.class);
			query.setParameter("login", login);
			query.setParameter("password", password);
			List<UsersComptes> users = query.getResultList();
			// trying to return one element
			if (users.size() == 1) 
			{
				for (UsersComptes a : users)
				{
					user=a;
				}
			}else {
				System.out.println("I didn't find him");
			}

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("done !!!");
			return user;

		} catch (NoResultException e) {
			e.getMessage();
			return null;

		} finally {
			session.close();
		}

	}

}
