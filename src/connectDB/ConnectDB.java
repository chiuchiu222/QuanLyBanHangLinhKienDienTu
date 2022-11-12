package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
public static Connection conn=null;
private static ConnectDB instance=new ConnectDB();
public static ConnectDB getInstance() {
	return instance;
}
public void connect() throws SQLException{
	String url= "jdbc:sqlserver://localhost:1433;databaseName=QLLK;";
	String user="sa";
	String password="sa";
	conn= DriverManager.getConnection(url,user,password);
}
public void disconnect() {
	if (conn!=null) 
	
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
public static Connection getConnection() {
	return conn;
}
}
