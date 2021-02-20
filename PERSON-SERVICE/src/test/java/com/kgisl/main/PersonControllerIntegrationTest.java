//package com.kgisl.main;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.HttpClientErrorException;
//
//import com.kgisl.model.Person;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = PersonServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class PersonControllerIntegrationTest {
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@LocalServerPort
//	private int port;
//
//	private String getRootUrl() {
//		return "http://localhost:8089/api/v1/person";
//	}
//
//	@Test
//	public void contextLoads() {
//
//	}
//
//	@Test
//	public void testGetAllPerson() {
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getDetails", HttpMethod.GET, entity,
//				String.class);
//		assertNotNull(response.getBody());
//	}
//
//	@Test
//	public void testGetPersonId() {
//		int id = 1;
//		Person person = restTemplate.getForObject(getRootUrl() + "/" + id, Person.class);
//		System.out.println(person.getFirst_Name());
//		assertNotNull(person);
//	}
//
//	@Test
//	public void testCreateEmployee() {
//		Person employee = new Person();
//		employee.setFirst_Name("John");
//		employee.setLast_Name("Paul");
//		employee.setAge(56);
//		employee.setFavourite_colour("red");
//
//		ResponseEntity<Person> postResponse = restTemplate.postForEntity(getRootUrl() + "/create", employee,
//				Person.class);
//		assertNotNull(postResponse);
//		assertNotNull(postResponse.getBody());
//	}
//
//	@Test
//	public void testUpdateEmployee() {
//		int id = 1;
//		Person employee = restTemplate.getForObject(getRootUrl() + "/update/" + id, Person.class);
//		employee.setFirst_Name("Harris");
//		employee.setLast_Name("Mario");
//
//		restTemplate.put(getRootUrl() + "/create/" + id, employee);
//
//		Person updatedEmployee = restTemplate.getForObject(getRootUrl() + "/getDetails/" + id, Person.class);
//		assertNotNull(updatedEmployee);
//	}
//
//	@Test
//	public void testDeleteEmployee() {
//		int id = 2;
//		Person employee = restTemplate.getForObject(getRootUrl() + "/getDetails/" + id, Person.class);
//		assertNotNull(employee);
//
//		restTemplate.delete(getRootUrl() + "/delete/" + id);
//
//		try {
//			employee = restTemplate.getForObject(getRootUrl() + "/getDetails/" + id, Person.class);
//		} catch (final HttpClientErrorException e) {
//			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//		}
//	}
//}
