package assignment.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class TestCarEntity {

	@Test
	public void test() {
		
//		Calendar cal = Calendar.getInstance();
//		cal.set(2005, 6, 1);
//		Car car = new Car(123, "BMW", "3-Series", 2005, cal.getTime());
		
		Car car = new Car(123, "BMW", "3-Series", 2005, "2005-06-23");
		
		assertEquals(123, car.getId());
		assertEquals("BMW", car.getMake());
		assertEquals("3-Series", car.getModel());
		assertEquals(2005, car.getYearOfManufacture());
	}

}
