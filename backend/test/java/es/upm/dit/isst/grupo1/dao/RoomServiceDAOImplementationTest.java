package es.upm.dit.isst.grupo1.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo1.model.RoomService;
import es.upm.dit.isst.grupo1.model.Transports;

class RoomServiceDAOImplementationTest {

	@Test
	public void test() {
		RoomServiceDAO roomservicedao = RoomServiceDAOImplementation.getInstancia();
		
		RoomService roomservice = new RoomService();
		
		roomservice.setName("Limpieza");
		roomservice.setId(2);
		roomservice.setDescription("LIMPIEZA DEL BAÑO ANTES DE INGRESAR EN LA HABITACIÓN");
		
		
		roomservicedao.create(roomservice);
		
		RoomService roomservice2 = roomservicedao.read(2);
		
		assertEquals(roomservice2.getName(), roomservice.getName());
		assertEquals(roomservice2.getId(), roomservice.getId());
		
		
		roomservice.setDescription("CAMBIO DE SABANAS");
		roomservicedao.update(roomservice);
		
		roomservice2 = roomservicedao.read(2);
		assertNotEquals(roomservice2.getDescription(), "LIMPIEZA DEL BAÑO ANTES DE INGRESAR EN LA HABITACIÓN");
		
		roomservicedao.delete(roomservice);
		roomservice2 = roomservicedao.read(2);
		assertNull(roomservice2);
		
	}
}
