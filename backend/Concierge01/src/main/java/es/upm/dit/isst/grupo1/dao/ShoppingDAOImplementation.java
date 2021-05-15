package es.upm.dit.isst.grupo1.dao;




import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.grupo1.model.Shopping;

public class ShoppingDAOImplementation implements ShoppingDAO{

	private static ShoppingDAOImplementation shoppingDAO;
	
	private ShoppingDAOImplementation() {}
	
	public static ShoppingDAOImplementation getInstancia() {
		if(shoppingDAO == null)
			shoppingDAO = new ShoppingDAOImplementation();
		return shoppingDAO;
	}
	
	
	@Override
	public Shopping create(Shopping shopping) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		try {
			session.save(shopping);
			session.getTransaction().commit();
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return shopping;
	}

	@Override
	public Shopping read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		Shopping shopping = null;
		
		shopping = session.get(Shopping.class, id);
		session.getTransaction().commit();
		session.close();
							
		return shopping;
	}

	@Override
	public Shopping update(Shopping shopping) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(shopping);
		session.getTransaction().commit();
		session.close();
		
		return shopping;
	}

	@Override
	public Shopping delete(Shopping shopping) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.delete(shopping);
		session.getTransaction().commit();
		session.close();
		
		return shopping;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shopping> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		List<Shopping> shopping = null;

		String query = "FROM Shopping";
		shopping = session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
	
		return shopping;
	}

	

}