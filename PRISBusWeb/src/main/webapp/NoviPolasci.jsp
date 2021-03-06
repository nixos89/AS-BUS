<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<html>
	<head>
		<title><fmt:message key="addPutovanje"/></title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="resources/css/Tema.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
	<jsp:useBean id="vrstePolaska" class="customBeans.SveVrstePolazaka" scope="request" />
	
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
				<li id="veci"><a href="NoviPolasci.jsp"><i
						class="fa fa-plus"></i> Novi Polasci</a></li>
				<li id="veci1"><a href="CenaKarte.jsp"><i
						class="fa fa-pencil-square-o"></i> Modifikuj cene</a></li>
			</ul>
		</div>
		
		<div class="contain">
			<h2>Dodati nove polaske:</h2>
			<form method="get" action="NoviPoslaciServlet">
				<table>
					<tr>
						<td><p>ID Polaska:</p></td>
						<td><input type="text" name="idPolaska"></td>
					</tr>
					<tr>
						<td><p>Vrsta Polaska:</p></td>
						<td><select name="vrstaPolaska">
								<c:forEach items="${vrstePolaska.sveVrstePolazaka}" var="vrstaP">
									<option value="${vrstaP.idvrstapolaska}">${vrstaP.vrsta}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td><p>Id Prevoznika:</p></td>
						<td><input type="text" name="idPrevoznika"></td>
					</tr>
					<tr>
						<td><p>Id Linije:</p></td>
						<td><input type="text" name="idLinija"></td>
					</tr>
					<tr>
						<td><p>Vreme Polaska:</p></td>
						<td><input id="meeting" type="date" value="2017-04-13 15:00" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" name="submit" value="Dodaj"></td>
					</tr>

				</table>
			</form>
		</div>
		<br></br> <img id="logo" src="resources/images/s3.jpg">
	</div>

</body>
</html>
		