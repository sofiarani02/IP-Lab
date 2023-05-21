/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sofia;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class fetch extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GetDetails Details = new GetDetails();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String bname = request.getParameter("bname");
        String xmlResult = Details.hello(bname);

        // Parse XML response and display results in table rows
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Book Details</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #f4f4f4;");
        out.println("    margin: 0;");
        out.println("    padding: 20px;");
        out.println("}");

        out.println("h1 {");
        out.println("    color: #333333;");
        out.println("    text-align: center;");
        out.println("}");

        out.println("table {");
        out.println("    width: 50%;");
        out.println("    margin: 0 auto;");
        out.println("    border-collapse: collapse;");
        out.println("    border: 1px solid #333333;"); // Added border
        out.println("}");

        out.println("th, td {");
        out.println("    padding: 10px;");
        out.println("    text-align: center;");
        out.println("}");

        out.println("th {");
        out.println("    background-color: #333333;");
        out.println("    color: #ffffff;");
        out.println("}");

        out.println("tr:nth-child(even) {");
        out.println("    background-color: #f2f2f2;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>Book Details</h1>");
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>Author</th></tr>");

        String id = "", name = "", au = "";
        int startIndex, endIndex;
        while (xmlResult.contains("<Customer>")) {
            startIndex = xmlResult.indexOf("<ID>") + 4;
            endIndex = xmlResult.indexOf("</ID>");
            id = xmlResult.substring(startIndex, endIndex);
            xmlResult = xmlResult.substring(endIndex + 5);

            startIndex = xmlResult.indexOf("<Name>") + 6;
            endIndex = xmlResult.indexOf("</Name>");
            name = xmlResult.substring(startIndex, endIndex);
            xmlResult = xmlResult.substring(endIndex + 7);

            startIndex = xmlResult.indexOf("<Author>") + 8;
            endIndex = xmlResult.indexOf("</Author>");
            au = xmlResult.substring(startIndex, endIndex);
            xmlResult = xmlResult.substring(endIndex + 9);

            out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + au + "</td></tr>");
        }

        out.println("</table>");
        out.println("</body></html>");

    }
}