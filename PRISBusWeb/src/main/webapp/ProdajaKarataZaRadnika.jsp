<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
	<title>Prodaja karata za radnika</title>
</head>
<body>
	<jsp:useBean class="customBeans.SviRazlicitiPolasci" id="razlicitipolasci" scope="session" />
	<div class="Box">
		<img id="logo" src="resources/images/Logo.jpg">
		<div class="menu">
			<ul id="menu">
				<li id="standard"><a href="Pocetna.jsp"><i
						class="fa fa-home"></i>Početna</a></li>
				<li id="standard"><a href="Pretraga.jsp"><i
						class="fa fa-search"></i> Pretraga</a></li>
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
		<h2 align="center">PRODAJA KARATA</h2>
		<div class="rezervacija2">
			<form action="ProdajaKarataZaRadnikaServlet" method="get">
				<table>
					<tr>
						<td><h3><label for="polazak">Odaberite polazak: </label></td></h3>
						<td><select name="polazak">
								<c:forEach items="${razlicitipolasci.getSviRazlicitiPolasci()}" var="p">
									<option value="${p.idgrad}">${p.naziv}</option>
								</c:forEach>
						</select></td>
						<div class="datum">
							<td><label>Datum polaska:</label></td>
							<td><input id="datePick" type="date" name="datumPolaska" value="2017-4-21" />							
						</div>
					</tr>		
				</table>
				<div class="vrstaKarte"> 
					<h3>Izaberite vrstu karte:</h3>
					<label for="redovna">Redovna:</label> 
					<input type="radio" name="vrstaKarte" id="redovna" value="Redovna">&nbsp; 
					<label for="povratna">Povratna:</label> 
					<input type="radio" name="vrstaKarte" id="povratna" value="Povratna">&nbsp; 
					<label for="studentska">Studentska:</label> 
					<input type="radio" name="vrstaKarte" id="studentska" value="Studentska">&nbsp;
					<label for="penzionerska">Penzionerska:</label> 
					<input type="radio" name="vrstaKarte" id="penzionerska" value="Penzionerska">&nbsp;
				</div><br/>
				<input type="submit" value="Potvrdi"> 
			</form>
			<br/><br/>			
		</div>
		<form action=ProdajaKarataZaRadnikaServlet method="post">
			<c:if test="${empty trazeniPolasci}">
				<p style="color: red">${porukaNemaPol}</p>
			</c:if>
			<c:if test="${!empty trazeniPolasci}">
				<table border="1">
					<tr>
						<th>Destinacija</th>
						<th>Vreme polaska</th>
						<th>Broj preostalih karata</th>
						<th>Cena karte</th>
						<th>Tip karte</th>
						<th>Broj karata</th>
						<th>Potvrda</th>
					</tr>
					<tr>
						<c:forEach items="${trazeniPolasci}" var="wantPol">
							<input type="hidden" name="idPolaska"
								value="${wantPol.idpolaska}" />
							<td>${wantPol.linija.grad.naziv}</td>
							<td><fmt:formatDate type="both" dateStyle="long"
									timeStyle="medium" value="${wantPol.vremepolaska}" /></td>
							<td>${wantPol.prevoznik.brmesta - wantPol.brprodatihkarata}</td>
							<c:forEach items="${wantPol.kartas}" var="vrstaKarte">
								<input type="hidden" name="cenaKarte"
									value="${vrstaKarte.cenakarte}" />
								<td>${vrstaKarte.cenakarte}</td>
								<td>${vrstaKarte.tipkarte}</td>
							</c:forEach>
							<td><input type="text" name="brKarata"></td>
							<td><input type="submit" value="Prodaj"></td>
						</c:forEach>
					</tr>
				</table>
			</c:if>
		</form>
	</body>
</html>