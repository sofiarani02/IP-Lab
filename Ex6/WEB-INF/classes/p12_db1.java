import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
public class p12_db1 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //out.println("<h1> into class</h1>");
            //create a database connection using jdbc , port no used here is 3307
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/books","root", "");
            if(conn!=null)
            {
                out.println("<h1>All Book Details</h1>");
            }
            stmt = conn.createStatement();
            String sql;
            //display all the students' marks
            sql = "SELECT * FROM book";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while(rs.next())
            {
                //out.println("<h1> into while loop</h1>");
                //Retrieve by column name
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String au = rs.getString("Author");
                Integer yr = rs.getInt("Year");
                Double p = rs.getDouble("Price");
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
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
}