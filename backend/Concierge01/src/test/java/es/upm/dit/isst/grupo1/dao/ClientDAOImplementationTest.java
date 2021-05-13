package es.upm.dit.isst.grupo1.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo1.model.Client;
import es.upm.dit.isst.grupo1.model.Transports;

class ClientDAOImplementationTest {

	@Test
	public void test() {
		ClientDAO clientdao = ClientDAOImplementation.getInstancia();
		
		Client client = new Client();
		
		client.setName("taxi");
		client.setId(2);
		client.setEmail("a@alumnos.upm.es");
		
		
		clientdao.create(client);
		
		Client client2 = clientdao.read(2);
		
		assertEquals(client2.getName(), client.getName());
		assertEquals(client2.getId(), client.getId());
		
		
		client.setEmail("b@alumnos.upm.es");
		clientdao.update(client);
		
		client2 = clientdao.read(2);
		assertNotEquals(client2.getEmail(), "a@alumnos.upm.es");
		
		clientdao.delete(client);
		client2 = clientdao.read(2);
		assertNull(client2);
		
	}
}
