package es.upm.dit.isst.grupo1.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo1.model.Shows;

class ShowsDAOImplementationTest {

	@Test
	public void test() {
		ShowsDAO showsdao = ShowsDAOImplementation.getInstancia();
		
		Shows shows = new Shows();
		
		shows.setName("teatro");
		shows.setId(2);
		shows.setDescription("El rey León");
		
		
		showsdao.create(shows);
		
		Shows shows2 = showsdao.read(2);
		
		assertEquals(shows2.getName(), shows.getName());
		assertEquals(shows2.getId(), shows.getId());
		
		
		shows.setDescription("Hammlet");
		showsdao.update(shows);
		
		shows2 = showsdao.read(2);
		assertNotEquals(shows2.getDescription(), "El rey León");
		
		showsdao.delete(shows);
		shows2 = showsdao.read(2);
		assertNull(shows2);
		
	}
}
