<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Unos povoljnosti</title>
</head>

<!-- HITNO: Izmenuti ovu stranicu da se unose povoljnosti (pomocu checkbox-eva i 
            da se to sto je SELEKTOVANO PRIKAZE na index.jsp) -->

<body>
	<div class="Box">
		<header> <img id="logo" src="resources/images/Logo.jpg">
		</header>
		<%@ include file="/resources/templates/menu.jsp" %>
		<form action="UnosPovoljnostiServlet" method="get">
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
			<form action="UnosPovoljnostiServlet" method="post">
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
							<td><input type="checkbox" name="odabraniPolazak" value="${wantPol.idpolaska}"></td>
							<td><input type="submit" value="Postavi"></td>
						</c:forEach>
					</tr>
				</table>
			</c:if>
		</form>
	</div>
<%@ include file="/resources/templates/footer.jsp" %>