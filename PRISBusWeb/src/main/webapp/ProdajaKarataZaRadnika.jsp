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
			<form>
				<table>
					<tr>
						<td><h3><label for="polazak">Odaberite polazak: </label></td></h3>
						<td><select name="polazak">
								<c:forEach items="${razlicitipolasci.getSviRazlicitiPolasci()}" var="p">
									<option value="${p.idgrad}">${p.naziv}</option>
								</c:forEach>
						</select></td>
				</table>
				<div class="vrstaKarte"> 
					<h3>Odaberite vrstu karte:</h3>
					<label for="redovna">Redovna:</label> 
					<input type="radio" name="vrstaKarte" id="redovna" value="Redovna"> 
					
					<label for="povratna">Povratna:</label> 
					<input type="radio" name="vrstaKarte" id="povratna" value="Povratna">
					
					<label for="studentska">Studentska:</label> 
					<input type="radio" name="vrstaKarte" id="studentska" value="Studentska">
					
					<label for="studentskaPovratna">Studentska povratna:</label> 
					<input type="radio" name="vrstaKarte" id="studentskaPovratna" value="Studentska povratna">
					
					<label for="penzionerska">Penzionerska:</label> 
					<input type="radio" name="vrstaKarte" id="penzionerska" value="Penzionerska">
					
					<label for="penzionerskaPovratna">Penzionerska povratna:</label> 
					<input type="radio" name="vrstaKarte" id="penzionerskaPovratna" value="Penzionerska povratna">
					
					<label for="sezonska">Sezonska:</label> 
					<input type="radio" name="vrstaKarte" id="sezonska" value="Sezonska">
				</div>
					<h4><label for="brKarata">Broj karata: </label></h4>
					<input type="text" name="brKarata">
					<br></br>
				<input type="submit" value="Potvrdi"> 
			</form>
			<br/><br/>
		</div>
</body>
</html>