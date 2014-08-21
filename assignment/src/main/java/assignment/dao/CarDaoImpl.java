package assignment.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;

import assignment.model.Car;

@ApplicationScoped
@Stateful
public class CarDaoImpl implements CarDao {

    private static Logger logger = Logger.getLogger(CarDaoImpl.class.getName());

	private Map<Integer, Car> carRepository;

	@PostConstruct
	public void init() {
		carRepository = new ConcurrentHashMap<Integer, Car>();
	}
	
	@Override
	public void createCar(Car car) {
		logger.info("Before : carRepository.values().size() = " + carRepository.values().size());
		carRepository.put(car.getId(), car);
		logger.info("After : carRepository.values().size() = " + carRepository.values().size());

	}

	@Override
	public List<Car> getCars() {
		logger.info("carRepository.values().size() = " + carRepository.values().size());
		List<Car> carList = new ArrayList<Car>(carRepository.values());
		logger.info("carList.size() = " + carList.size());
		return Collections.unmodifiableList(carList);
	}

	@Override
	public boolean removeCar(int id) {
		if (carRepository.containsKey(id)) {
			carRepository.remove(id);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateCar(Car updatedCar) {
		if (carRepository.containsKey(updatedCar.getId())) {
			carRepository.put(updatedCar.getId(), updatedCar);
			return true;
		}
		return false;
	}

}
