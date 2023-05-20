import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class p12_db2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        String review = request.getParameter("bname");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // create a database connection using jdbc , port no used here is 3307
            // database name is college and username is root , there is no password
           // stmt = conn.createStatement();
            String sql;
            // select data from table where dept matches the value given by user in form
            sql = "SELECT * FROM book where Name = ?";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/books","root", "");
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, review);
            ResultSet rs = pstmt.executeQuery();
            // Extract data from result set ws3
            if(conn!=null)
            {
                out.println("<h1>Specific Book Details</h1>");
            }
            while(rs.next())
            {
                //out.println("<h1> into while loop</h1>");
                //Retrieve by column name
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String au = rs.getString("Author");
                Double yr = rs.getDouble("Year");
                String p = rs.getString("Price");
                //Display values
                out.println("<p> ID: " + id + "<br>");
                out.println("Name : " + name + "<br>");
                out.println("Author : " + au + "<br>");
                out.println("Year : " + yr + "<br>");
                out.println("Price : " + p + "<br></p>");
            }
            out.println("</body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
}