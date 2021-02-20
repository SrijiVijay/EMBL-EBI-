package com.kgisl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Person.
 */
@Entity
@Table(name="TBL_PERSON")
public class Person {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** The first name. */
    @Column(name="first_name")
    private String first_name;
    
    /** The last name. */
    @Column(name="last_name")
    private String last_name;
    
    /** The age. */
    @Column(name="age", nullable=false, length=2)
    private long age;
    
    /** The favourite colour. */
    @Column(name="favourite_colour")
    private String favourite_colour;
    
    /**
     * Instantiates a new person.
     */
    public Person() {
	}
    
    /**
     * Instantiates a new person.
     *
     * @param first_Name the first name
     * @param last_Name the last name
     * @param age the age
     * @param favourite_colour the favourite colour
     */
    public Person(String first_Name, String last_Name, long age, String favourite_colour) {
		this.first_name = first_Name;
		this.last_name = last_Name;
		this.age = age;
		this.favourite_colour= favourite_colour;
	}
    
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * Sets the first name.
	 *
	 * @param first_name the new first name
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * Sets the last name.
	 *
	 * @param last_name the new last name
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public long getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(long age) {
		this.age = age;
	}

	/**
	 * Gets the favourite colour.
	 *
	 * @return the favourite colour
	 */
	public String getFavourite_colour() {
		return favourite_colour;
	}

	/**
	 * Sets the favourite colour.
	 *
	 * @param favourite_colour the new favourite colour
	 */
	public void setFavourite_colour(String favourite_colour) {
		this.favourite_colour = favourite_colour;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
    public String toString() {
        return "PersonEntity [id=" + id + ", firstName=" + first_name + 
                ", lastName=" + last_name + ", age=" + age  + ", favouriteColour=" + favourite_colour  + "]";
    }
}