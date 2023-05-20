import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class login1 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response){  
        try{  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("userName");  
        out.print("<html> ");
        out.println("<head> <link rel='stylesheet' href='sty.css'> </head>");
        out.print("<body style = 'background-color: rgb(239, 185, 114); text-align: center;'>");
        out.print(" <h1 style = 'color: rgb(139, 0, 0);'>  Explore Books!</h1>  ") ;          
        out.print("<br>");
        out.print("<h3 style = 'color: rgb(90, 44, 255);'> Welcome <mt1 style = 'color: crimson;'>".concat(n)+"</mt1></h3>");

        //creating form that have invisible textfield  
        out.print("<form action='login2'>");  
        out.print("<input type='hidden' name='uname' value='"+n+"'>");  
        out.print("<input type='submit' value='submit'>");  
        out.print("</form> ");  
        out.close();  
        }
        catch(Exception e){System.out.println(e);}  
    }  
}  