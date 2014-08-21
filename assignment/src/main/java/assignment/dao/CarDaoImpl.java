package assignment.dao;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

import assignment.model.Car;

@Stateful
public class CarDaoImpl implements CarDao {

	private Map<Integer, Car> carRepository;

	@PostConstruct
	public void init() {
		carRepository = new ConcurrentHashMap<Integer, Car>();
	}
	
	@Override
	public void createCar(Car car) {
		carRepository.put(car.getId(), car);
	}

	@Override
	public List<Car> getCars() {
		
		return (List<Car>) carRepository.values();
		
		
		//return Collections.unmodifiableList(carRepository.values());
	}

}
