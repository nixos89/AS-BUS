<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">

<title>Profil</title>
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
	<h2>Vaš profil: </h2>
		<img src="resources/images/profile.png">
		 
		<p><strong>Ime:</strong>  <label for="ime">Marko</label> </p>
        <p><strong>Prezime: </strong><label for="prezime">Marković</label> </p>
        <p><strong>Broj karata: </strong><label for="brKarata">2</label> </p>
		<form action="Logout" method="post">
		<br></br>
			<input type="submit" value="Logout" > <!-- SREDI OVO da bude preko Servlet-a ODJAVLJIVANJE!!!!!!!!!! -->		
		</form>
		<br>
	</div>
		<marquee><img src="resources/images/as-bus.jpg"></marquee>
	</div>	
</body>

</html>
