package controleurs;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import covid.java.Cas;
import covid.java.TestPcr;
import covid.java.tests.WrongCovidInputException;
import dao.Model;

/**
 * Servlet implementation class AjoutTest
 */
@WebServlet("/AjoutTest")
public class AjoutTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String action = request.getParameter("action");
int id_database = Integer.parseInt(request.getParameter("id_database"));
		
		if(action.equals("link")) {
			request.setAttribute("id_database", id_database);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ajoutTest.jsp" );
			rd.forward(request, response);
			
		}else {
			if(action.equals("ajouter")) {
				System.out.println("je tente d'ajouter");
				
				String date = request.getParameter("dateTest");
				System.out.println(date);
				int annee = Integer.parseInt(date.substring(0, 4));
				System.out.println(annee);
				int mois = Integer.parseInt(date.substring(5, 7));
				System.out.println(mois);
				int jour = Integer.parseInt(date.substring(8));
				System.out.println(jour);
				
				String res = request.getParameter("resultat");
				int resultat =Integer.parseInt(res);
				
				
				
				try {
					TestPcr t = new TestPcr(jour, mois, annee, id_database, resultat);
					Model.ajouterTestPcr(t);
					
					HttpSession session = request.getSession(true);
					session.setAttribute("list", Model.getListeCas());
					RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/gestion.jsp" );
					rd.forward(request, response);
				} catch (WrongCovidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("error", e.getMessage());
					RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/ajoutTest.jsp" );
					rd.forward(request, response);
				}
				
				
			}
		}
			
				
				
//				try {
//					Cas c = new Cas(nom, code, adresse, etat2, tel);
//					Model.ajouterCas(c);
//				} catch (WrongCovidInputException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				HttpSession session = request.getSession(true);
//				session.setAttribute("list", Model.getListeCas());
//				RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/gestion.jsp" );
//				rd.forward(request, response);
//				}
//			else {
//				System.out.println("mauvais attribut action pour ajout");
//				RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/gestion.jsp" );
//				rd.forward(request, response);
//			}
//			}
//	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
