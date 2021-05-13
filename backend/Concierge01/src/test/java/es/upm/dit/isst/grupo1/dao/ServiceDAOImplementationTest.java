package es.upm.dit.isst.grupo1.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo1.model.Service;
import es.upm.dit.isst.grupo1.model.Transports;

class ServiceDAOImplementationTest {

	@Test
	public void test() {
		ServiceDAO servicedao = ServiceDAOImplementation.getInstancia();
		
		Service service = new Service();
		
		service.setData("Sabanas");
		service.setId(2);
		service.setDisponibilidad(false);
		
		
		servicedao.create(service);
		
		Service service2 = servicedao.read(2);
		
		assertEquals(service2.getData(), service.getData());
		assertEquals(service2.getId(), service.getId());
		
		
		service.setDisponibilidad(true);
		servicedao.update(service);
		
		service2 = servicedao.read(2);
		assertNotEquals(service2.isDisponibilidad(), false);
		
		servicedao.delete(service);
		service2 = servicedao.read(2);
		assertNull(service2);
		
	}
}
