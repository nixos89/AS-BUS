package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.RegistracijaManager;
import model.Putnik;
import model.Radnik;

/**
 * Servlet implementation class LogOutServlet
 */
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.getServletContext();
			request.getSession().removeAttribute("korisnik");
			request.getRequestDispatcher("Logovanje.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
					request.getSession().setAttribute("radnik", r);
				}	
			}
//			Object o = (Object) request.getParameter("user");
//			if(o.equals("korisnik"))
//				request.getSession().removeAttribute("korisnik");
//			else if(o.equals("radnik"))
//				request.getSession().removeAttribute("radnik");
//			else if(o.equals("admin"))
//				request.getSession().removeAttribute("admin");
//			Putnik p = (Putnik)request.getSession().getAttribute("korisnik");
//			Radnik r = (Radnik)request.getSession().getAttribute("radnik");
//			request.getSession().removeAttribute("korisnik");
			request.getRequestDispatcher("Logovanje.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
