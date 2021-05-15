package es.upm.dit.isst.grupo1.dao;



import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.grupo1.model.Shows;

public class ShowsDAOImplementation implements ShowsDAO{

	private static ShowsDAOImplementation showsDAO;
	
	private ShowsDAOImplementation() {}
	
	public static ShowsDAOImplementation getInstancia() {
		if(showsDAO == null)
			showsDAO = new ShowsDAOImplementation();
		return showsDAO;
	}
	
	
	@Override
	public Shows create(Shows shows) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		try {
			session.save(shows);
			session.getTransaction().commit();
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return shows;
	}

	@Override
	public Shows read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		Shows shows = null;
		
		shows = session.get(Shows.class, id);
		session.getTransaction().commit();
		session.close();
							
		return shows;
	}

	@Override
	public Shows update(Shows shows) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(shows);
		session.getTransaction().commit();
		session.close();
		
		return shows;
	}

	@Override
	public Shows delete(Shows shows) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.delete(shows);
		session.getTransaction().commit();
		session.close();
		
		return shows;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shows> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		List<Shows> shows = null;

		String query = "FROM Shows";
		shows = session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
	
		return shows;
	}

	

}