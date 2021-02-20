package com.kgisl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.exceptionHandlers.ResourceNotFoundException;
import com.kgisl.model.Person;
import com.kgisl.repository.PersonRepository;

/**
 * The Class PersonController for storing, updating, retrieving and deleting Person entities.
 */
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	/**
	 * Method to store person details.
	 *
	 * @param person the person
	 * @return the person
	 */
	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person personEntity = personRepository.save(person);
		return new ResponseEntity<Person>(personEntity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody List<Person> personDetails) {
		if (personDetails != null) {
			for (Person person : personDetails) {
				personRepository.save(person);
			}
		} else {
			return new ResponseEntity<>("success", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("success", HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Update person details.
	 *
	 * @param personId      the person id
	 * @param personDetails the person details
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePersonDetails(@PathVariable(value = "id") Long personId,
			@Valid @RequestBody Person personDetails) throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
		person.setFirst_name(personDetails.getFirst_name() != null && personDetails.getFirst_name() != "" ? personDetails.getFirst_name() : person.getFirst_name());
		person.setLast_name(personDetails.getLast_name() != null && personDetails.getLast_name() != "" ? personDetails.getLast_name() : person.getLast_name());
		person.setAge(personDetails.getAge() != 0 ? personDetails.getAge() : person.getAge());
		final Person updatePerson = personRepository.save(person);
		return ResponseEntity.ok(updatePerson);
	}

	/**
	 * Retrieving all person details.
	 *
	 * @return the all person
	 */
	@GetMapping("/getDetails")
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	/**
	 * Retrieving person by id.
	 *
	 * @param personId the person id
	 * @return the person by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
		return ResponseEntity.ok().body(person);
	}

	/**
	 * Delete person details.
	 *
	 * @param personId the person id
	 * @return the map
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("person not found for this id :: " + personId));

		personRepository.delete(person);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}