<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
<title>Online rezervacija</title>
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
		<h2 align="center"> ONLINE REZERVACIJA AUTOBUSKE KARTE </h2>
			<div class="rezervacija1">
			<table width="500">
					<tr>
					<td>
					<label for="polazak">Polazak: </label>
					</td>
					<td>
					<select autofocus>
						<option value="bg">BEOGRAD</option>
						<option value="ns">NOVI SAD</option>
						<option value="sa">ŠABAC</option>
						<option value="va">VALJEVO</option>
						<option value="so">SOMBOR</option>
						<option value="ni">NIŠ</option>
					</select>
					</td>
					</div>	
				<div class="datum"> 
				<td>
				<label>Datum polaska:</label>
				</td>
				<td>
				<input id="datePick" type="date" value="2011-01-13"/>
				<td>
				</div>	
				<tr>		
					<div class="rezervacija1">
					<td>
					<label for="dolazak">Dolazak: </label>
					</td>
					<td>
					<select autofocus>
						<option value="bg">BEOGRAD</option>
						<option value="ns">NOVI SAD</option>
						<option value="sa">ŠABAC</option>
						<option value="va">VALJEVO</option>
						<option value="so">SOMBOR</option>
						<option value="ni">NIŠ</option>
					</select>
					</td>
					</div>	
			
			<div class="datum">
				<td>
				<label>Datum dolaska: </label>
				</td>
				<td>
				<input id="datePick" type="date" value="2011-01-13"/>
				</td>
			</div>
	</table>	
	<div class="vrstaKarte">
		<p><h3>Izaberite vrstu karte:</h3></p>

			<label for="redovna">Redovna:</label> 
			<input type="radio" name="vrstaKarte" id="redovna" value="Redovna"><br>
			<label for="povratna">Povratna:</label> 
			<input type="radio" name="vrstaKarte" id="povratna" value="Povratna"><br>
			<label for="studentskaJ">Studentska:</label> 
			<input type="radio" name="vrstaKarte" id="studentskaJ" value="StudentskaJ"><br>
			<label for="studentskaPovratna">Studentska povratna:</label> 
			<input type="radio" name="vrstaKarte" id="studentskaP" value="StudentskaP"><br>
			<label for="penzionerskaJ">Penzionerska:</label> 
			<input type="radio" name="vrstaKarte" id="penzionerskaJ" value="PenzionerskaJ"><br>
			<label for="penzionerskaP">Penzionerska povratna:</label> 
			<input type="radio" name="vrstaKarte" id="penzionerskaP" value="PenzionerskaP"><br>
			<label for="sezonska">Sezonska:</label> 
			<input type="radio" name="vrstaKarte" id="sezonska" value="Sezonska"><br>
		</div>
		<table>
			<tr>
			<td><p><strong>Broj karata: </strong></p></td>
			<td><input type="text" value=""></td>
			</tr>
		</table>
		<div class="rezervacija2">
		<form action="">
		<p>Ukoliko rezervišete kartu na drugo ime, molimo unesite:</p>
  			Ime putnika: * <input type="text" name="ime"><br></br>
  			Prezime putnika: *<input type="text" name="prezime"><br></br>
  			Email adresa putnika: <input type="text" name="email"><br></br>
  			<table>
  				<tr>
  				<td><h4>Napomena:</h4></td>
  				<td><textarea cols="50" rows="4">Ovde unesite Vašu napomenu (Napr. student--> br.Indexa, želimo mesto u šaragama,..)</textarea></td>
  				<td><input type="hidden" name="skriveno" value="skrivenopolje"></td>
  				<td>&nbsp;</td>
  				</tr>
  			</table>
  			<input type="submit" name="Potvrdi" value="Potvrdi">
  			<input type="reset" name="Odustani" value="Odustani">
		</form>
		</div>
		</form>
</body>
</html>