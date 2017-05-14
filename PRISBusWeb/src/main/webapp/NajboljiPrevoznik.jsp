<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Najbolji prevoznik</title>
</head>
<body>
	`
	<div class="Box">
		<header> <img id="logo" src="resources/images/Logo.jpg">
		</header>
		<div class="menu">
			<ul id="menu">
				<li id="standard"><a href="Pocetna.jsp"><i
						class="fa fa-home"></i>Početna</a></li>
				<li id="standard"><a href="Pretraga.jsp"><i
						class="fa fa-search"></i> Pretraga </a></li>
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
		<h3 align="center">Odaberite mesec za koji želite prikaz
			najboljeg prevoznika:</h3>
		<div class="rezervacija1">
			<form action="NajboljiPrevoznikServlet" method="get">

				<div align="center""styled-select">
					<select>
						<option>Januar</option>
						<option>Februar</option>
						<option>Mart</option>
						<option>April</option>
						<option>Maj</option>
						<option>Jun</option>
						<option>Jul</option>
						<option>Avgust</option>
						<option>Septembar</option>
						<option>Oktobar</option>
						<option>Novembar</option>
						<option>Decembar</option>		
					</select>
					<input type="submit" value="Prikaži">
				</div>
			</form>
			<br></br>
			<h3 align="center"><strong>Na osnovu ocena korisnika, najbolji je:</strong></h3>
		
			<table>
				<tr>
				<td>
				<strong>PREVOZNIK:</strong>
				</td>
				</tr>
				<tr>
				<td>
				<strong>Detalji:</strong>
				</td>
				</tr>
			</table>
			<br></br>
			<br></br>
			<img id="logo" src="resources/images/bus.jpg">
</body>


</body>
</html>