package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PrevoznikManager;
import model.Komentar7;
import model.Prevoznik;

/**
 * Servlet implementation class KomentariKorisnikaServlet
 */
public class KomentariKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public KomentariKorisnikaServlet() {
        super();
    }

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// IMPLEMENTIRATI za dodavanje komentara
	}

}
