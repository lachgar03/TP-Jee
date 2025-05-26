

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/TableauDeBord")
public class TableauDeBord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TableauDeBord() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out =response.getWriter();
	response.setContentType("text/html");
	
	Cookie[] cookies=request.getCookies();
	String taille=null,poid=null,imc=null;
	for(var cookie:cookies) {
		switch(cookie.getName()) {
		case "poids":
			poid=cookie.getValue();
			break;
		case "taille":
			taille=cookie.getValue();
			break;
		case "imc"	:
			imc=cookie.getValue();
			break;
		}
	}
	
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
