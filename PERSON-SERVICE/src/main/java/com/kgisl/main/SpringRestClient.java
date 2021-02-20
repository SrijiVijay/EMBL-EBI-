package com.kgisl.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kgisl.model.Person;

/**
 * The Class SpringRestClient.
 */
public class SpringRestClient {

	/** The Constant CREATE_PERSON_ENDPOINT_URL. */
	private static final String CREATE_PERSON_ENDPOINT_URL = "http://localhost:8089/api/v1/person/create";
	
	/** The Constant GET_PERSON_BYID_ENDPOINT_URL. */
	private static final String GET_PERSON_BYID_ENDPOINT_URL = "http://localhost:8089/api/v1/person/{id}";
	
	/** The Constant GET_ALL_PERSON_ENDPOINT_URL. */
	private static final String GET_ALL_PERSON_ENDPOINT_URL = "http://localhost:8089/api/v1/person/getDetails";
	
	/** The Constant UPDATE_PERSON_ENDPOINT_URL. */
	private static final String UPDATE_PERSON_ENDPOINT_URL = "http://localhost:8089/api/v1/person/update/{id}";
	
	/** The Constant DELETE_PERSON_ENDPOINT_URL. */
	private static final String DELETE_PERSON_ENDPOINT_URL = "http://localhost:8089/api/v1/person/delete/{id}";
	
	/** The rest template. */
	private static RestTemplate restTemplate = new RestTemplate();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringRestClient springRestClient = new SpringRestClient();
		
		// Step1: first create a new person
		springRestClient.createPerson();
		
		// Step 2: get new created person from step1
		springRestClient.getPersonById();
		
		// Step3: get all persons
		springRestClient.getAllPerson();
		
		// Step4: Update person with id = 1
		springRestClient.updatePerson();
		
		// Step5: Delete person with id = 1
		springRestClient.deletePerson();
	}

	/**
	 * Gets the all person.
	 *
	 * @return the all person
	 */
	private void getAllPerson() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_PERSON_ENDPOINT_URL, HttpMethod.GET, entity,
				String.class);

		System.out.println(result);
	}

	/**
	 * Gets the person by id.
	 *
	 * @return the person by id
	 */
	private void getPersonById() {

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");

		RestTemplate restTemplate = new RestTemplate();
		Person result = restTemplate.getForObject(GET_PERSON_BYID_ENDPOINT_URL, Person.class, params);

		System.out.println(result);
	}

	/**
	 * Creates the person.
	 */
	private void createPerson() {
		Person newPerson = new Person("John", "Keynes", 29, "red");
		RestTemplate restTemplate = new RestTemplate();
		Person result = restTemplate.postForObject(CREATE_PERSON_ENDPOINT_URL, newPerson, Person.class);
		System.out.println(result);
	}

	/**
	 * Update person.
	 */
	private void updatePerson() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		Person updatePerson = new Person("Sarah", "Robinson", 54, "Yellow");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(UPDATE_PERSON_ENDPOINT_URL, updatePerson, params);
	}

	/**
	 * Delete person.
	 */
	private void deletePerson() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(DELETE_PERSON_ENDPOINT_URL, params);
	}
}
