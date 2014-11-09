package com.worldmanager.dbhelpers;

public class DBWorldQueries {
	public static String getCitiesByDistrictByPopulation() {
		return "select * from city "
				+ "where CountryCode = 'SLO'"
				+ " order by District ASC, Population DESC";
	}
	
	public static String getCountriesByName() {
		return "select * "
				+ "from Country "
				+ "order by Name";
	}
}
