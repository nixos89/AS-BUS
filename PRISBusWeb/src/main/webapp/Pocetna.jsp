<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Početna</title>
</head>
<body>

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
				<li id="veci1"><a href="CenaKarte"><i
						class="fa fa-pencil-square-o"></i> Modifikuj cene</a></li>
			</ul>

		</div>
		<h2 id="naslov">
			TOP PONUDA!
			<h2>
				<table class="table">
					<tr class="tr">
						<th class="th">Polazak</th>
						<th class="th">Završetak</th>
						<th class="th">Vreme</th>
						<th class="th">Prevoznik</th>
						<th class="th">Cena</th>

					</tr>
					<tr class="tr">
						<td class="td">Novi Sad</td>
						<td class="td">Niš</td>
						<td class="td">15:35</td>
						<td class="td">Lasta</td>
						<td class="td">800</td>
					</tr>

					
					<div>
				</table>
				<marquee>
					<p id="text">PUTUJTE UDOBNO I SIGURNO!</p>
				</marquee>
				<img id="logo" align="center" src="resources/images/ponude.jpg">

				<h2 id="naslov1">Najisplativiji prevoznik!</h2>
				<h3 id="naslov1">Ovog meseca iz ponude izdvajamo:</h3>

				<table class="table">
					<tr class="tr">
						<th class="th">Prevoznik</th>
						<th class="th">Prosečna cena karte</th>
						<th class="th">U proseku jeftiniji od</th>
					</tr>
					<tr class="tr">
						<td class="td">Lasta</td>
						<td class="td">1000</td>
						<td class="td">15%</td>
					</tr>
				</table>
	</div>
</body>
</html>