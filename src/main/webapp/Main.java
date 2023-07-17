import java.sql.DriverManager;

public class Main {
	
	//using linkedin.com example as template
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_STRING = "jdbc:mysql://127.0.0.1:3306/grocie";
	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		//loop for validation of server status
		 if (conn.isValid(2)) {
		        System.out.println("Connection is valid.");
		    } else {
		        System.out.println("Connection is not valid.");
		    }
		} catch(SQLException e) {
		    e.printStackTrace();
		}
		
		try {
		    Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		    Statement stmt = conn.createStatement();

		    ResultSet rs = stmt.executeQuery("SELECT 1");

		    if (rs.next()) {
		        System.out.println("Connection is successful.");
		    }
		} catch(SQLException e) {
		    System.out.println("Connection failed.");
		    e.printStackTrace();
		}


		
	}
}