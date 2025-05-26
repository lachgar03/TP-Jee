package ma.projet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/LivreController")
public class LivreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LivreController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 PrintWriter out = response.getWriter();
	 response.setContentType("text/html");
	
	 String titre= request.getParameter("titre");
	 String categorie= request.getParameter("categorie");
	 int isbn = Integer.parseInt(request.getParameter("isbn"));
	 String nom= request.getParameter("nom");
	 String prenom= request.getParameter("prenom");
	 
	 out.println("<body> <h1>Validation d'un livre</h1>");
	 out.println("<h2>Le livre</h2>");
	 out.println("<p>Titre = "+ titre+"</p>");
	 out.println("<p>Categorie = "+ categorie+"</p>");
	 out.println("<p>Numéro ISBN = "+ isbn+"</p>");
	 out.println("<h2>L'auteur ....</h2>");
	 out.println("<p>Nom = "+ nom+"</p>");
	 out.println("<p>Prenom = "+prenom+"</p></body>");

	 


		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
