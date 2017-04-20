package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PolasciManager;

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
			boolean sacuvan =PolasciManager.sacuvajGrad(naziv);
			String poruka=null;
			if (sacuvan){
				poruka="Uspesno ste uneli Grad.";
				request.setAttribute("poruka",poruka);	
			}
			else{
				poruka="Dogodila se greska, grad nije sacuvan.";
				request.setAttribute("poruka", poruka);	
			}
			request.getRequestDispatcher("Grad.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
