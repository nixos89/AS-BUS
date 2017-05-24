package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.RezervacijaKarteManager;
import model.Radnik;

/**
 * Servlet implementation class DnevniProfitRadnikaServlet
 */
public class DnevniProfitRadnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DnevniProfitRadnikaServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Radnik r = (Radnik) request.getSession().getAttribute("radnik");
		double dnevniProfit = new RezervacijaKarteManager().getDnevniProfit(new Date(), r);
		String porukaProfit=null;
		if(r!=null && dnevniProfit!=-1)
			porukaProfit = "Vas ostvareni profit od danasnje prodaje karata iznosi: " + dnevniProfit;			
		else
			porukaProfit = "Zao nam je, ali danas niste ostvarili ni jednu prodaju.\nVise srece drugi put";
		
		request.setAttribute("porukaProfit", porukaProfit);
		request.getRequestDispatcher("ProfilRadnika.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
