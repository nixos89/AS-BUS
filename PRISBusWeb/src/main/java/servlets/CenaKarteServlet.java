package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PolasciManager;

/**
 * Servlet implementation class CenaKarteServlet
 */
public class CenaKarteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenaKarteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.getSession().getServletContext();
			int cenaKarte = Integer.parseInt(request.getParameter("cenaKarte"));
			int idPolaska = Integer.parseInt(request.getParameter("polazak"));
			String tipKarte = request.getParameter("tipKarte");
			boolean sacuvana = new PolasciManager().
					snimiCenuKarte(cenaKarte, tipKarte, idPolaska);
			String porukaKarta = null;
			if(sacuvana)
				porukaKarta="Karta je uspesno sacuvana!";
			else
				porukaKarta="Greska, karta NIJE sacuvana!";
			request.setAttribute("porukaKarta", porukaKarta);
			request.getRequestDispatcher("CenaKarte.jsp").forward(request, response);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
