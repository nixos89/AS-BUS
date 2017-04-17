<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
<body>
	<div class="Box">
		<header>
	 <img id="logo" src="resources/images/Logo.jpg">
		</header>
		<div class="menu">
		<ul id="menu">
		<li id="standard"><a href="Pocetna.jsp"><i class="fa fa-home"></i>Početna</a> 
		</li>
		<li id="standard">
			<a href="Pretraga.jsp"><i class="fa fa-search"></i> Pretraga</a>
			
		</li >
		<li  id="standard">
			<a href="Registracija.jsp"><i class="fa fa-registered"></i> Registracija</a>
			
		</li>
		<li id="veci">
			<a href="NoviPolasci.jsp"><i class="fa fa-plus"></i> Novi Polasci</a>
		
		</li >
		<li  id="veci1">
			<a href="CenaKarte.jsp"><i class="fa fa-pencil-square-o"></i> Modifikuj cene</a>
		
		</li>
		
	</ul>
		
		</div>
       

	<div class="pretraga">
	<br></br>
     <h2 class="sansserif" >Nađite odgovarajući autobus: </h2>
	<table>
		
		<tr>
			<td align="right">Od:</td>
			<td><select>
					<option value="va">Valjevo</option>
					<option value="bg">Beograd</option>
					<option value="ns">Novi Sad</option>
					<option value="sa" selected>Šabac</option>
			</select></td>
		</tr>
		<tr>
			<td align="right">Do:</td>
			<td><select>
					<option value="va">Valjevo</option>
					<option value="bg">Beograd</option>
					<option value="ns">Novi Sad</option>
					<option value="sa" selected>Šabac</option>
			</select></td>
		</tr>
		<tr>
			<td align="right">Datum polaska</td>
			<td><input id="meeting" type="date" value="2011-01-13 15:00" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" >Potvrdi</button>
			</td>

		</tr>
	</table>
	
       
        
	
		</div>
        <div>
    
    <h2>Rezultat pretrage: </h2>

        <div>
        <table class="table">
  <tr class="tr">
    <th class="th">Polazak</th>
    <th class="th">Završetak</th>
    <th class="th">Vreme</th>
    <th class="th">Prevoznik</th>
    <th class="th">Cena</th>

  </tr>
  <tr class="tr">
    <td class="td">Beograd</td>
    <td class="td">Niš</td>
    <td class="td">15:35</td>
    <td class="td">Lasta</td>
    <td class="td">1600</td>
  </tr>
  <tr class="tr">
    <td class="td">Niš</td>
    <td class="td">Beograd</td>
    <td class="td">21:00</td>
    <td class="td">Niš Ekspres</td>
    <td class="td">1600</td>
  </tr>
  <tr class="tr">
    <td class="td">Niš</td>
    <td class="td">Novi Sad</td>
    <td class="td">21:15</td>
    <td class="td">Niš Ekspres</td>
    <td class="td">2400</td>
  </tr>
</table>
<br></br>
 <img id="logo" src="resources/images/s2.jpg">
        </div></div>
		</div>
</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">

<title>Insert title here</title>
</head>
<body>
<body>

	
	<div class="Box">
		<header>
	 <img id="logo" src="resources/images/Logo.jpg">
		</header>
		<div class="menu">
		<ul id="menu">
		<li id="standard"><a href="Pocetna.jsp"><i class="fa fa-home"></i>Pocetna</a> 
		</li>
		<li id="standard">
			<a href="Pretraga.jsp"><i class="fa fa-search"></i> Pretraga </a>
			
		</li >
		<li  id="standard">
			<a href="Registracija.jsp"><i class="fa fa-registered"></i> Registracija</a>
			
		</li>
		<li id="veci">
			<a href="NoviPolasci.jsp"><i class="fa fa-plus"></i> Dodavanje Polazaka</a>
		
		</li >
		<li  id="veci1">
			<a href="CenaKarte.jsp"><i class="fa fa-pencil-square-o"></i> Modifikuj cene</a>
		
		</li>
		
	</ul>
		
		</div>
       

	<div class="pretraga">
	<br></br>
     <h2 class="sansserif" >Nadjite odgovarajuci autobus: </h2>
	<table>
		
		<tr>
			<td align="right">Od:</td>
			<td><select>
					<option value="va">Valjevo</option>
					<option value="bg">Beograd</option>
					<option value="ns">Novi Sad</option>
					<option value="sa" selected>Sabac</option>
			</select></td>
		</tr>
		<tr>
			<td align="right">Do:</td>
			<td><select>
					<option value="va">Valjevo</option>
					<option value="bg">Beograd</option>
					<option value="ns">Novi Sad</option>
					<option value="sa" selected>Sabac</option>
			</select></td>
		</tr>
		<tr>
			<td align="right">Datum polaska</td>
			<td><input id="meeting" type="date" value="2011-01-13 15:00" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" >Potvrdi</button>
			</td>

		</tr>
	</table>
	
       
        
	
		</div>
        <div>
    
    <h2>Rezultat pretrage</h2>

        <div>
        <table class="table">
  <tr class="tr">
    <th class="th">Polazak</th>
    <th class="th">Zavrsetak</th>
    <th class="th">Vreme</th>
    <th class="th">Prevoznik</th>
    <th class="th">Cena</th>

  </tr>
  <tr class="tr">
    <td class="td">Beograd</td>
    <td class="td">Nis</td>
    <td class="td">15:35</td>
    <td class="td">Lasta</td>
    <td class="td">1600</td>
  </tr>
  <tr class="tr">
    <td class="td">nis</td>
    <td class="td">Beograd</td>
    <td class="td">21:00</td>
    <td class="td">Nis Ekspres</td>
    <td class="td">1600</td>
  </tr>
  <tr class="tr">
    <td class="td">Nis</td>
    <td class="td">Novi Sad</td>
    <td class="td">21:15</td>
    <td class="td">Nis Ekspres</td>
    <td class="td">2400</td>
  </tr>

</table>
        </div></div>
		</div>
		
</body>
>>>>>>> branch 'TK-757' of https://github.com/nixos89/AS-BUS.git
</html>