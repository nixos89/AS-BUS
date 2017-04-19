package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PolasciManager;
import model.Polazak;
import model.Vrstapolaska;

/**
 * Servlet implementation class SacuvajVrstuPolaskaServlet
 */
public class SacuvajVrstuPolaskaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SacuvajVrstuPolaskaServlet() {
        super();
    }

	/* Cuva polazak u bazu */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.getSession().getServletContext();
			String nazivVrste = request.getParameter("nazivVrste");
			Vrstapolaska unetaVrstaP = new PolasciManager().nazivVrstePolaska(nazivVrste);
			String nazivUneteVP = unetaVrstaP.getVrsta();
			String porukaVrstaPol = null;
			if(nazivUneteVP.equals(nazivVrste)){
				porukaVrstaPol="Polazak " + nazivVrste + " je VEC sacuvan u bazi, molimo Vas odaberite drugi naziv!";			
				response.sendRedirect("VrstePolazaka.jsp");
//				request.setAttribute("porukaVrstaPol", porukaVrstaPol);
//				request.getRequestDispatcher("VrstePolazaka.jsp").forward(request, response);
			}else{
				Vrstapolaska pol = new PolasciManager().sacuvajVrstuPolaska(nazivVrste);
				if(pol!=null){
					porukaVrstaPol="Polazak "+pol.getVrsta()+" je uspesno sacuvan!";
					request.setAttribute("porukaVrstaPol", porukaVrstaPol);
					request.getRequestDispatcher("VrstePolazaka.jsp").forward(request, response);

				}else{
					porukaVrstaPol="Greska, polazak NIJE sacuvan!";
					request.setAttribute("porukaVrstaPol", porukaVrstaPol);
					request.getRequestDispatcher("VrstePolazaka.jsp").forward(request, response);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Greska, dogodio se nekakav exception...");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
