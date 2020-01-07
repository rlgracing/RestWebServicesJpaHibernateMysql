package com.rlg.webservice.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rlg.webservice.model.Person;

public class PersonMapDAO {
	
	private static Map<String, Person> personMap = new HashMap<String, Person>();
	
	static {
		personMap.put("1", new Person("1", "Rafa", "Street Y"));
		personMap.put("2", new Person("2", "John", "Street O"));
		personMap.put("3", new Person("3", "Mary", "Street J"));
		personMap.put("4", new Person("4", "Stewart", "Street W"));
	}
	
	public static void addPerson(Person person) {
		personMap.put(person.getId(), person);
	}
	
	public static void deletePeron(String id) {
		personMap.remove(id);
	}
	
	public static void updatePerson(Person person) {
		personMap.put(person.getId(), person);
	}
	
	public static List<Person> getEverybody() {
		return new ArrayList<Person>(personMap.values());
	}
	
	public static Person getPerson(String id) {
		return personMap.get(id);
	}

}
