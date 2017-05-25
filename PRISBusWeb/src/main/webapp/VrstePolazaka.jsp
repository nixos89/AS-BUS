<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
	<title>Vrste polazaka</title>
</head>
<body>

<body>
	<jsp:useBean id="vrstePolaska" class="customBeans.SveVrstePolazaka" scope="request" />	
	<div class="Box">
		<header> 
			<img id="logo" src="resources/images/Logo.jpg">
		</header>
		<%@ include file="/resources/templates/menu.jsp" %>

		<div class="pretraga">
			<h2 class="sansserif">Unesite novu vrstu polaska</h2>
			<form id="novaVrstaPolaskaForm" action="SacuvajVrstuPolaskaServlet" method="get">
				<table>
					<tr>
						<td>Naziv</td>
						<td><input type="text" name="nazivVrste"></td>
						<td><input type="submit" value="Snimi"/></td>
					</tr>
				</table>
			</form>
			${porukaVrstaPol}
		</div><!-- class="pretraga" -->
		
		<div>
			<h1>Vrste polazaka</h1>
			<div>
				<table class="table">
					<tr class="tr">
						<th class="th">Naziv polaska</th>
					</tr>
					<c:forEach items="${vrstePolaska.sveVrstePolazaka}" var="vrstaP">
						<tr class="tr">
							<td>${vrstaP.vrsta}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
<%@ include file="/resources/templates/footer.jsp" %>