package controleurs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import covid.java.Cas;
import covid.java.tests.WrongCovidInputException;
import dao.Model;
import dao.VerifAuth;

/**
 * Servlet implementation class Ajout
 */
@WebServlet("/AjoutCas")
public class AjoutCas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutCas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		
		if(action.equals("link")) {

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ajoutCas.jsp" );
			rd.forward(request, response);
			return;
			
		}else {
			if(action.equals("ajouter")) {
				System.out.println("je tente d'ajouter");
				
				String nom = request.getParameter("nom");
				String adresse = request.getParameter("adresse");
				String code = request.getParameter("code_postale");
				String tel = request.getParameter("telephone");
				String etat= request.getParameter("etat");
				int etat2=Integer.parseInt(etat);
				
				try {
					Cas c = new Cas(nom, code, adresse, etat2, tel);
					Model.ajouterCas(c);
				} catch (WrongCovidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("error", e.getMessage());
					RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/ajoutCas.jsp" );
					rd.forward(request, response);
					return;
				}
				
				HttpSession session = request.getSession(true);
				session.setAttribute("list", Model.getListeCas());
				RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/gestion.jsp" );
				rd.forward(request, response);
				return;
				}
			else {
				System.out.println("mauvais attribut action pour ajout");
				RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/gestion.jsp" );
				rd.forward(request, response);
				return;
			}
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
