package org.openapitools.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBConnection{

//    private final String url = "jdbc:postgresql://localhost:5432/zextrasdb";
//    private final String user = "postgres";
//    private final String password = "asdasd";
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
        		
			ResourceBundle prop = ResourceBundle.getBundle("org.openapitools.resources.config");

			String url 		= prop.getString("db.url");
			String user 	= prop.getString("db.user");
			String password = prop.getString("db.password");

			conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//    	ConnectionManager connectionManager = new ConnectionManager();
//    	connectionManager.connect();
//    }
}