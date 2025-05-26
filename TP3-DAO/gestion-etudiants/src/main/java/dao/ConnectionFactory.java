package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static Connection cnx;
    private static final String USER_NAME = "postgres"; 
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/bdTP3"; 

    private ConnectionFactory() {}

    static {
        try {
        	 Class.forName("org.postgresql.Driver");
             cnx = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace(); 
            System.out.println("errreur de connexion");
        }
    }

    public static Connection getConnection() {
        return cnx;
    }
}

