package assignment.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	@Path("/car/{id}")
	public Response createCar(
			@PathParam("id") int id,
			@FormParam("make") String make,
			@FormParam("model") String model,
			@FormParam("yearOfManufacture") int yearOfManufacture,
			@FormParam("entryDate") String entryDate) {
		
		Car car = new Car(id, make, model, yearOfManufacture, entryDate);
		carDao.createCar(car);
		
		return Response.ok().build();
	}
	
	@GET
	@Path("/car")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Car> getCarList() {
		List<Car> carList = carDao.getCars();
		return carList;
	}

	@DELETE
	@Path("/car/{id}")
	public Response removeCar(@PathParam("id") int id) {
		if (carDao.removeCar(id))
			return Response.ok().build();
		else
			return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Path("/car/{id}")
	public Response updateCar(
			@PathParam("id") int id,
			@FormParam("make") String make,
			@FormParam("model") String model,
			@FormParam("yearOfManufacture") int yearOfManufacture,
			@FormParam("entryDate") String entryDate) {
		
		Car updatedCar = new Car(id, make, model, yearOfManufacture, entryDate);
		if (carDao.updateCar(updatedCar))
			return Response.ok().build();
		else
			return Response.status(Status.NOT_FOUND).build();
	}
	
	
	
}
