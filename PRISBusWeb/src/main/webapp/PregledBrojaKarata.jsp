<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Pregled broja karata</title>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Expires" CONTENT="-1">
<link href="resources/css/Tema.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="Box">
		<header>
			<img id="logo" src="resources/images/Logo.jpg">
		</header>
		<%@ include file="/resources/templates/menu.jsp" %>
		<br></br>
		
			<div class="rezervacija1">
			<p>
				<strong>Ime:</strong> <label for="ime">${radnik.ime}</label>
			</p>
			<p>
				<strong>Prezime: </strong><label for="prezime">${radnik.prezime}</label>
			</p>
			</div>
			<strong><h3 align="center">PREGLED PROFITA: </h3></strong>
			<br></br>
			<div class="rezervacija2">
				<h3 align="justify">Broj prodatih karata: ${prodaja.brprodatih}</h3>
				<h3 align="justify">Dnevni profit od prodatih karata: ${prodaja.dnevniprofit}</h3>
				<br></br>
				<br></br>
			</div>
			<marquee><img src="resources/images/karta.jpg"></marquee>
	
</body>
</html>

