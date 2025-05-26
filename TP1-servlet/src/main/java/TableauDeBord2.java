

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TableauDeBord2")
public class TableauDeBord2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TableauDeBord2() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		Double taille = (Double) session.getAttribute("taille");
		Double poid = (Double) session.getAttribute("poid");
		Double imc = (Double) session.getAttribute("imc");
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Tableau de Bord</title></head><body>");
		out.println("<h2>Tableau de Bord</h2>");

		if (poid != null && taille != null && imc != null) {
		     out.println("<p>Poids : " + poid + " kg</p>");
		     out.println("<p>Taille : " + taille + " m</p>");
		     out.println("<p>IMC : " + imc + "</p>");
		  } else {
		     out.println("<p>Aucune donnée enregistrée. Veuillez calculer votre IMC.</p>");
		  }

		     out.println("</body></html>");

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
