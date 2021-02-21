/**
 * 
 */
package main.java.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionDB {
	
	private final static Logger logger = Logger.getLogger(ConnectionDB.class);
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/devops_login";
    private static final String USER = "nataliagp";
    private static final String PASS = "LK123";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error("Error al cargar el controlador", e);
        }
    }
    
    public static Connection getConexion() {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            logger.info("Conexión OK");
        } catch (SQLException e) {
            logger.error("Error en la conexión", e);
        }
        
        return connection;
    }
    
    
    
}
