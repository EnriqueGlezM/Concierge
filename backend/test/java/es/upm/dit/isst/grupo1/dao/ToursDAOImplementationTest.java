package es.upm.dit.isst.grupo1.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo1.model.Tours;
import es.upm.dit.isst.grupo1.model.Transports;

class ToursDAOImplementationTest {

	@Test
	public void test() {
		ToursDAO toursdao = ToursDAOImplementation.getInstancia();
		
		Tours tours = new Tours();
		
		tours.setName("ciudad");
		tours.setId(2);
		tours.setDescription("Es New York");
		
		
		toursdao.create(tours);
		
		Tours tours2 = toursdao.read(2);
		
		assertEquals(tours2.getName(), tours.getName());
		assertEquals(tours2.getId(), tours.getId());
		
		
		tours.setDescription("Es Madrid");
		toursdao.update(tours);
		
		tours2 = toursdao.read(2);
		assertNotEquals(tours2.getDescription(), "Es New York");
		
		toursdao.delete(tours);
		tours2 = toursdao.read(2);
		assertNull(tours2);
		
	}

}
