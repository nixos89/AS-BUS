package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.JPAUtils;
import managers.Komentar7Manager;
import managers.PrevoznikManager;
import model.Komentar7;
import model.Prevoznik;
import model.Putnik;

/**
 * Servlet implementation class KomentariKorisnikaServlet
 */
public class KomentariKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public KomentariKorisnikaServlet() {
        super();
    }
    
    /* Ovaj metod izlistava SVE komentare za ODABRANOG Prevoznik-a */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int idPrevoznika = Integer.parseInt(request.getParameter("prevoznik"));			
			List<Komentar7> komentars = new PrevoznikManager().sviKomentariZaPrevoznika(idPrevoznika);
			String porukaKomentariZaPrevoznika=null;
			if(komentars.isEmpty()){
				porukaKomentariZaPrevoznika = "Ne postoje komentari za odabranog prevoznika!";
				request.setAttribute("porukaKomentariZaPrevoznika", porukaKomentariZaPrevoznika);
			}
			request.setAttribute("komentars", komentars);
			request.getRequestDispatcher("KomentariKorisnika.jsp").forward(request, response);			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/* Ovaj metod dodaje komentar KORISNIKA za PREVOZNIKA */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			EntityManager em = JPAUtils.getEntityManager();
			String tekstKomentara = request.getParameter("tekstKomentara");
			int idPrevoznika = Integer.parseInt(request.getParameter("prevoznik"));
			Prevoznik prevoznik = em.find(Prevoznik.class, idPrevoznika);
			Putnik putnik = (Putnik) request.getSession().getAttribute("korisnik");
			int ocena = Integer.parseInt(request.getParameter("ocena"));
			Date datumKom = new Date();
			Komentar7 komentar = new Komentar7Manager().sacuvajKomentar(datumKom, ocena, tekstKomentara, prevoznik, putnik);
			String porukaKomentar = null;
			if(komentar!=null)
				porukaKomentar = "Komentar je uspesno sacuvan!";
			else
				porukaKomentar = "GRESKA, komentar nije sacuvan!";
			request.setAttribute("porukaKomentar", porukaKomentar);
			request.getRequestDispatcher("KomentariKorisnika.jsp").forward(request, response);				
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
