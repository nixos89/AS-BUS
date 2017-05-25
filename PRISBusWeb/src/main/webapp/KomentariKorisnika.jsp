<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
<title>Komentari korisnika</title>
</head>
<body>
	<jsp:useBean id="prevoznici" class="customBeans.SviPrevoznici"/>	
	<div class="Box">
		<img id="logo" src="resources/images/Logo.jpg">
		<%@ include file="/resources/templates/menu.jsp" %>
		<br></br>
		<h2 align="center"><strong>Odaberite prevoznika za prikaz komentara: </strong></h2>
		<form action="KomentariKorisnikaServlet" method="get">
			<p align="center">
				<select name="prevoznik">
					<c:forEach items="${prevoznici.getSviPrevoznici()}" var="prevoznik">
						<option value="${prevoznik.idprevoznik}">${prevoznik.naziv}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Pretraži"/>
			</p>
			
		</form>
		<br></br>
		<div class="rezervacija2">
			<c:if test="${!empty komentars}">
				<c:forEach items="${komentars}" var="komentar">					
					<table border="1">
						<tr>
							<td><b>Prevoznik:</b></td>
							<td>${komentar.prevoznik.naziv}</td>
						</tr>
						<tr>
							<td><b>Korisnik:</b></td>
							<td>${komentar.putnik.ime} ${komentar.putnik.prezime}</td>
						</tr>
						<tr>
							<td><b>Ocena:</b></td>
							<td>${komentar.ocena}</td>
						</tr>
						<tr>
							<td><b>Datum:</b></td>
							<td><fmt:formatDate type="date" dateStyle="long"
								     value="${komentar.datumkomentara}" />
							</td>
						</tr>
						<tr>
							<td><b>Komentar:</b></td>
							<td>${komentar.tekstkomentara}</td>
						</tr>
					</table>
					<br/><br/>
				</c:forEach>
			</c:if>
		</div>
		<br></br>
		<div class="rezervacija2">
			<form action="KomentariKorisnikaServlet" method="post">
				<div style="border='1'">
				  |<strong>Odaberite prevoznika za komentar:</strong> 
				  <select name="prevoznik">
					<c:forEach items="${prevoznici.getSviPrevoznici()}" var="prevoznik">
						<option value="${prevoznik.idprevoznik}">${prevoznik.naziv}</option>
					</c:forEach>
				  </select>
				  <br/><br/>
				  <strong>Ocenite prevoznika (5 - max, a 1 - min)&nbsp;</strong>
					<b><label for="1">1:</label></b>
					<input type="radio" id="1" name="ocena" value="1"/>&nbsp;
					<b><label for="2">2:</label></b>
					<input type="radio" id="2" name="ocena" value="2"/>&nbsp;
					<b><label for="3">3:</label></b>
					<input type="radio" id="3" name="ocena" value="3"/>&nbsp;
					<b><label for="4">4:</label></b>
					<input type="radio" id="4" name="ocena" value="4"/>&nbsp;
					<b><label for="5">5:</label></b>
					<input type="radio" id="5" name="ocena" value="5"/><br/><br/>
				
				  <table>			
					<tr>
						<td><h4>Komentar:</h4></td>						
						<td><textarea placeholder="Ovde unesite Vaš komentar" cols="60" name="tekstKomentara" rows="5"></textarea></td>						
					</tr>				
				  </table>
				  <br/>
				  <input type="submit" value="Unesi">&nbsp;
				  <input type="reset" value="Obriši">
				  ${porukaKomentar}	
				</div>				
			</form>
		</div>
		<br/><br/>
		
	</div>	
<%@ include file="/resources/templates/footer.jsp" %>