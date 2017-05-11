<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
	<title>Online rezervacija</title>
</head>
<body>
	<jsp:useBean class="customBeans.SviRazlicitiPolasci" id="polasci" scope="session" />
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
		<h2 align="center">ONLINE REZERVACIJA AUTOBUSKE KARTE</h2>
		<div class="rezervacija1">
			<form action="RezervacijaMestaServlet" method="get">
				<table width="500">
					<tr>
						<td><label for="polazak">Destinacija: </label></td>
						<td><select name="polazak">
								<c:forEach items="${polasci.getSviRazlicitiPolasci()}" var="p">
									<option value="${p.idgrad}">${p.naziv}</option>
								</c:forEach>
						</select></td>
						<div class="datum">
							<td><label>Datum polaska:</label></td>
							<td><input id="datePick" type="date" name="datumPolaska" value="2011-01-13" />							
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
				<input type="submit" value="Pretraži"> 
			</form>
			<br/><br/>
			<c:if test="${empty trazeniPolasci}">
				${porukaNemaPol}
			</c:if>
			<c:if test="${!empty trazeniPolasci}">
				<table border="1">
					<tr>
						<th>Destinacija</th><th>Vreme polaska</th><th>Broj preostalih karata</th>
						<th>Cena PENZIONERSKE karte</th><th>Cena POVRATNE karte</th>
						<th>Cena STUDENTSKE karte</th><th>Cena REDOVNE karte</th>
					</tr>
					<tr>
						<c:forEach items="${trazeniPolasci}" var="wantPol">
							<td>${wantPol.linija.grad.naziv}</td>
							<td>${wantPol.vremepolaska}</td>
							<td>${wantPol.prevoznik.brmesta - wantPol.brprodatihkarata}</td>
							<td>${wantPol.}</td>
						</c:forEach>			
					</tr>
				</table>				
			</c:if>
			<form action="PopustServlet" method="post">
				<table>
					<tr>
						<td><p>
								<strong>Broj karata: </strong>
							</p></td>
						<td><input type="text" value=""></td>
					</tr>
					<tr>
						<td><input type="submit" name="Potvrdi" value="Rezerviši"></td>
						<td><input type="reset" name="Obrisi" value="Poništi"></td>
					</tr>					
				</table>
			</form>
			<br/><br/><br/>	
			<div class="rezervacija2">

				<strong><marquee>Na svaku treću rezervaciju,
						POPUST OD 10% na cenu karte! ! !</marquee></strong>
			</div>
		</div>
</body>
</html>