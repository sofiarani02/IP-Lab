/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sofia;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author Selvam
 */
@WebService(serviceName = "GetDetails")
public class GetDetails {

    /**
     * This is a sample web service operation
     */
    String Result = "No records found :((";
    @WebMethod(operationName = "bname")
    public String hello(@WebParam(name = "bname") String bname) {
        Connection conn=null;
        Statement stmt=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //out.println("<h1> into class</h1>");
            //create a database connection using jdbc , port no used here is 3307
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/books","root", "");
            if(conn!=null)
            {
                System.out.println("All Book Details");
            }
            stmt = conn.createStatement();
            String sql;
            //display all the students' marks
            sql = "SELECT ID,Name,Author FROM book WHERE Name='" + bname + "'" ;
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while(rs.next())
            {
                //out.println("<h1> into while loop</h1>");
                //Retrieve by column name
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String au = rs.getString("Author");
                Result = "<Customer><ID>" + id + "</ID><Name>" + name + "</Name><Author>" + au + "</Author></Customer>" ;

                       System.err.format("%s,%s, &s\n",id,name,au);
                //Display values
                
            }
          
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
        return Result;
    }
}
