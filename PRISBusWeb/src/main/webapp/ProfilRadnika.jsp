<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Profil Radnika</title>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Expires" CONTENT="-1">
<link href="resources/css/Tema.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="Box">
		<header>
			<img id="logo" src="resources/images/Logo.jpg">
		</header>
		<div class="menu">
			<ul id="menu">
				<li id="standard"><a href="Pocetna.jsp"><i
						class="fa fa-home"></i>Početna</a></li>
				<li id="standard"><a href="Pretraga.jsp"><i
						class="fa fa-search"></i> Pretraga </a></li>
				<li id="standard"><a href="Registracija.jsp"><i
						class="fa fa-registered"></i> Registracija</a></li>
				<li id="standard"><a href="Logovanje.jsp"><i
						class="fa fa-registered"></i> Logovanje</a></li>
				<li id="veci"><a href="NoviPolasci.jsp"><i
						class="fa fa-plus"></i> Novi Polasci</a></li>
				<li id="veci1"><a href="CenaKarte.jsp"><i
						class="fa fa-pencil-square-o"></i> Modifikuj cene</a></li>
			</ul>
		</div>
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
				<input type="submit" value="PRODAJA KARATA">
				<br></br>
			</div>
			<marquee><img src="resources/images/karta.jpg"></marquee>
	
</body>
</html>

