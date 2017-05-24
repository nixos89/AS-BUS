package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managers.RegistracijaManager;
import model.Putnik;
import model.Radnik;

/**
 * @author Slobodan Babic
 * 
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LogInServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.getSession().getServletContext();
//			HttpSession session = request.getSession();
//			Putnik putnik = (Putnik) session.getAttribute("putnik");
			String user = request.getParameter("korisnicko_ime");	
			String password = request.getParameter("lozinka");
			Putnik p = new RegistracijaManager().getPutnikZaUserPass(user, password);
			Radnik r = new RegistracijaManager().getRadnikZaUserPass(user, password);
			
			String porukaError = null;
			if(p != null ){
				request.getSession().setAttribute("korisnik", p);
				request.getRequestDispatcher("ProfilKorisnika.jsp").forward(request, response);
			}else if(r!=null){
				if(r.getUser().equals("admin") && r.getPassword().equals("admin"))
					request.getSession().setAttribute("admin", r);
				else
					request.getSession().setAttribute("radnik", r);
				request.getRequestDispatcher("ProfilRadnika.jsp").forward(request, response);
			}
			else{
				porukaError = "Greska, korisnik sa unetim paramterima ne postoji!";
				request.setAttribute("porukaError", porukaError);
				request.getRequestDispatcher("Logovanje.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
