import java.sql.*;
import java.util.*;

public class ContactFacade {

    private static final String URL = "jdbc:postgresql://localhost:5432/gestion_contacts";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    // Chargement explicite du driver
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : le driver PostgreSQL n'a pas été trouvé.");
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contact";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Contact c = new Contact(
                        rs.getInt("id_contact"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
                contacts.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des contacts : " + e.getMessage());
        }
        return contacts;
    }

    public void createContact(Contact c) {
        String sql = "INSERT INTO contact (firstname, lastname, email, phone, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPhone());
            ps.setString(5, c.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la création du contact : " + e.getMessage());
        }
    }

    public void deleteContact(int id) {
        String sql = "DELETE FROM contact WHERE id_contact = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du contact : " + e.getMessage());
        }
    }

    // Méthode facultative pour mettre à jour un contact existant
    public void updateContact(Contact c) {
        String sql = "UPDATE contact SET firstname=?, lastname=?, email=?, phone=?, address=? WHERE id_contact=?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPhone());
            ps.setString(5, c.getAddress());
            ps.setInt(6, c.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du contact : " + e.getMessage());
        }
    }
    
    public Contact findById(int id) {
    	String SQL= "Select * from contact where id_contact=?";
    	try(Connection conn = getConnection();PreparedStatement ps =conn.prepareStatement(SQL)){
    		ps.setInt(1, id);
    		try(ResultSet rs =ps.executeQuery()){
    			if (rs.next()) {
                    return new Contact(
                            rs.getInt("id_contact"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getString("address")
                    );
    		}
    		
    	}
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche du contact : " + e.getMessage());
    }
    return null;
}
}
