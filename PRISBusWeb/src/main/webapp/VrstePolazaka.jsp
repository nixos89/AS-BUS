<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vrste polazaka</title>
</head>
<body>
	<body>
	<div class="Box">
		<header> <img id="logo" src="resources/images/Logo.jpg">
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
			<table>
				<tr>
					<td>Naziv </td>
					<td><input type="text" name="nazivVrste"></td>
				</tr>
			</table>
		</div><!-- class="pretraga" -->
		
		<div>
			<h1>Rezultat pretrage</h1>
			<div>
				<table class="table">
					<tr class="tr">
						<th class="th">Polazak</th>
						<th class="th">Zavrsetak</th>
						<th class="th">Vreme</th>
						<th class="th">Prevoznik</th>
						<th class="th">Cena</th>
					</tr>					
				</table>
			</div>
		</div>
	</div>
</body>
</html>