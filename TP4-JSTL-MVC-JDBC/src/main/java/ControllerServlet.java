import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/ControllerServlet")  
public class ControllerServlet extends HttpServlet {
    private ContactFacade contactFacade;

    @Override
    public void init() {
        contactFacade = new ContactFacade();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String do_this = request.getParameter("do_this");

        if (do_this == null) {
            request.setAttribute("listContacts", contactFacade.findAll());
            request.getRequestDispatcher("/accueil.jsp").forward(request, response);
        } 
        else if (do_this.equals("create")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            Contact contact = new Contact(firstName, lastName, email, phone, address);
            contactFacade.createContact(contact);
            response.sendRedirect("ControllerServlet");

        } 
        else if (do_this.equals("delete")) {
            String idStr = request.getParameter("contact_id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                contactFacade.deleteContact(id);
            }
            response.sendRedirect("ControllerServlet");
        } 
        else if (do_this.equals("update")) {
            String idStr = request.getParameter("contact_id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");

                Contact contact = new Contact(id, firstName, lastName, email, phone, address);
                contactFacade.updateContact(contact);
            }
            response.sendRedirect("ControllerServlet");
        }
    }
}
