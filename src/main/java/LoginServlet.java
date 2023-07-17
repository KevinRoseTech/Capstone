
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if(checkLogin(user, pass)){
            response.sendRedirect("home.html");  // Forward to welcome page
        } else{
            response.sendRedirect("login.html");    // Redirect back to login page
        }
    }

    private boolean checkLogin(String username, String password){
        // TODO: Team, you need to edit this url with your server url when testing
    	// on your device!
        String url = "jdbc:mysql://localhost:3306/grocie";
        String dbUser = "root";
        String dbPassword = "password";

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return true;  // Login successful if a result is found
                }
            }
        } catch (SQLException ex) {
            // handle any errors
            ex.printStackTrace();
        }
        return false;  // Login failed if no result found
    }
}
