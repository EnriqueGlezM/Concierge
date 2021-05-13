package es.upm.dit.isst.grupo1.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo1.model.Shopping;
import es.upm.dit.isst.grupo1.model.Transports;

class ShoppingDAOImplementationTest {

	@Test
	public void test() {
		ShoppingDAO shoppingdao = ShoppingDAOImplementation.getInstancia();
		
		Shopping shopping = new Shopping();
		
		shopping.setName("Bottela de agua");
		shopping.setId(2);
		shopping.setCategory("Bebida");
		
		
		shoppingdao.create(shopping);
		
		Shopping shopping2 = shoppingdao.read(2);
		
		assertEquals(shopping2.getName(), shopping.getName());
		assertEquals(shopping2.getId(), shopping.getId());
		
		
		shopping.setCategory("Comida");
		shoppingdao.update(shopping);
		
		shopping2 = shoppingdao.read(2);
		assertNotEquals(shopping2.getCategory(), "Bebida");
		
		shoppingdao.delete(shopping);
		shopping2 = shoppingdao.read(2);
		assertNull(shopping2);
		
	}

}
