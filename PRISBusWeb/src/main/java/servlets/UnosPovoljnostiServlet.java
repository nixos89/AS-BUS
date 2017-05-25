package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 * Servlet implementation class UnosPovoljnostiServlet
 */
public class UnosPovoljnostiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UnosPovoljnostiServlet() {
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
				request.getRequestDispatcher("UnosPovoljnosti.jsp").forward(request, response);
			}else{// IMA trazenih polazaka
				request.setAttribute("trazeniPolasci", trazeniPolasci);
				request.getRequestDispatcher("UnosPovoljnosti.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idpolaska = Integer.parseInt(request.getParameter("idPolaska"));		
//		RezervacijaKarteManager rk = new RezervacijaKarteManager();
		String porukaPovoljnosti=null;
		List<Polazak> polasci = new ArrayList<Polazak>(); 
		
		if(!polasci.isEmpty()){ // ispravi da bude metod 'prodajKartu'			
			porukaPovoljnosti="Uspesno postavili povoljnosti!";
		}else{
			porukaPovoljnosti="GRESKA, povoljnosti nisu postavljene!";
		}
		request.setAttribute("porukaPovoljnosti", porukaPovoljnosti);
		request.getRequestDispatcher("UnosPovoljnosti.jsp").forward(request, response);
	}

}
