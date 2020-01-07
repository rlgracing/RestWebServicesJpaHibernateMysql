package com.rlg.webservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import com.rlg.webservice.dao.PersonMySqlDAO;
import com.rlg.webservice.dao.PersonMySqlEntity;
import com.rlg.webservice.model.Person;

@Path("/person/mysql")
public class PersonMySqlService {

	private final  PersonMySqlDAO personMySqlDAO = new PersonMySqlDAO();

	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Person addPerson(Person person) {
		
		PersonMySqlEntity personEntity = new PersonMySqlEntity(	person.getFullName(), 
																person.getAddress());
		
		personMySqlDAO.addPerson(personEntity);

		person.setId(personEntity.getId().toString());
		
		return person;
	}

	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Person addPersonForm(@FormParam("fullName") String fullName, @FormParam("address") String address) {
		return this.addPerson(new Person(	fullName,
											address));
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Person updatePerson(Person person) {
		personMySqlDAO.updatePerson(new PersonMySqlEntity(	new Integer(person.getId()),
															person.getFullName(), 
															person.getAddress()));		
		return person;
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public String deletePeron(@PathParam("id") Integer id) {
		personMySqlDAO.deletePerson(id);
		
		return "success";
	}
	
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Person> getEverybody() {
		
		//Using forEach
//		List<Person> personList = new ArrayList<Person>();
//		personMySqlDAO.getEverybody().forEach(personEntity -> {
//			personList.add(new Person(personEntity.getId().toString(), personEntity.getFullName(), personEntity.getAddress()));
//		});
//		
//		return personList;
		
		//Using Stream API
		return	personMySqlDAO.getEverybody()
				.stream()
				.map(personEntity -> new Person(personEntity.getId().toString(), personEntity.getFullName(), personEntity.getAddress()))
				.collect(Collectors.toList());
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Person getPerson(@PathParam("id") Integer id) {
		PersonMySqlEntity personEntity  = personMySqlDAO.getPerson(id);
		
		return new Person(	personEntity.getId().toString(),
							personEntity.getFullName(),
							personEntity.getAddress());
	}

}
