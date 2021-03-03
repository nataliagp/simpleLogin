package main.java.com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.com.db.ConnectionDB;
import main.java.com.entity.User;

public class UserDAO {
	
	private final static Logger logger = Logger.getLogger(UserDAO.class.getName());
	
	public User findUser(String userName, String pass) {
		User user = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		try {
			connection = ConnectionDB.getConexion();
			String sql = "SELECT u.id, u.userName, u.pass, u.fullName FROM user u WHERE u.userName = ? AND u.pass = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, pass);
			resultset = statement.executeQuery();
			
			while (resultset.next()) {
				user = new User();
				user.setId(resultset.getInt("id"));
				user.setUserName(resultset.getString("userName"));
				user.setPass(resultset.getString("pass"));
				user.setFullName(resultset.getString("fullName"));
			}
			
		} catch (Exception e) {
			logger.log(Level.SEVERE,"Ocurrió un error al buscar el usuario", e);
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
				}
				
				if (statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				logger.log(Level.SEVERE,"Ocurrió un error al cerrar la conexión con la BD", e2);
			}
		}
		
		return user;
	}
}
