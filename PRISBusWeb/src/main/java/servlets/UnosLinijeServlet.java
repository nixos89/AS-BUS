package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PolasciManager;
import model.Linija;

/**
 * Servlet implementation class UnosLinijeServlet
 */
public class UnosLinijeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosLinijeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idGrad =Integer.parseInt(request.getParameter("gradovi"));
		String naziv = request.getParameter("nazivLinije");
		String datum = request.getParameter("datumPolaska");
		boolean sacuvaj=false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date datump = sdf.parse(datum);
			sacuvaj = PolasciManager.sacuvajLinuju(idGrad, naziv, datump);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String porukaLinija=null;
		if(sacuvaj)
			porukaLinija="Uspesno ste sacuvali liniju.";
		else
			porukaLinija="Doslo je do greske, nije nista sacuvano.";
			request.setAttribute("porukaLinija", porukaLinija);
		request.getRequestDispatcher("UnosLinije.jsp").forward(request, response);
		
	}

}
