<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.worldmanager.dbhelpers.*
          , com.worldmanager.dbmodels.*
          , com.worldmanager.models.*
          , java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Welcome to the World Manager</title>
</head>
<body>
	<c:import url="header.jsp" />

	<c:choose>
		<c:when test="${sessionScope.authorized_user eq null}">
			<c:redirect url="login.jsp?dest=listCities" />
		</c:when>
		<c:when test="${sessionScope.authorized_user.authLevel ne 1}">
			<c:redirect url="login.jsp?dest=listCities" />
		</c:when>
		<c:when test="${sessionScope.authorized_user.userId eq null}">
			<c:redirect url="login.jsp?dest=listCities" />
		</c:when>
		<c:when test="${sessionScope.cityData eq null}">
			<c:redirect url="getcitydata.do" />
		</c:when>
		<c:otherwise>
			<h1><c:out value="Welcome Back ${sessionScope.authorized_user.userId" /></h1>
		</c:otherwise>
	</c:choose>
	
	
	<table style="width:100;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
			</td>
			<td style="width:75%;height:80%;">
				<table>
					<tr>
						<td>POSITION</td>
						<td>ID</td>
						<td>NAME</td>
						<td>COUNTRY_CODE</td>
						<td>DISTRICT</td>
						<td>POPULARION</td>
					</tr>
					<c:forEach var="cityData" items="${sessionScope.cityData}" varStatus="iterationCount">
						<tr>
							<td>${iterationCount.count}</td>
							<td>${cityData.id}</td>
							<td>${cityData.name}</td>
							<td>${cityData.countryCode}</td>
							<td>${cityData.district}</td>
							<td>${cityData.population}</td>
						</tr>
					</c:forEach>
				</table>			
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp" />
</body>
</html>