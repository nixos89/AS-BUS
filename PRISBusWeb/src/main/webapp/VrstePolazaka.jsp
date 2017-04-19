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
		<div class="menu">
			<ul id="menu">
				<li id="standard"><a href="Pocetna.jsp"><i
						class="fa fa-home"></i>Pocetna</a></li>
				<li id="standard"><a href="Pretraga.jsp"><i
						class="fa fa-search"></i> Pretraga </a></li>
				<li id="standard"><a href="Registracija.jsp"><i
						class="fa fa-registered"></i> Registracija</a></li>
				<li id="veci"><a href="NoviPolasci.jsp"><i
						class="fa fa-plus"></i> Dodavanje Polazaka</a></li>
				<li id="veci1"><a href="CenaKarte.jsp"><i
						class="fa fa-pencil-square-o"></i> Modifikuj cene</a></li>
			</ul>
		</div><!-- class="menu" -->

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
</body>
</html>