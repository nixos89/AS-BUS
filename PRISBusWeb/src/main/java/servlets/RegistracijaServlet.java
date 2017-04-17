package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.RegistracijaManager;
import model.Putnik;

/**
 * Servlet implementation class RegistracijaServlet
 */
public class RegistracijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistracijaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.getSession().getServletContext();
			String ime = request.getParameter("ime");
			String prezime = request.getParameter("prezime");
			String user = request.getParameter("korisnicko _ime");
			String pass = request.getParameter("lozinka");			
			Putnik p = (Putnik) new RegistracijaManager().sacuvajPutnika(ime, prezime, user, pass);
			String porukaReg = null;
			if(p!=null){
				request.getRequestDispatcher("Registracija.jsp").forward(request, response);
				porukaReg = "Korisnik "+ p.getIme()+" "+p.getPrezime()+" je uspesno sacuvan!";
			}else{
				request.getRequestDispatcher("Registracija.jsp").forward(request, response);
				request.setAttribute("porukaReg", porukaReg);
				porukaReg = "Greska, korisnik NIJE sacuvan!";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
