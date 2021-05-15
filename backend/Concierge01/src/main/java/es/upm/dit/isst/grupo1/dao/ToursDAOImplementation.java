package es.upm.dit.isst.grupo1.dao;



import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.grupo1.model.Tours;

public class ToursDAOImplementation implements ToursDAO{

	private static ToursDAOImplementation toursDAO;
	
	private ToursDAOImplementation() {}
	
	public static ToursDAOImplementation getInstancia() {
		if(toursDAO == null)
			toursDAO = new ToursDAOImplementation();
		return toursDAO;
	}
	
	
	@Override
	public Tours create(Tours tours) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		try {
			session.save(tours);
			session.getTransaction().commit();
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return tours;
	}

	@Override
	public Tours read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		Tours tours = null;
		
		tours = session.get(Tours.class, id);
		session.getTransaction().commit();
		session.close();
							
		return tours;
	}

	@Override
	public Tours update(Tours tours) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(tours);
		session.getTransaction().commit();
		session.close();
		
		return tours;
	}

	@Override
	public Tours delete(Tours tours) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.delete(tours);
		session.getTransaction().commit();
		session.close();
		
		return tours;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tours> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		List<Tours> tours = null;

		String query = "FROM Tours";
		tours = session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
	
		return tours;
	}

	

}