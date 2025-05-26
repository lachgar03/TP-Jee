package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.EtudiantDao;
import domain.Etudiant;


@WebServlet("/modifier")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private EtudiantDao dao= new EtudiantDao();
    public ModifierServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		Etudiant e=dao.findByCode(code);
		request.setAttribute("etud", e);
		request.getRequestDispatcher("etudiants.jsp").forward(request,
		response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

