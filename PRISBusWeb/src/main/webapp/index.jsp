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
		<header> 
			<img id="logo" src="resources/images/Logo.jpg">
		</header>
		<%@ include file="/resources/templates/menu.jsp" %>
		<br></br>
		
		<h2 align="center">
			TOP PONUDA!
			</h2>
				<table class="table">
					<tr class="tr">
						<th class="th">Polazak</th>
						<th class="th">Dolazak</th>
						<th class="th">Vreme</th>
						<th class="th">Prevoznik</th>
						<th class="th">Cena</th>
					</tr>
					<tr class="tr">
						<th class="td">Novi Sad</th>
						<th class="td">Niš</th>
						<th class="td">15:35</th>
						<th class="td">Lasta</th>
						<th class="td">800</th>
					</tr>
				</table>
				<br></br>
				<div class="rating" align="center">
					<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
				</div>
				<div class="text">
				 <h3 align="center"><strong>Na osnovu ocena korisnika, najbolji prevoznik ovog meseca je: ${prevoznik.naziv}</strong></h3>
				</div>
				<br></br>
				<img id="logo" align="center" src="resources/images/ponude.jpg">
       			<br></br>
       			<div class="text">
				<marquee>
					<h2>PUTUJTE UDOBNO I SIGURNO!</h2>
				</marquee>  
				</div>      
<%@ include file="/resources/templates/footer.jsp" %>