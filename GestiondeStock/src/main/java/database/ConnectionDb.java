package database;

import java.sql.*;

public class ConnectionDb {
    private static final String db = "gestock";
    private static final String user = "root";
    private static final String pass = "root";
    private static Connection con ;

    public static Connection getConnection() {
        if (con != null) return con;
        return getConnection(db, user, pass);
    }

    private static Connection getConnection(String db, String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, pass);
            System.out.println("Connectée avec Succes");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error: " + e.getMessage());
        }

        return con;
    }
}

