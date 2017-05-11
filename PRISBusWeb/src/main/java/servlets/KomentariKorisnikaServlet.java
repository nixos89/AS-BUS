package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prevoznik;

/**
 * Servlet implementation class KomentariKorisnikaServlet
 */
public class KomentariKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public KomentariKorisnikaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// aj sad...
		List<Prevoznik> prevoznici = null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
