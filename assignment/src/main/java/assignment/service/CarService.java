package assignment.service;

import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import assignment.model.Car;

@Path("/")
public class CarService {

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
		
		return Response.ok().build();
	}
	
}
