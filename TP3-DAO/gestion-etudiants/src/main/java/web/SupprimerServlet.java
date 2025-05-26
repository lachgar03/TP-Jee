package web;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.EtudiantDao;
import domain.Etudiant;

@WebServlet("/supprimer")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private EtudiantDao dao =new EtudiantDao();
    
    public SupprimerServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		dao.delete(code);
		List<Etudiant> l=dao.findAll();
		request.setAttribute("all", l);
		request.getRequestDispatcher("etudiants.jsp").forward(request,
		response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


