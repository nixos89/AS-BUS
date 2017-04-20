<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Novi Polazak</title>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Expires" CONTENT="-1">
<link href="resources/css/Tema.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:useBean id="vrstePolaska" class="customBeans.SveVrstePolazaka"
		scope="request" />
	<jsp:useBean id="sveLinije" class="customBeans.SveLinije"
		scope="request"></jsp:useBean>
	<jsp:useBean id="sviPrevoznici" class="customBeans.SviPrevoznici"
		scope="session"></jsp:useBean>
	<div class="Box">
		<header>
			<img id="logo" src="resources/images/Logo.jpg">
		</header>
		<div class="menu">
			<ul id="menu">
				<li id="standard"><a href="Administrator.jsp"><i
						class="fa fa-home"></i>Početna</a></li>
				<li id="standard"><a href="Prevoznik.jsp"><i 
					class="fa fa-plus"></i>Novi	Prevoznik</a></li>
				<li id="standard"><a href="Grad.jsp"><i
						class="fa fa-plus"></i>Nova Linija</a></li>
				<li id="veci"><a href="UnosLinije.jsp"><i
						class="fa fa-plus"></i>Novi Polasci</a></li>
				<li id="standard"><a href="CenaKarte.jsp"><i
						class="fa fa-plus"></i>Dodaj promocije</a></li>
			</ul>
		</div>

		<div class="contain">
			<h2>Dodati nove polaske:</h2>
			<form method="get" action="NoviPolasciServlet">
				<table>
					<tr>
						<td><p>Prevoznik:</p></td>
						<td><select name="idPrevoznika">
								<c:forEach items="${sviPrevoznici.sviPrevoznici}" var="prevoznik">
									<option value="${prevoznik.idprevoznik}">${prevoznik.naziv}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>	
						<td><p>Linija:</p></td>
						<td><select name="idLinije">
								<c:forEach items="${sveLinije.sveLinije}" var="linija">									
									<option value="${linija.idlinija}">${linija.nazivlinije}</option>
								</c:forEach>
						</select></td>
					</tr>	
					<tr>
						<td><p>Vrsta Polaska:</p></td>
						<td><select name="idVrstePolaska">
								<c:forEach items="${vrstePolaska.sveVrstePolazaka}" var="vrstaP">
									<option value="${vrstaP.idvrstapolaska}">${vrstaP.vrsta}</option>
								</c:forEach>
						</select></td>
					</tr>
					
					<tr>
						<td><p>Vreme Polaska:</p></td>
						<td><input name="vremePolaska" type="text" /></td>
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
