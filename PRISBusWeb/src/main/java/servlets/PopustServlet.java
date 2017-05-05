package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PopustManager;

//@Nevena
public class PopustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PopustServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.getSession().getServletContext();
			String user = request.getParameter("korisnicko_ime");	
			String password = request.getParameter("lozinka");
			Integer brkarata = Integer.parseInt(request.getParameter("brkarata"));
			boolean korisnikPostoji = new PopustManager().getObavestiZaPopust(user, password, brkarata);
			String porukaError = null;
			if(korisnikPostoji){			
				request.getRequestDispatcher("RezervacijaMesta.jsp").forward(request, response);
			}else{
				porukaError = "Niste jos uvek ostvarili popust!";
				request.setAttribute("porukaError", porukaError);
				request.getRequestDispatcher("RezervacijaMesta.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
