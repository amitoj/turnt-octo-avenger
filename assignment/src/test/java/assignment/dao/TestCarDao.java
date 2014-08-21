package assignment.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import assignment.model.Car;

public class TestCarDao {

	CarDao carDao;
	
	@Before
	public void init() {
		carDao = new CarDaoImpl();
		((CarDaoImpl)carDao).init();
	}
	
	@Test
	public void testCreateCar() {
		Car car = new Car(1, "BMW", "3-Series", 2005, "2005-06-23");
		carDao.createCar(car);
		assertEquals(1, carDao.getCars().size());
	}

	@Test
	public void testCreateMultitpleCars() {
		Car car1 = new Car(1, "BMW", "3-Series", 2005, "2005-06-23");
		Car car2 = new Car(2, "Ford", "Focus", 2005, "2005-06-23");
		carDao.createCar(car1);
		carDao.createCar(car2);
		assertEquals(2, carDao.getCars().size());
	}
	
	@Test
	public void testRemoveCar() {
		Car car1 = new Car(1, "BMW", "3-Series", 2005, "2005-06-23");
		Car car2 = new Car(2, "Ford", "Focus", 2005, "2005-06-23");
		carDao.createCar(car1);
		carDao.createCar(car2);
		
		carDao.removeCar(1);
		
		assertEquals(1, carDao.getCars().size());
		assertEquals(2, carDao.getCars().get(0).getId());
	}
	
	@Test
	public void testUpdateCar() {
		Car car = new Car(1, "BMW", "3-Series", 2005, "2005-06-23");
		carDao.createCar(car);
		car.setModel("5-Series");
		carDao.updateCar(car);
			
		assertEquals("5-Series", carDao.getCars().get(0).getModel());
	}

	
	
}
