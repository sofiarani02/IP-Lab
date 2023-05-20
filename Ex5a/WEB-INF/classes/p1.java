// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class p1 extends HttpServlet {

   private String message;

   public void init() throws ServletException {
      // Do required initialization
      message = "Hello, Welcome to the page!!";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();

      out.println("<html><head><title>Welcome Page</title></head><body style='text-align: center;'>");
      out.println("<h1>" + message + "</h1>");
      out.println("</body></html>");
   }

   public void destroy() {
      // do nothing.
   }
}