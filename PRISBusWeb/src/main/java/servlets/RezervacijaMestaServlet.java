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
import model.Polazak;

/**
 * Servlet implementation class RezervacijaMestaServlet
 */
public class RezervacijaMestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public RezervacijaMestaServlet() {
        super();
        // TODO Auto-generated constructor stub
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
				request.getRequestDispatcher("RezervacijaMesta.jsp").forward(request, response);
			}else{// IMA trazenih polazaka
				request.setAttribute("trazeniPolasci", trazeniPolasci);
				request.getRequestDispatcher("RezervacijaMesta.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
