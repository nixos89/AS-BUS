<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">

<title>Cena Karte</title>
</head>
<body>
<body>
	<jsp:useBean id="polasci" class="customBeans.SviPolasci" scope="request"/> 
	<div class="Box">

		<img id="logo" src="resources/images/Logo.jpg">
		<%@ include file="/resources/templates/menu.jsp" %>
		<div class="contain">
			<h2>Kreirajte cenu za odgovarajuću kartu:</h2>
			<form method="post" action="CenaKarteServlet">

				<table>
					<tr>
						<td><p>Polazak:</p></td>
						<td>
							<select name="polazak">
								<c:forEach items="${polasci.sviPolasci}" var="polazak">
									<option value="${polazak.idpolaska}">${polazak.linija.nazivlinije} ${polazak.vremepolaska}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td><p>Tip karte:</p></td>
						<td>
							<select name="tipKarte">
								<option value="Penzionerska">Penzionerska</option>
								<option value="Studentska">Studentska</option>
								<option value="Povratna">Povratna</option>
								<option value="Redovna">Redovna</option>
							</select>						
						</td>
					</tr>
					<tr>
						<td><p>Cena karte:</p></td>
						<td><input type="text" name="cenaKarte"></td>
					</tr>


					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" name="submit" value="Dodaj"></td>
					</tr>

				</table>
				<br></br> 
				${porukaKarta}
			</form>
		</div>

		<center>
			<img id="kartice" src="resources/images/kartice.jpg">
		</center>
		<marquee>
			<h2>AS-BUS</h2>
		</marquee>
	</div>

</body>
</html>