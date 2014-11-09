package com.worldmanager.models.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.worldmanager.models.City;

public class CityTest {
	City c;
	private int id = 10;
	private String name = "Bournemouth";
	private String countryCode = "UK";
	private String district = "Dorset";
	private int population = 300000;
	
	@Before
	public void setUp() throws Exception {
		c = new City();
	}
	
	@Test
	public void testDefaultConstructor() {
		assertNotNull("Could not create a default city", c);
	}
	
	@Test
	public void testMutatorsAndAccessors() {
		c.setId(id);
		assertEquals("Could not set ID as Expected", id, c.getId());

		c.setName(name);
		assertEquals("Could not set name as Expected", name, c.getName());
		
		c.setCountryCode(countryCode);
		assertEquals("Could not set countryCode as Expected", countryCode, c.getCountryCode());
		
		c.setDistrict(district);
		assertEquals("Could not set District as Expected", district, c.getDistrict());
		
		c.setPopulation(population);
		assertEquals("Could not set Population as Expected", population, c.getPopulation());
	}
	
	@Test
	public void testToString() {
		c.setId(id);
		c.setName(name);
		c.setCountryCode(countryCode);
		c.setDistrict(district);
		c.setPopulation(population);
		
		String retStr = c.toString();

		assertTrue("toString does not contain expected value for id", retStr.contains(String.format("%d", id)));
		assertTrue("toString does not contain expected value for name", retStr.contains(String.format("%s", name)));
		assertTrue("toString does not contain expected value for countryCode", retStr.contains(String.format("%s", countryCode)));
		assertTrue("toString does not contain expected value for district", retStr.contains(String.format("%s", district)));
		assertTrue("toString does not contain expected value for population", retStr.contains(String.format("%d", population)));
	}

}
