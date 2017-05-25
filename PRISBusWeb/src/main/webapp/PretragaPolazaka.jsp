<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
	<title>Prodaja karata</title>
</head>
<body>
	<jsp:useBean class="customBeans.SviGradovi" id="gradovi" scope="request" />
	<jsp:useBean class="customBeans.SviRazlicitiPolasci" id="razlicitipolasci" scope="session" />
	<div class="Box">
		<header> <img id="logo" src="resources/images/Logo.jpg">
		</header>
		<%@ include file="/resources/templates/menu.jsp" %>

		<div class="pretraga">
			<br/>
			<h2 class="sansserif">Pronađite odgovarajući autobus</h2>
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
						<td><input id="meeting" name="datumPolaska" type="date"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="Potvrdi"/>
						</td>

					</tr>
				</table>
			</form>
		</div>
		
		<div>
			
			<div>
				<c:if test="${!empty polasci}">
					<h1>Rezultat pretrage</h1>
					<table class="table">
						<tr class="tr">
							<th class="th">Polazak</th>
							<th class="th">Destinacija</th>
							<th class="th">Vreme</th>
							<th class="th">Prevoznik</th>
							<th class="th">Tip</th>
						</tr>
						<c:forEach items="${polasci}" var="polazak">
							<input type="hidden" name="idpolaska" value="${polazak.idpolaska}"/>
							<tr class="tr">
								<td class="td">Novi Sad</td>								
								<td class="td">${polazak.linija.grad.naziv}</td>
								<td class="td">${polazak.vremepolaska}</td>
								<td class="td">${polazak.prevoznik.naziv}</td>
								<td class="td">${polazak.vrstapolaska.vrsta}</td>
								<td><input type="text" name="brKarata"></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				${porukaPretraga}
			</div>
		</div>
	</div>
</body>
</html>