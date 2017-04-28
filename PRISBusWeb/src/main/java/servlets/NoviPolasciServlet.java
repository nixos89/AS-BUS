package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PolasciManager;
import model.Polazak;

/**
 * Servlet implementation class NoviPolasciServlet
 */
public class NoviPolasciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoviPolasciServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try{
			request.getSession().getServletContext();
			int idPrevoznika = Integer.parseInt(request.getParameter("idPrevoznika"));
			int idLinije = Integer.parseInt(request.getParameter("idLinije"));
			int idVrstePolaska = Integer.parseInt(request.getParameter("idVrstePolaska"));
			String vremePolaska = request.getParameter("vremePolaska");
			Date datumP=null;
			String porukaPolazak = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				datumP = sdf.parse(vremePolaska);
				Polazak pol = new PolasciManager().sacuvajPolazak(idPrevoznika, idLinije, idVrstePolaska, datumP);
				if(pol!=null)
					porukaPolazak = "Polazak je uspesno sacuvan!";
				else
					porukaPolazak = "Greska, polazak NIJE sacuvan!";
				request.setAttribute("porukaPolazak", porukaPolazak);
				request.getRequestDispatcher("NoviPolasci.jsp").forward(request, response);
			} catch (Exception e){
				e.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
