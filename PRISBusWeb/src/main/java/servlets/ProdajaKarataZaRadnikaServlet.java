package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.JPAUtils;
import managers.PolasciManager;
import managers.RezervacijaKarteManager;
import model.Polazak;
import model.Prodaja;
import model.Radnik;

/**
 * Servlet implementation class ProdajaKarataZaRadnikaServlet
 */
public class ProdajaKarataZaRadnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProdajaKarataZaRadnikaServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			EntityManager em = JPAUtils.getEntityManager();
			int idGrad = Integer.parseInt(request.getParameter("polazak"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String datumPolaskaStr = request.getParameter("datumPolaska");
			Date datumPolaska = sdf.parse(datumPolaskaStr);
			String vrstaKarte = request.getParameter("vrstaKarte");
			List<Polazak> trazeniPolasci = new PolasciManager().getTrazeniPolasci(idGrad,datumPolaska,vrstaKarte);
			String porukaNemaPol = null;
			if(trazeniPolasci.isEmpty()){
				porukaNemaPol = "Nema polazaka za odabrane paramtere!";
				request.setAttribute("porukaNemaPol", porukaNemaPol);
				request.getRequestDispatcher("ProdajaKarataZaRadnika.jsp").forward(request, response);
			}else{// IMA trazenih polazaka
				request.setAttribute("trazeniPolasci", trazeniPolasci);
				request.getRequestDispatcher("ProdajaKarataZaRadnika.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idpolaska = Integer.parseInt(request.getParameter("idPolaska"));		
		int brkarata = Integer.parseInt(request.getParameter("brKarata"));		
		Radnik radnik = (Radnik)request.getSession().getAttribute("radnik");
		int cenaKarte = Integer.parseInt(request.getParameter("cenaKarte"));
		RezervacijaKarteManager rk = new RezervacijaKarteManager();
		String poruka=null;
		String popust=null;
		Prodaja prodaja = rk.prodajKartu(idpolaska, brkarata, cenaKarte, radnik);
		if(prodaja!=null){ // ispravi da bude metod 'prodajKartu'			
			poruka="Uspesno ste prodali karte!";
		}else{
			poruka="Doslo je do greske, niste rezervisali kartu!";
		}
		request.setAttribute("poruka", poruka);
		request.setAttribute("popust", popust);
		request.getRequestDispatcher("ProdajaKarataZaRadnika.jsp").forward(request, response);
	}//doPost

}
