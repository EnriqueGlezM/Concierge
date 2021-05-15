package es.upm.dit.isst.grupo1.dao;



import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.grupo1.model.Transports;

public class TransportsDAOImplementation implements TransportsDAO{

	private static TransportsDAOImplementation transportsDAO;
	
	private TransportsDAOImplementation() {}
	
	public static TransportsDAOImplementation getInstancia() {
		if(transportsDAO == null)
			transportsDAO = new TransportsDAOImplementation();
		return transportsDAO;
	}
	
	
	@Override
	public Transports create(Transports transports) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		try {
			session.save(transports);
			session.getTransaction().commit();
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return transports;
	}

	@Override
	public Transports read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		Transports transports = null;
		
		transports = session.get(Transports.class, id);
		session.getTransaction().commit();
		session.close();
							
		return transports;
	}

	@Override
	public Transports update(Transports transports) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(transports);
		session.getTransaction().commit();
		session.close();
		
		return transports;
	}

	@Override
	public Transports delete(Transports transports) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.delete(transports);
		session.getTransaction().commit();
		session.close();
		
		return transports;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transports> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		List<Transports> transports = null;

		String query = "FROM Transports";
		transports = session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
	
		return transports;
	}

	

}