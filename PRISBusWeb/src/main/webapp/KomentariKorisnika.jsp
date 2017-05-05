<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
<title>Komentari korisnika</title>
</head>
<body>
	<div class="Box">
		<img id="logo" src="resources/images/Logo.jpg">
		<div class="menu">
			<ul id="menu">
				<li id="standard"><a href="Pocetna.jsp"><i
						class="fa fa-home"></i>Početna</a></li>
				<li id="standard"><a href="Pretraga.jsp"><i
						class="fa fa-search"></i> Pretraga</a></li>
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
		<h2 align="center"><strong>Odaberite prevoznika: </strong></h2>
		<p align="center">
					<select autofocus>
						<option value="bg">LASTA</option>
						<option value="ns">NIŠ EKSPRES</option>
						<option value="sa">EUROLINES</option>
						<option value="va">BANBUS</option>
						<option value="so">FENIKS G&Z</option>
						<option value="ni">AUTOKODEKS</option>
						<option value="so">DUNAV PREVOZ</option>
						<option value="ni">SEVERTRANS</option>
						<option value="so">BEČEJ PREVOZ</option>
						<option value="ni">DUGA TRANS</option>
					</select>
			</p>
			<br></br>
			<div class="rezervacija2">
		<form action="">
  			Username: * <input type="text" name="ime"><br></br>
  			<table>
  				<tr>
  				<td><h4>Komentar:</h4></td>
  				<td><textarea cols="65" rows="5">Ovde unesite Vaš komentar</textarea></td>
  				<td><input type="hidden" name="skriveno" value="skrivenopolje"></td>
  				<td>&nbsp;</td>
  				</tr>
  			</table>
  			<div class="rating">
				<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
			</div>
  			<input type="submit" name="Potvrdi" value="Potvrdi">
  			<input type="reset" name="Odustani" value="Odustani">
		</form>
		</div>
</body>
</html>