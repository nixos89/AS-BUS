<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">

<title>Logovanje</title>
</head>
<body>
<body>

	<div class="Box">
		
	 <img id="logo" src="resources/images/Logo.jpg">
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
		<li  id="standard">
			<a href="Logovanje.jsp"><i class="fa fa-registered"></i> Logovanje</a>	
		</li>
		<li id="veci">
			<a href="NoviPolasci.jsp"><i class="fa fa-plus"></i> Novi Polasci</a>
		
		</li >
		<li  id="veci1">
			<a href="CenaKarte.jsp"><i class="fa fa-pencil-square-o"></i> Modifikuj cene</a>
		
		</li>
		
	</ul>
		
		</div>
	<div class="contain">
	<br></br>
	<h2>Logovanje: </h2>
		<table>
			<tr>
				<td><p>Korisničko ime:</p></td>
				<td><input type="text" name="korisnicko _ime"></td>
			</tr>
			<tr>
				<td><p>Lozinka:</p></td>
				<td><input type="text" name="lozinka"></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td><input type="submit" name="submit" value="Dodaj"></td>
			</tr>
		</table>
		<br></br>
		<marquee><img src="resources/images/as-bus.jpg"></marquee>
</div>
	</div>	
</body>

</html>