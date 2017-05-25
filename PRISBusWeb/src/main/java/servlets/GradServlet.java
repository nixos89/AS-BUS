package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PolasciManager;
import model.Grad;

/**
 * Servlet implementation class GradServlet
 */
public class GradServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradServlet() {
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
		try {
			String naziv = request.getParameter("naziv");		
			List<Grad> gradovi = new PolasciManager().sviGradovi();
			boolean sacuvan =PolasciManager.sacuvajGrad(naziv);
			String porukaGrad=null;
			if (sacuvan){
				porukaGrad="Uspesno ste uneli Grad.";
				request.setAttribute("porukaGrad",porukaGrad);	
			}
			else{
				porukaGrad="Dogodila se greska, grad nije sacuvan.";
				request.setAttribute("porukaGrad", porukaGrad);	
			}
			request.getRequestDispatcher("Grad.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
