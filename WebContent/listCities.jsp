<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.worldmanager.dbhelpers.*
          , com.worldmanager.dbmodels.*
          , com.worldmanager.models.*
          , java.sql.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Welcome to the World Manager</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<%! 
		String uid = "";
		String pwd = "";
		DBManager dbm;
		WebUser wu;
	%>
	<% 
		if (session.getAttribute("authorized_user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp?dest=listCities");
			rd.forward(request, response);
		} else {
			wu = (WebUser)session.getAttribute("authorized_user");
			Integer authLevel = (Integer)wu.getAuthLevel();
			if (authLevel < 1) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp?dest=listCities");
				rd.forward(request, response);
			}
		}
		if (wu.getUserId()!= null && !wu.getUserId().equals("")) {
			uid = wu.getUserId();
		}
		if (wu.getPassword() != null && !wu.getPassword().equals("")) {
			pwd = wu.getPassword();
		}
	%>
	<%
		if (uid != null && !uid.equals("")) {
			%>
				<h1>Welcome back <%=uid %></h1>
			<% 
		}
	%>
	
	<table style="width:100;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
			</td>
			<td style="width:75%;height:80%;">
			
			<% 
				dbm = (DBManager)application.getAttribute("WorldDBManager");
			
				StringBuilder sb = new StringBuilder("<html><body>");
				try {
					if (!dbm.isConnected()) {
						if (!dbm.openConnection()) {
							sb.append("Could not connect to the database ...");
						}
					}
					
					sb.append("<table border=1>"
							+ "<tr><td>ID</td><td>NAME</td><td>COUNTRY_CODE</td>"
							+ "<td>DISTRICT</td><td>POPULATION</td</tr>");
					String query = DBWorldQueries.getCitiesByDistrictByPopulation();
					ResultSet rs = dbm.ExecuteResultSet(query);
					
					while (rs.next()) {
						int id = rs.getInt("ID");
						String name = rs.getString("NAME");
						String ctry = rs.getString("CountryCode");
						String dist = rs.getString("District");
						int pop = rs.getInt("Population");
						
						sb.append("<tr><td>" + id + "</td>"
								+ "<td>" + name + "</td>"
								+ "<td>" + ctry + "</td>"
								+ "<td>" + dist + "</td>"
								+ "<td>" + pop + "</td></tr>");
					}
					sb.append("</table>");
				} catch (Exception e) {
					sb.append("Error: " + e.getMessage());	
				} 
				sb.append("</body></html>");
				out.println(sb);
			    %>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>