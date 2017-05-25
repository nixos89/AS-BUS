<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Administrator</title>
	<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta HTTP-EQUIV="Expires" CONTENT="-1">
	<link href="resources/css/Tema.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="Box">
		<header>
			<img id="logo" src="resources/images/Logo.jpg">
		</header>
		<%@ include file="/resources/templates/menu.jsp" %>
		<br/><br/>
		<div class="rezervacija1">
			<p>
				<strong>Ime:</strong> <label for="ime">${admin.ime}</label>
			</p>
			<p>
				<strong>Prezime: </strong><label for="prezime">${admin.prezime}</label>
			</p>
			<p>NAPOMENA: Mozete da unosite nove linije, gradove, polaske i modifikujete cene karata</p>
		</div>
	</div>


<%@ include file="/resources/templates/footer.jsp" %>