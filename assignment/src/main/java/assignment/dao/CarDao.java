package assignment.dao;

import java.util.List;

import assignment.model.Car;


public interface CarDao {
    void createCar(Car car);
	List<Car> getCars();
}
