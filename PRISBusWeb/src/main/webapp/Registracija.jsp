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
		
	 <img id="logo" src="resources/images/Logo.jpg">
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
        <div class="contain">
		<h1>Registruj se</h1>
		<form>

			<table>
				<tr>
					<td><p>Ime</p></td>
					<td><input type="text" name="ime"></td>
				</tr>
				<tr>
					<td><p>Prezime</p></td>
					<td><input type="text" name="prezime"></td>
				</tr>
				<tr>
					<td><p>Korisničko ime</p></td>
					<td><input type="text" name="korisnicko _ime"></td>
				</tr>
				<tr>
					<td><p>Lozinka</p></td>
					<td><input type="text" name="lozinka"></td>
				</tr>
				<tr>
					<td><p>Ponovi lozinku</p></td>
					<td><input type="text" name="ponLozinku"></td>
				</tr>
				<tr>
					<td><p>Adresa</p></td>
					<td><input type="text" name="adresa"></td>
				</tr>
				<tr>
					<td><p>Telefon</p></td>
					<td><input type="text" name="telefon"></td>
				</tr>


				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="Dodaj"></td>
				</tr>
			</table>
		</form>
	</div>

	<div class="contain">
	<h1>Login </h1>
		<table>
			<tr>
				<td><p>Korisničko ime</p></td>
				<td><input type="text" name="korisnicko _ime"></td>
			</tr>
			<tr>
				<td><p>Lozinka</p></td>
				<td><input type="text" name="lozinka"></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td><input type="submit" name="submit" value="Dodaj"></td>
			</tr>
		</table>

</div>
	</div>
        <div>
	
		</div>
	
		


</body>
</html>