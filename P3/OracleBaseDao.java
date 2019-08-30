package P3;

import java.sql.*;

public class OracleBaseDao {
    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "system";
    private static final String DB_PASS = "root";
    private static Connection conn;

    protected static Connection getConnection() throws SQLException {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	        return conn;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    	return null;
    }

}