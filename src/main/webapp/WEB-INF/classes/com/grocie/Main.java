import java.sql.DriverManager;

public class Main {
	
	//using linkedin.com example as template
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String CONN_STRING = "jdbc:mysql://localhost/explorcalifornia";
	public static void main(String[] args) {
		
		Connection conn = null;
		conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		
	}
}