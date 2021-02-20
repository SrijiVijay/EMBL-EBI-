package com.kgisl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.model.Person;

/**
 * The Interface PersonRepository.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
