package es.upm.dit.isst.grupo1.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo1.model.Transports;

class TransportsDAOImplementationTest {

	@Test
	public void test() {
		TransportsDAO transportsdao = TransportsDAOImplementation.getInstancia();
		
		Transports transports = new Transports();
		
		transports.setName("taxi");
		transports.setId(2);
		transports.setDescription("Es un taxi");
		
		
		transportsdao.create(transports);
		
		Transports transports2 = transportsdao.read(2);
		
		assertEquals(transports2.getName(), transports.getName());
		assertEquals(transports2.getId(), transports.getId());
		
		
		transports.setDescription("Es un autobus");
		transportsdao.update(transports);
		
		transports2 = transportsdao.read(2);
		assertNotEquals(transports2.getDescription(), "Es un taxi");
		
		transportsdao.delete(transports);
		transports2 = transportsdao.read(2);
		assertNull(transports2);
		
	}

}
