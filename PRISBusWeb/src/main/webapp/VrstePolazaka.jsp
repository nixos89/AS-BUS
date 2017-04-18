<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vrste polazaka</title>
</head>
<body>
	<body>
	<jsp:useBean id="vrstaPolaska" class="model.Vrstapolaska" scope="session" />
	<div class="Box">
		<header> 
			<img id="logo" src="resources/images/Logo.jpg">
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
			<h2 class="sansserif">Unesite novu vrstu polaska</h2>
			<form action="SacuvajVrstuPolaskaServlet" method="get">
				<table>
					<tr>
						<td>Naziv</td>
						<td><input type="text" name="nazivVrste"></td>
					</tr>
				</table>
			</form>
		</div><!-- class="pretraga" -->
		
		<div>
			<h1>Vrste polazaka</h1>
			<div>
				<table class="table">
					<tr class="tr">
						<td>
							
						</td>	
					</tr>
					<c:forEach items="${naziviPolazaka}" var="naziv">
						<tr class="tr">
							<td>${naziv}</td>
						</tr>
					</c:forEach>
										
				</table>
			</div>
		</div>
	</div>
</body>
</html>