<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> IPL_7💻</title>
</head>

<body>
<%
String JDBC_DRIVER = "com.mysql.jdbc.Driver";
String DB_URL = "jdbc:mysql://localhost:3307/books";

// Database credentials
String USER = "root";
String PASS = "";

// Set response content type
response.setContentType("text/html");
PrintWriter out1 = response.getWriter();

String title = "Welcome to Books Database";
out1.println("<html>\n");
out1.println("<head><title>" + "Books DB" + "</title> ");
//out1.println("<link rel='stylesheet' href='http://localhost:8080/Ex8/style.css'>");
out1.println("</head>\n"); 
out1.println("<body bgcolor = \"#f0f0f0\">\n");
out1.println( "<center><h1 > "+title +"</h1></center>");
try {
    // Register JDBC driver
    Class.forName(JDBC_DRIVER);

    // Open a connection
    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

    // Execute SQL query
    Statement stmt = conn.createStatement();

    String sql;
    String c = request.getParameter("input");
    String r = request.getParameter("id");
    PreparedStatement ps = conn.prepareStatement("UPDATE book set Price=? where ID=?");

    ps.setString(1, c);
    ps.setString(2, r);
    ps.executeUpdate();
    sql = "SELECT * FROM book;";
    ResultSet rs = stmt.executeQuery(sql);

    out1.println(" <style> th, td { ");
        out1.println("padding-top: 10px;");
        out1.println(" padding-bottom: 20px;");
        out1.println("padding-left: 30px;");
        out1.println("padding-right: 40px;");
        out1.println("} </style><center><div><table border = 1 >");
        
        out1.println("<center><div><table border = 1 >");
        out1.println("<tr><td> ID </td>'");
        out1.println("<td> Name </td>");
        out1.println("<td> Author </td>");
        out1.println("<td> Year </td>");
        out1.println("<td> Price </td>");
        out1.println("<td> Edit Price </td></tr>");

        // Extract data from result set
        while (rs.next()) {
            // Retrieve by column name
            String id = rs.getString("ID");
            String name = rs.getString("Name");
            String au = rs.getString("Author");
            String yr = rs.getString("Year");
            String P = rs.getString("Price");

            // Display values
            out1.println("<tr> <td>" + id + " </td>");
            out1.println("<td>" + name + "</td>");
            out1.println("<td>" + au + "</td>");
            out1.println("<td >" + yr + "</td>");
            out1.println("<td >" + P + "</td>");
            out1.println("<td > ");
            out1.println("<form action='p7i.jsp' method ='post'>");// onclick='window.open('comment','_blank')
            out1.println("<input type='text' name='input'>");
            out1.print("<input type='hidden' name='id' value='" + id + "'>");
            out1.print("<input type='submit' value='UPDATE'>");
            out1.print("</form> ");
            out1.println("</td>");
        }
    
        out1.println("</table></div></center>");
        out1.println("<br><br><button id='render-btn' type='submit' onclick='R()'>BACK</button>");
        out1.println("<script>function R() {location.replace('http://localhost:8080/Ex8/p7.jsp')}</script>");
        out1.println("</body></html>");
    
        rs.close();
        stmt.close();
        conn.close();
    } 
    catch (Exception e) {
        out1.print("Do not connect to DB - Error:" + e);
    }
%>
</body>
</html>