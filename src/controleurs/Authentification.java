package controleurs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Model;
import dao.VerifAuth;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		boolean auth= VerifAuth.IsCompteValid(login, password);
		
		if(!auth) {
//			response.sendRedirect(request.getContextPath() + "authentif.jsp");
			System.out.println("auth=false");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp" );
			rd.forward(request, response);
			
		}else {
			System.out.println("auth=true");
				HttpSession session = request.getSession(true);
				session.setAttribute("list", Model.getListeCas());
				RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/gestion.jsp" );
				rd.forward(request, response);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
