<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Nova Linija</title>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Expires" CONTENT="-1">
<link href="resources/css/Tema.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:useBean id="gradovi" class="customBeans.SviGradovi" scope="request" />	
	<div class="Box">
		<header>
			<img id="logo" src="resources/images/Logo.jpg">
		</header>
		<%@ include file="/resources/templates/menu.jsp" %>
		<div class="contain">
			<h2>Dodati novu liniju:</h2>
			<form method="post" action="UnosLinijeServlet">
				<table>
					<tr>
						<td>Grad:</td>
						<td><select name="gradovi">
								<c:forEach items="${gradovi.sviGradovi}" var="grad">
									<option value="${grad.idgrad}">${grad.naziv}</option>
								</c:forEach>
						</select></td>						
					</tr>
					<tr>
						<td><p>Naziv Linije:</p></td>
						<td><input type="text" name="nazivLinije"></td>
					</tr>
					<tr>
						<td><p>Datum Polaska:</p></td>
						<td><input name="datumPolaska" id="meeting" type="date" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" name="submit" value="Dodaj"></td>
					</tr>
				</table>
			</form>
			${porukaLinija}
		</div>
	</div>
<%@ include file="/resources/templates/footer.jsp" %>
