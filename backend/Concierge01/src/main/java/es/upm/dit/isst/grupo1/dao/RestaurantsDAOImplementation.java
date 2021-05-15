package es.upm.dit.isst.grupo1.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.grupo1.model.Restaurants;

public class RestaurantsDAOImplementation implements RestaurantsDAO{

	private static RestaurantsDAOImplementation restaurantDAO;
	
	private RestaurantsDAOImplementation() {}
	
	public static RestaurantsDAOImplementation getInstancia() {
		if(restaurantDAO == null)
			restaurantDAO = new RestaurantsDAOImplementation();
		return restaurantDAO;
	}
	
	
	@Override
	public Restaurants create(Restaurants restaurant) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		try {
			session.save(restaurant);
			session.getTransaction().commit();
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return restaurant;
	}

	@Override
	public Restaurants read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		Restaurants restaurant = null;
		
		restaurant = session.get(Restaurants.class, id);
		session.getTransaction().commit();
		session.close();
							
		return restaurant;
	}

	@Override
	public Restaurants update(Restaurants restaurant) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(restaurant);
		session.getTransaction().commit();
		session.close();
		
		return restaurant;
	}

	@Override
	public Restaurants delete(Restaurants restaurant) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.delete(restaurant);
		session.getTransaction().commit();
		session.close();
		
		return restaurant;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurants> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		List<Restaurants> restaurant = null;

		String query = "FROM Restaurants";
		restaurant = session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
	
		return restaurant;
	}

	

}
