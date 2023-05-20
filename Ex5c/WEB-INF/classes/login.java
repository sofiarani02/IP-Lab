import java.io.*;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class login extends HttpServlet {

    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        String title = "Today Visitor's Count";
        // This method executes whenever the servlet is hit
        // increment hitCount
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String date = myDateObj.format(myFormatObj);

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String n = request.getParameter("userName");
            out.print("<html> ");
            out.println("<head> <link rel='stylesheet' href='sty.css'> </head>");
            out.print("<body style = 'background-color: rgb(240, 201, 150);'>");
            out.print("<h1 style = 'color: rgb(139, 0, 0)'>  Explore Books!! </h1>");

            out.print("<p style = 'color: #0000FF;'>");
            out.print("<b><hr>Action and Adventure</b><br>");
            out.print("Action and adventure books constantly have you on the edge of your seat with excitement, as your fave main character repeatedly finds themselves in high stakes situations. <br> The protagonist has an ultimate goal to achieve and is always put in risky, often dangerous situations. This genre typically crosses over with others like mystery, crime, sci-fi, and fantasy.");
            //out.print("<img src='Adventure.jpg' heigth='300' width='300'>");

            out.print("<br><br><b>Comic Book</b><br>");
            out.print("The stories in comic books and graphic novels are presented to the reader through engaging, sequential narrative art (illustrations and typography) that's either presented in a specific design or the traditional panel layout you find in comics. With both, you'll often find the dialogue presented in the tell-tale word balloons next to the respective characters.");
            out.print("</p>");
            //out.print("<img src='comic.jpg' heigth='300' width='300'>");

            out.print("<p style = 'color: #0000FF; font-size: 0.7cm;'> Welcome <mt1 style = 'color: crimson;'>"
                            .concat(n) + "</mt1></p>");
            hitCount++;
            out.println("<h1 style='color: rgb(139, 0, 0);'align = \"center\">" + title + "</h1>\n\n");

            out.println("<h2 style='color: rgb(90, 44, 255);' align = \"center\">" + hitCount + "</h2>\n");
            out.println("<p style = 'color: rgb(0, 110, 96);' align = \"center\">"
                    + "Logged on : ".concat(date) + "</h2>\n");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void destroy() {
        // This is optional step but if you like you
        hitCount = 0;
    }
}