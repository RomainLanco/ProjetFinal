package controleurs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import covid.java.Cas;
import covid.java.TestPcr;
import dao.Model;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_database = Integer.parseInt(request.getParameter("id_database"));
		System.out.println(id_database);
		Cas c = Model.chercherCas(id_database);
		//set attribute Cas
		String nom = c.getNom_complet();
		String adresse = c.getAdresse();
		String code = c.getCode_postale();
		String tel = c.getTelephone();
		int etat= c.getEtat();
		request.setAttribute("id_database", id_database);
		request.setAttribute("nom", nom);
		request.setAttribute("adresse", adresse);
		request.setAttribute("code_postale", code);
		request.setAttribute("telephone", tel);
		request.setAttribute("etat", etat);
		
		//set attribute list PCR
		ArrayList<TestPcr> listPcr = Model.getListePcr(id_database);
//		ArrayList<TestPcr> listPcrCas = new ArrayList<TestPcr>();
		
//		for(TestPcr t : listPcr) {
//			if(t.getId_teste()==id_database) {
//				listPcrCas.add(t);
//			}
//		}
		request.setAttribute("listPcrCas", listPcr);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/details.jsp" );
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
