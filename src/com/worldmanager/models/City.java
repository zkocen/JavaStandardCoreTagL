package com.worldmanager.models;

import java.io.Serializable;

public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String countryCode;
	private String district;
	private int population;
	
	public void setId(int value) {
		id = value;
	}

	public Object getId() {
		return id;
	}

	public void setName(String value) {
		name = value;
	}

	public Object getName() {
		return name;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		
	}

	public Object getCountryCode() {
		return countryCode;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	public int getPopulation() {
		return population;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countryCode="
				+ countryCode + ", district=" + district + ", population="
				+ population + "]";
	}

	public void setDistrict(String value) {
		district = value;
	}

	public Object getDistrict() {
		return district;
	}
}
