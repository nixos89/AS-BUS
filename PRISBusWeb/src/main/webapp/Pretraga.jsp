<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
	<title>Pretraga polazaka</title>
</head>
<body>

<body>
	<jsp:useBean class="customBeans.SviGradovi" id="gradovi" scope="session" />
	<div class="Box">
		<header> <img id="logo" src="resources/images/Logo.jpg">
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
		</div>

		<div class="pretraga">
			<h2 class="sansserif">Nadjite odgovarajuci autobus</h2>
			<form method="get" action="PretragaServlet">
				<table>
					<tr>
						<td align="right">Destinacija: </td>
						<td>
							<select name="destinacija">
								<c:forEach items="${gradovi.sviGradovi}" var="grad">
									<option value="${grad.idgrad}">${grad.naziv}</option>								
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">Datum polaska</td>
						<td><input id="meeting" name="datumPolaska" type="date" value="2011-01-13 15:00"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="button">Potvrdi</button>
						</td>

					</tr>
				</table>
			</form>
		</div>
		
		<div>
			<h1>Rezultat pretrage</h1>
			<div>
				<c:if test="${!empty polasci}">
					<table class="table">
						<tr class="tr">
							<th class="th">Polazak</th>
							<th class="th">Destinacija</th>
							<th class="th">Vreme</th>
							<th class="th">Prevoznik</th>
							<th class="th">Cena</th>
						</tr>
						<c:forEach items="${polasci}" var="polazak">
							<tr class="tr">
								<td class="td">Novi Sad</td>
								<td class="td">${polazak.linija.grad}</td>
								<td class="td">${polazak.vremepolaska}</td>
								<td class="td">${polazak.prevoznik}</td>
								<td class="td">${polazak.karta.cenakarte}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>