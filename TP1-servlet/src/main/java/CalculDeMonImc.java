

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;



@WebServlet("/CalculDeMonImc")
public class CalculDeMonImc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CalculDeMonImc() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Pour le format de reponse
			response.setContentType("text/html");
			//Recupere les paramaterer apartir de URL
			String tailleSt = request.getParameter("taille");
			String poidSt = request.getParameter("poid");
			
			double imc = 0;
			//Pour convertir un string a u, double
			double taille = Double.parseDouble(tailleSt);
			double poid = Double.parseDouble(poidSt);
			
//			imc = poid / (taille * taille);
			
			Imc calcul1=new Imc(taille,poid);
		    imc=calcul1.calcul();
			
			PrintWriter out =response.getWriter();
			out.println("<!DOCTYPE html>");
	        out.println("<html><head><title>Résultat IMC</title></head><body>");
	        out.printf("<h1>Votre Résultat de IMC est </h1>");
	        out.printf("<p>Votre IMC est :"+imc+"</p>");
	       out.println("</body></html>");
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String tailleSt = request.getParameter("taille");
		String poidSt = request.getParameter("poid");
		
		double imc = 0;
		//Pour convertir un string a u, double
		double taille = Double.parseDouble(tailleSt);
		double poid = Double.parseDouble(poidSt);
		
		Imc calcul1=new Imc(taille,poid);
	    imc=calcul1.calcul();

	    Cookie cookieTaille=new Cookie("taille",tailleSt);
	    Cookie cookiePoid=new Cookie("poids",poidSt);
	    Cookie cookieImc=new Cookie("imc",	String.format(Locale.US,"%.8f", imc));
	    
	    cookieTaille.setMaxAge(24*60*60);
	    cookiePoid.setMaxAge(24*60*60);
	    cookieImc.setMaxAge(24*60*60);

		response.addCookie(cookieTaille);
		response.addCookie(cookiePoid);
		response.addCookie(cookieImc);

	    
		PrintWriter out =response.getWriter();
		out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Résultat IMC</title></head><body>");
        out.printf("<h1>Votre Résultat de IMC est </h1>");
        out.printf("<p>Votre IMC est :"+imc+"</p>");
        out.println("<p><a href='TableauDeBord'>Voir le tableau de bord</a></p>");
       out.println("</body></html>");
	}

}
