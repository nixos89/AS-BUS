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
		<li id="veci">
			<a href="NoviPolasci.jsp"><i class="fa fa-plus"></i> Novi Polasci</a>
		
		</li >
		<li  id="veci1">
			<a href="CenaKarte.jsp"><i class="fa fa-pencil-square-o"></i> Modifikuj cene</a>
		
		</li>
		
	</ul>
		
		</div>
        
<div class="contain1">
		<h2>Kreirajte cenu za odgovarajuću kartu: </h2>
		<form>

			<table>
				<tr>
					<td><p>ID karte: </p></td>
					<td><input type="text" name="idKarte"></td>
				</tr>
				<tr>
					<td><p>Id polaska: </p></td>
					<td><input type="text" name="idPolaska"></td>
				</tr>
				<tr>
					<td><p>Id prodaja: </p></td>
					<td><input type="text" name="idProdajaa"></td>
				</tr>
				<tr>
					<td><p>Tip karte: </p></td>
					<td><input type="text" name="tipKarte"></td>
				</tr>
				<tr>
					<td><p>Cena karte: </p></td>
					<td><input type="text" name="cenaKarte"></td>
				</tr>
				

				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="Dodaj"></td>
				</tr>
				
			</table>
			</form>
			</div>
	</div>
        <div>
	
		</div>
	
		


</body>
</html>