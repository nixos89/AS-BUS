<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<div class="menu">
	<!-- Ako ne bude htelo proverom objekta iz sesije onda kao parametere u URL upitu proslediti
		 putnik.user i putnik.pass -->
	<ul id="menu">
		<c:choose>
			<c:when test="${korisnik!=null}" >
				<li id="standard"><a href="index.jsp"><i class="fa fa-home"></i>Početna</a></li>
				<li id="standard"><a href="ProfilKorisnika.jsp"><i class="fa fa-home"></i>Profil</a></li>
				<li id="standard"><a href="KomentariKorisnika.jsp"><i class="fa fa-home"></i>Komentari o prevoznicima</a></li>
				<li id="standard"><a href="PretragaPolazaka.jsp"><i class="fa fa-home"></i>Pretraga polazaka</a></li>
				<li id="standard"><a href="RezervacijaMesta.jsp"><i class="fa fa-home"></i>Rezervacija karte</a></li>			
				<li id="standard"><a href="LogInOutServlet?user=${korisnik.user}&pass=${korisnik.password}"><i class="fa fa-plus"></i>Odjava</a></li>
			</c:when>		
			<c:when test="${radnik!=null}">
				<li id="standardR"><a href="index.jsp"><i class="fa fa-home"></i>Početna</a></li>
				<li id="standardR"><a href="ProdajaKarataZaRadnika.jsp"><i class="fa fa-home"></i>Prodaja karata</a></li>
				<li id="standardR"><a href="PretragaPolazaka.jsp"><i class="fa fa-home"></i>Pretraga polazaka</a></li>
				<li id="standardR"><a href="ProfilRadnika.jsp"><i class="fa fa-home"></i>Profil</a></li>		
				<li id="standardR"><a href="LogInOutServlet?user=${radnik.user}&&pass=${radnik.password}"><i class="fa fa-plus"></i>Odjava</a></li>
			</c:when>
			<c:when test="${admin!=null}" >
				<li id="standardA"><a href="index.jsp"><i class="fa fa-home"></i>Početna</a></li>
				<li id="standardA"><a href="PretragaPolazaka.jsp"><i class="fa fa-home"></i>Pretraga polazaka</a></li>
				<li id="standardA"><a href="Grad.jsp"><i class="fa fa-plus"></i>Dodaj Grad</a></li>
				<li id="standardA"><a href="UnosLinije.jsp"><i class="fa fa-plus"></i>Nova Linija</a></li>
				<li id="standardA"><a href="Prevoznik.jsp"><i class="fa fa-plus"></i>Novi Prevoznik</a></li>
				<li id="standardA"><a href="NoviPolasci.jsp"><i class="fa fa-plus"></i>Novi Polasci</a></li>
				<li id="standardA"><a href="UnosPovoljnosti.jsp"><i class="fa fa-plus"></i>Unos povoljnosti</a></li>
				<li id="standardA"><a href="CenaKarte.jsp"><i class="fa fa-plus"></i>Unos cena karata</a></li>
				<li id="standardA"><a href="LogInOutServlet?user=${admin.user}&pass=${admin.password}"><i class="fa fa-plus"></i>Odjava</a></li>
			</c:when>
			<c:otherwise>
				<li id="standardO"><a href="index.jsp"><i class="fa fa-home"></i>Početna</a></li>
				<li id="standardO"><a href="PretragaPolazaka.jsp"><i class="fa fa-home"></i>Pretraga polazaka</a></li>
				<li id="standardO"><a href="Logovanje.jsp"><i class="fa fa-home"></i>Prijava</a></li>
				<li id="standardO"><a href="Registracija.jsp"><i class="fa fa-home"></i>Registracija</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>