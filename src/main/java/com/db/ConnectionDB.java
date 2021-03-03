/**
 * 
 */
package main.java.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
	
	private final static Logger logger = Logger.getLogger(ConnectionDB.class.getName());
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
    //private static final String URL = "jdbc:mysql://172.21.0.3:3306/devops_login";
    private static final String URL = "jdbc:mysql://mysqlDB:3306/devops_login";
    private static final String USER = "root";
    private static final String PASS = "LK123";

    static {
        try {
        	//BasicConfigurator.configure();
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE,"Error al cargar el controlador", e);
        }
    }
    
    public static Connection getConexion() {
        Connection connection = null;
        
        try {
        	logger.info("DRIVER -> " + DRIVER);
        	logger.info("URL -> " + URL);
        	logger.info("USER -> " + USER);
        	logger.info("PASS -> " + PASS);
            connection = DriverManager.getConnection(URL, USER, PASS);
            logger.info("Conexión OK");
        } catch (SQLException e) {
        	logger.log(Level.SEVERE,"Error en la conexión", e);
        }
        
        return connection;
    }
    
    
    
}
