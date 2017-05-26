<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>
<head>
<title>Novi Grad</title>
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
		<div class="contain">
			<h2>Dodajte novi grad (destinaciju):</h2>
			<form method="post" action="GradServlet">
				<table>
					<tr>
						<td><p>Naziv:</p></td>
						<td><input type="text" name="naziv"></td>
					</tr>															
					<tr>
						<td><input type="reset" name="reset" value="Obriši"></td>
						<td><input type="submit" name="submit" value="Dodaj"></td>
					</tr>
					
				</table>
				${porukaGrad}
			</form>			
		</div>				
	</div>	
<%@ include file="/resources/templates/footer.jsp" %>
