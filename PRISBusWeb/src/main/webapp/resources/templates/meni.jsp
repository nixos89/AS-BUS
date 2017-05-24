<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<div class="menu">
	<ul id="menu">
		<c:if test="${putnik}" var="${putnik}" scope="session">
			<li id="standard"><a href="Pocetna.jsp"><i class="fa fa-home"></i>Početna</a></li>
			<li id="standard"><a href="RezervacijaMesta.jsp"><i class="fa fa-home"></i>Rezervacija karte</a></li>			
			<li id="standard"><a href="LogOutServlet?${radnik}"><i class="fa fa-plus"></i>Odjava</a></li>
		</c:if>		
		<c:if test="${radnik}" scope="session">
			<li id="standard"><a href="Pocetna.jsp"><i class="fa fa-home"></i>Početna</a></li>
			
			<li id="standard"><a href="LogOutServlet?${radnik}"><i class="fa fa-plus"></i>Odjava</a></li>
		</c:if>
		<c:if test="${admin}" scope="session">
			<li id="standard"><a href="index.jsp"><i class="fa fa-home"></i>Početna</a></li>
			<li id="standard"><a href="Grad.jsp"><i class="fa fa-plus"></i>Dodaj Grad</a></li>
			<li id="standard"><a href="UnosLinije.jsp"><i class="fa fa-plus"></i>Nova Linija</a></li>
			<li id="standard"><a href="Prevoznik.jsp"><i class="fa fa-plus"></i>Novi Prevoznik</a></li>
			<li id="veci"><a href="NoviPolasci.jsp"><i class="fa fa-plus"></i>Novi Polasci</a></li>
			<li id="standard"><a href="CenaKarte.jsp"><i class="fa fa-plus"></i>Unos cena karata</a></li>
			<li id="standard"><a href="LogOutServlet?${admin}"><i class="fa fa-plus"></i>Odjava</a></li>
		</c:if>
		<c:if test="${!putnik or !radnik or !admin}">
			<li id="standard"><a href="index.jsp"><i class="fa fa-home"></i>Početna</a></li>
			<li id="standard"><a href="Logovanje.jsp"><i class="fa fa-home"></i>Prijava</a></li>
			<li id="standard"><a href="Registracija.jsp"><i class="fa fa-home"></i>Registracija</a></li>
			<li id="standard"><a href="LogOutServlet?${admin}"><i class="fa fa-plus"></i>Odjava</a></li>
		</c:if>
	</ul>
</div>