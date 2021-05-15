package es.upm.dit.isst.grupo1.dao;



import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.grupo1.model.RoomService;

public class RoomServiceDAOImplementation implements RoomServiceDAO{

	private static RoomServiceDAOImplementation roomServiceDAO;
	
	private RoomServiceDAOImplementation() {}
	
	public static RoomServiceDAOImplementation getInstancia() {
		if(roomServiceDAO == null)
			roomServiceDAO = new RoomServiceDAOImplementation();
		return roomServiceDAO;
	}
	
	
	@Override
	public RoomService create(RoomService roomService) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		try {
			session.save(roomService);
			session.getTransaction().commit();
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return roomService;
	}

	@Override
	public RoomService read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		RoomService roomService = null;
		
		roomService = session.get(RoomService.class, id);
		session.getTransaction().commit();
		session.close();
							
		return roomService;
	}

	@Override
	public RoomService update(RoomService roomService) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(roomService);
		session.getTransaction().commit();
		session.close();
		
		return roomService;
	}

	@Override
	public RoomService delete(RoomService roomService) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		session.delete(roomService);
		session.getTransaction().commit();
		session.close();
		
		return roomService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoomService> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		List<RoomService> roomService = null;

		String query = "FROM RoomService";
		roomService = session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
	
		return roomService;
	}

	

}
