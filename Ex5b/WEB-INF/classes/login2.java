import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class login2 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response) { 
        try{  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        //Getting the value from the hidden field  
        String n=request.getParameter("uname");  
        
        out.print("<body style = 'background-color: rgb(240, 201, 150);'>");
        out.print("<center>"); 
        out.print("<img src='tq.jpg' heigth='600' width='600'> </center>");
        out.print("<br><br>  <center> <p style = 'color: rgb(90, 44, 255); font-size: 1cm; align:center '> Thanks for visiting, <mt1 style = 'color: crimson;'>".concat(n)+"</mt1>  <center></p>"); 
        out.close();  
                }
        catch(Exception e)
        {System.out.println(e);}  
}
      
}  