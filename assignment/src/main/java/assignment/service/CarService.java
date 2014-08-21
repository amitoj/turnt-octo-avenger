package assignment.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import assignment.dao.CarDao;
import assignment.model.Car;

@Path("/")
public class CarService {

	@Inject
	CarDao carDao;
	
	/*
	 * Add Car
	 * */
	@POST
	@Path("car/{id}")
	public Response createCar(
			@PathParam("id") int id,
			@FormParam("make") String make,
			@FormParam("model") String model,
			@FormParam("yearOfManufacture") int yearOfManufacture,
			@FormParam("entryDate") Date entryDate) {
		
		Car car = new Car(id, make, model, yearOfManufacture, entryDate);
		carDao.createCar(car);
		
		return Response.ok().build();
	}
	
	
	@GET
	@Path("car/")
	public List<Car> getCarList() {
		List<Car> carList = carDao.getCars();
		return carList;
	}
	
	
}
