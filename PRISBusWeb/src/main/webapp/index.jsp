<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Početna</title>
</head>
<body>
	<jsp:useBean id="bestPrevoznici" class="customBeans.NajboljeOcenjeniPrevoznici"
		scope="application" />
	<div class="Box">
		<header> 
			<img id="logo" src="resources/images/Logo.jpg">
		</header>
		<%@ include file="/resources/templates/menu.jsp" %>
		<br></br>
		
		<h2 align="center">
			NAJBOLJI PREVOZNICI
			</h2>
				<table>
					<tr>
						<th>Prevoznik</th>
						<th>Ocena</th>
					</tr>
					<c:forEach items="${bestPrevoznici.najboljeOcenjeniPrevoznici}" var="best">				
						<tr>
							<td>${best.key.naziv}</td>
							<td>${best.value}</td>
						</tr>
					</c:forEach>	
				</table>
			
				
				<br></br>
				<img id="logo" align="center" src="resources/images/ponude.jpg">
       			<br></br>
       			<div class="text">
				<marquee>
					<h2>PUTUJTE UDOBNO I SIGURNO!</h2>
				</marquee>  
				</div>
	</div>			      
<%@ include file="/resources/templates/footer.jsp" %>