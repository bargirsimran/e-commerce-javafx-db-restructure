package common;
import java.sql.*;

public class DBUtils {
	private static Connection connection;
	private static Statement statement;
	
	static {
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db","root","simran@123");
			
			statement=connection.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=statement.executeQuery(query);
		return result;
	}
	
	public static boolean executeQuery(String query) throws SQLException {
		return statement.execute(query);
	}
}
