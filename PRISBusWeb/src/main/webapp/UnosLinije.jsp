<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Nova Linija</title>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Expires" CONTENT="-1">
<link href="resources/css/Tema.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:useBean id="gradovi" class="customBeans.SviGradovi" scope="request" />	
	<div class="Box">
		<header>
			<img id="logo" src="resources/images/Logo.jpg">
		</header>
		<div class="menu">
			<ul id="menu">
				<li id="standard"><a href="Administrator.jsp"><i
						class="fa fa-home"></i>Početna</a></li>
				<li id="standard"><a href="Grad.jsp"><i class="fa fa-plus"></i>Novi
						Prevoznik</a></li>
				<li id="standard"><a href="Prevoznik.jsp"><i
						class="fa fa-plus"></i>Nova linija</a></li>
				<li id="veci"><a href="NoviPolasci.jsp"><i
						class="fa fa-plus"></i>Novi Polasci</a></li>
				<li id="standard"><a href="CenaKarte.jsp"><i
						class="fa fa-plus"></i>Dodaj promocije</a></li>
			</ul>
		</div>
		<div class="contain">
			<h2>Dodati novu liniju:</h2>
			<form method="post" action="UnosLinijeServlet">
				<table>
					<tr>
						<td>Grad:</td>
						<td><select name="gradovi">
								<c:forEach items="${gradovi.sviGradovi}" var="grad">
									<option value="${grad.idgrad}">${grad.naziv}</option>
								</c:forEach>
						</select></td>						
					</tr>
					<tr>
						<td><p>Naziv Linije:</p></td>
						<td><input type="text" name="nazivLinije"></td>
					</tr>
					<tr>
						<td><p>Datum Polaska:</p></td>
						<td><input name="datumPolaska" id="meeting" type="date" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" name="submit" value="Dodaj"></td>
					</tr>
				</table>
			</form>
			${porukaLinija}
		</div>
	</div>
</body>
</html>
