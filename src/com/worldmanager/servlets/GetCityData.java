package com.worldmanager.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.worldmanager.dbhelpers.DBWorldQueries;
import com.worldmanager.dbmodels.DBManager;
import com.worldmanager.models.City;

/**
 * Servlet implementation class GetCityData
 */
@WebServlet("/getcitydata.do")
public class GetCityData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCityData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		if (getServletContext().getAttribute("WorldDBManager") != null) {
			DBManager dbm = (DBManager)getServletContext().getAttribute("WorldDBManager");
			if (!dbm.isConnected()) {
				if (!dbm.openConnection()) {
					throw new IOException("Could not connect to db and open connection");
				}
			}
			
			ArrayList<City> allCities = new ArrayList<City>();
			String query = DBWorldQueries.getCitiesByDistrictByPopulation();
			try {
				ResultSet rs = dbm.ExecuteResultSet(query);
				while (rs.next()) {
					City c = new City();
					c.setId(rs.getInt("ID"));
					c.setName(rs.getString("Name"));
					c.setCountryCode(rs.getString("CountryCode"));
					c.setDistrict(rs.getString("District"));
					c.setPopulation(rs.getInt("Population"));
					allCities.add(c);
				}
				s.setAttribute("cityData", allCities);
			} catch (Exception e) {
				throw new IOException("Query could not be executed for GET ALL CITIES");
			}
			response.sendRedirect("listCities.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
