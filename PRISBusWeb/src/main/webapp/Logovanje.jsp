<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/css/Tema.css" type="text/css">
	<title>Prijava</title>
</head>
<body>
<body>
	<div class="Box">
		<img id="logo" src="resources/images/Logo.jpg">
		<%@ include file="/resources/templates/menu.jsp"%>
		<div class="contain">
			<br></br>
			<h2>Logovanje:</h2>
			<form action="LogInOutServlet" method="post">
				<table>
					<tr>
						<td><p>Korisničko ime:</p></td>
						<td><input type="text" name="korisnicko_ime"></td>
					</tr>
					<tr>
						<td><p>Lozinka:</p></td>
						<td><input type="password" name="lozinka"></td>
					</tr>
					<tr>
						<td><input type="submit" name="submit" value="Prijavite se"></td>
						<td><input type="reset" name="submit" value="Obriši"></td>
					</tr>
				</table>
				${porukaError}
			</form>
			<br></br>
			<marquee>
				<img src="resources/images/as-bus.jpg">
			</marquee>
		</div>
	</div>
<%@ include file="/resources/templates/footer.jsp" %>