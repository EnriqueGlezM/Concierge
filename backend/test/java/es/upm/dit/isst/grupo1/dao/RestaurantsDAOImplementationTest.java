package es.upm.dit.isst.grupo1.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo1.model.Restaurants;

class RestaurantsDAOImplementationTest {

	@Test
	public void test() {
		RestaurantsDAO restaurantdao = RestaurantsDAOImplementation.getInstancia();
		
		Restaurants restaurant = new Restaurants();
		
		restaurant.setName("Restaurante Luigi");
		restaurant.setId(2);
		restaurant.setDescription("Comida Italina");
		
		
		restaurantdao.create(restaurant);
		
		Restaurants restaurant2 = restaurantdao.read(2);
		
		assertEquals(restaurant2.getName(), restaurant.getName());
		assertEquals(restaurant2.getId(), restaurant.getId());
		
		
		restaurant.setDescription("Comida Mexicana");
		restaurantdao.update(restaurant);
		
		restaurant2 = restaurantdao.read(2);
		assertNotEquals(restaurant2.getDescription(), "Comida Italina");
		
		restaurantdao.delete(restaurant);
		restaurant2 = restaurantdao.read(2);
		assertNull(restaurant2);
		
	}
}
