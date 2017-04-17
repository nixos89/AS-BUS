package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.RegistracijaManager;
import model.Putnik;

/**
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
			String user = request.getParameter("korisnicko _ime");	
			String password = request.getParameter("lozinka");
			boolean korisnikPostoji = new RegistracijaManager().logInPutnik(user, password);
			if(korisnikPostoji){
				request.getRequestDispatcher("registracija.jsp").forward(request, response);
				
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
