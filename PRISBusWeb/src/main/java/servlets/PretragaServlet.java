package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PolasciManager;
import model.Polazak;

/**
 * Servlet implementation class PretragaServlet
 */
public class PretragaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PretragaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			System.out.println("Usao u doGet metod...");
			request.getSession().getServletContext();
			int idGrad = Integer.parseInt(request.getParameter("destinacija"));
			String datumStr = request.getParameter("datumPolaska");
			Date datumP = null;
			String porukaPretraga = null;
			
			try{
				System.out.println("\n...usao sam u 2. try !!!");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				datumP = sdf.parse(datumStr);
				List<Polazak> polasci = new PolasciManager().vratiPolaskeZaDatumIDestinaciju(idGrad, datumP);
				if(polasci.isEmpty()){
					porukaPretraga = "Nema polazaka za zadate parametre!";
					request.setAttribute("porukaPretraga", porukaPretraga);
					request.getRequestDispatcher("PretragaPolazaka.jsp").forward(request, response);
				}else{//NIJE prazan
					request.setAttribute("polasci", polasci);
					request.getRequestDispatcher("PretragaPolazaka.jsp").forward(request, response);
				}										
//			}catch(DateTimeParseException e){
//				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
//			List<Polazak> polasci = new PolasciManager().vratiPolaskeZaDatumIDestinaciju(idGrad, datumP);
//			if(polasci.isEmpty()){
//				porukaPretraga = "Nema polazaka za zadate parametre!";
//				request.setAttribute("porukaPretraga", porukaPretraga);
//				request.getRequestDispatcher("Pretraga.jsp").forward(request, response);
//			}else{//NIJE prazan
//				request.setAttribute("polasci", polasci);
//				request.getRequestDispatcher("Pretraga.jsp").forward(request, response);
//			}			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
