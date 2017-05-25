package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.RegistracijaManager;
import model.Putnik;
import model.Radnik;

/**
 * Servlet implementation class LogInOutServlet
 */
public class LogInOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogInOutServlet() {
        super();

    }

	/* Ovaj metod vrsi ODJAVU korisnika */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.getServletContext();
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			Radnik r = new RegistracijaManager().getRadnikZaUserPass(user, pass);
			Putnik p = new RegistracijaManager().getPutnikZaUserPass(user, pass);
			
			if(p!=null){
				request.getSession().removeAttribute("korisnik");
			}else if(r!=null){
				if(r.getUser().equals("admin") && r.getPassword().equals("admin")){
					request.getSession().removeAttribute("admin");					
				}else{
					request.getSession().removeAttribute("radnik");
				}	
			}
			/* 1. nacin: Ako imas vremena probaj ovako da bude upit ${user==korisnik} */
//			Object user = (Object) request.getParameter("user");
//			if(user.equals("korisnik"))
//				request.getSession().removeAttribute("korisnik");
//			else if(user.equals("radnik"))
//				request.getSession().removeAttribute("radnik");
//			else if(user.equals("admin"))
//				request.getSession().removeAttribute("admin");
			
			/* 2. nacin: Cupaj iz sesije, pa ga ukljanjaj */
//			Putnik p = (Putnik)request.getSession().getAttribute("korisnik");
//			Radnik r = (Radnik)request.getSession().getAttribute("radnik");
//			request.getSession().removeAttribute("korisnik");
			request.getRequestDispatcher("Logovanje.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	/* Ovaj metod vrsi PRIJAVU korsinika */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.getSession().getServletContext();
			String user = request.getParameter("korisnicko_ime");	
			String password = request.getParameter("lozinka");
			Putnik p = new RegistracijaManager().getPutnikZaUserPass(user, password);
			Radnik r = new RegistracijaManager().getRadnikZaUserPass(user, password);			
			String porukaError = null;
			
			if(p != null ){
				request.getSession().setAttribute("korisnik", p);
				request.getRequestDispatcher("ProfilKorisnika.jsp").forward(request, response);
			}else if(r!=null){
				if(r.getUser().equals("admin") && r.getPassword().equals("admin")){
					request.getSession().setAttribute("admin", r);
					request.getRequestDispatcher("Administrator.jsp").forward(request, response);					
				}else{
					request.getSession().setAttribute("radnik", r);
					request.getRequestDispatcher("ProfilRadnika.jsp").forward(request, response);
				}	
			}
			else{
				porukaError = "Greska, korisnik sa unetim paramterima ne postoji!";
				request.setAttribute("porukaError", porukaError);
				request.getRequestDispatcher("Logovanje.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}//doPost

}
