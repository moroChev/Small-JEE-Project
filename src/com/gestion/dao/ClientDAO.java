package com.gestion.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.gestion.beans.Client;

public class ClientDAO extends DAO<Client> {

	private SessionFactory factory;
	private Session session;

	public ClientDAO() {
		super();

		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
				.buildSessionFactory();

	}

	public boolean add(Client a) {
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
	
	
	public int addReturnId(Client a) {

		session = factory.openSession();
		try {

			// start transaction
			session.beginTransaction();

			// save the object
			int id = (int)session.save(a);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("done !!!");
			return id;
		} catch (NoResultException e) {
			e.getMessage();
			return 0;
		} finally {
			session.close();
			System.out.println("finnally l3aaaz");
		}
	}

	@Override
	public boolean delete(Client a) {

		return false;
	}

	@Override
	// à corriger !! Faux
	public boolean update(Client a) {

		session = factory.openSession();

		try {
			// start transaction
			session.beginTransaction();

			// trouver le client en question
			Client client = session.get(Client.class, a.getIdClient());

			// appliquer les nouvelles mises-à-jours
			client.setNom(a.getNom());
			client.setPrenom(a.getPrenom());
			client.setDateNaissance(a.getDateNaissance());
			client.setEmail(a.getEmail());
			client.setTelephone(a.getTelephone());
			client.setIdAgence(a.getIdAgence());
			
			session.update(client);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("done !!!");

			return true;
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Client> find() {

		session = factory.openSession();

		List<Client> clients = null;
		try {
			// start session
			session.beginTransaction();

			// selection des données
			Query<Client> query = session.createQuery("from Client", Client.class);

			clients = query.getResultList();

			return clients;
		} catch (NoResultException e) {

			e.printStackTrace();
			return null;
		} finally {
			session.close();

		}
	}

	public Client findById(int id) {
		
		session = factory.openSession();

		Client client = null;
		try {
			// start session
			session.beginTransaction();

			// selection des données
			client = session.get(Client.class, id);

			return client;
		} catch (NoResultException e) {

			e.printStackTrace();
			return null;
		} finally {
			session.close();

		}
	}

	public Client findByIdUser(int id) {	
		
		session = factory.openSession();
		
		Client client = null;
		
		try {
			// lookin for the element
			Query<Client> query = session.createQuery("from Client WHERE" + " Id_user =: Id_user", Client.class);
			query.setParameter("Id_user", id);
			
			System.out.println("id_user cherché :"+id);
			client = query.getSingleResult();
			System.out.println("id est trouvéé !!!");
			// trying to return one element

			return client;
		} catch (NoResultException e) {
			e.getMessage();
			return null;
		} finally {
			session.close();
		}
	 }



}
