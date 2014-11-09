package com.worldmanager.models;

import java.io.Serializable;

public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String continent;
	private String region;
	private double surfaceArea;
	private int indepYear;
	private int population;
	private double lifeExpectancy;
	private double gnp; 
	private double gnpOld; 
	private String localName;
	private String governmentForm;
	private String headOfState;
	private String Capital;
	private String code2;
	
	public void setCode(String value) {
		code = value;
	}



	public String getCode() {
		return code;
	}



	public void setName(String value) {
		name = value;
	}



	public String getName() {
		return name;
	}



	public void setContinent(String value) {
		continent = value;
	}



	public String getContinent() {
		return continent;
	}



	public void setRegion(String value) {
		region = value;
	}



	public String getRegion() {
		return region;
	}



	public void setSurfaceArea(double value) {
		surfaceArea = value;
	}



	public double getSurfaceArea() {
		return surfaceArea;
	}



	public void setIndepYear(int value) {
		indepYear = value;
	}



	public int getIndepYear() {
		return indepYear;
	}



	public void setPopulation(int value) {
		population = value;
	}



	public int getPopulation() {
		return population;
	}



	public void setLifeExpectancy(double value) {
		lifeExpectancy = value;
	}



	public double getLifeExpectancy() {
		return lifeExpectancy;
	}



	public void setGnp(double value) {
		gnp = value;
	}



	public double getGnp() {
		return gnp;
	}
	
	public void setGnpOld(double value) {
		gnpOld = value;
	}



	public double getGnpOld() {
		return gnpOld;
	}



	public void setLocalName(String value) {
		localName = value;
	}



	public String getLocalName() {
		return localName;
	}



	public String getGovernmentForm() {
		return governmentForm;
	}



	public void setGovernmentForm(String value) {
		governmentForm = value;
	}



	public String getHeadOfState() {
		return headOfState;
	}



	public void setHeadOfState(String value) {
		headOfState = value;
	}



	public String getCapital() {
		return Capital;
	}



	public void setCapital(String value) {
		Capital = value;
	}



	public String getCode2() {
		return code2;
	}



	public void setCode2(String value) {
		code2 = value;
	}



	public String toString() {
		return String.format(
				"Code: %s\tName: %s\tContinent: %s\tRegion%s\t " 
				+ "Surface Area: %.1f\tIndependence Year: %d\tPopulation: %d\t"
				+ "Life Expectancy: %.1f\tGNP: %.1f\tGNP OLD: %.1f\tLocal Name: %s\t"
				+ "GovernmentForm: %s\tHead Of State: %s\tCapital %s\tCode2: %s\n"
				, getCode()
				, getName()
				, getContinent()
				, getRegion()
				, getSurfaceArea()
				, getIndepYear()
				, getPopulation()
				, getLifeExpectancy()
				, getGnp()
				, getGnpOld()
				, getLocalName()
				, getGovernmentForm()
				, getHeadOfState()
				, getCapital()
				, getCode2());
	}
}
