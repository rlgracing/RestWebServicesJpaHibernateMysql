package com.rlg.webservice.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rlg.webservice.dao.PersonMapDAO;
import com.rlg.webservice.model.Person;

@Path("/person")
public class PersonService {

	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Person addPerson(Person person) {
		PersonMapDAO.addPerson(person);
		return person;
	}

	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Person addPersonForm(@FormParam("id") String id, @FormParam("fullName") String fullName, @FormParam("address") String address) {
		Person person = new Person(id, fullName, address);
		PersonMapDAO.addPerson(person);
		return person;
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Person updatePerson(Person person) {
		PersonMapDAO.updatePerson(person);
		return person;
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public String deletePeron(@PathParam("id") String id) {
		PersonMapDAO.deletePeron(id);
		return "success";
	}
	
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Person> getEverybody() {
		return PersonMapDAO.getEverybody();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Person getPerson(@PathParam("id") String id) {
		return PersonMapDAO.getPerson(id);
	}

}
