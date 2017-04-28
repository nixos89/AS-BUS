package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PolasciManager;

/**
 * Servlet implementation class PrevoznikServlet
 */
public class PrevoznikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrevoznikServlet() {
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
		String naziv = request.getParameter("naziv");
		int brMesta = Integer.parseInt(request.getParameter("brMesta"));
		boolean sacuvan =PolasciManager.sacuvajPrevoznika(naziv, brMesta);
		String poruka=null;
		if (sacuvan){
			poruka="Uspesno ste sacuvali Prevoznika.";
			request.setAttribute("poruka",poruka);	
		}
		else{
			poruka="Dogodila se greska, prevoznik nije sacuvan";
			request.setAttribute("poruka", poruka);	
		}
		request.getRequestDispatcher("Prevoznik.jsp").forward(request, response);
			
	}

}
