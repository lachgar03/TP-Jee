

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebServlet("/CalculDeMonImc2")
public class CalculDeMonImc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CalculDeMonImc2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();

		String tailleSt = request.getParameter("taille");
		String poidSt = request.getParameter("poid");
		
		double imc = 0;
		//Pour convertir un string a un double
		double taille = Double.parseDouble(tailleSt);
		double poid = Double.parseDouble(poidSt);
		
		Imc calcul1=new Imc(taille,poid);
	    imc=calcul1.calcul();
	    
	    //Pour la creation de mon session
	    HttpSession session =request.getSession();
	    session.setAttribute("poid",poid);
	    session.setAttribute("taille",taille);
	    session.setAttribute("imc",imc);
	     
		out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Résultat IMC</title></head><body>");
        out.printf("<h1>Votre Résultat de IMC est </h1>");
        out.printf("<p>Votre IMC est :"+imc+"</p>");
        out.println("<p><a href='TableauDeBord2'>Voir le tableau de bord</a></p>");
        out.println("</body></html>");
	}

}
