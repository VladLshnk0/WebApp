import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/about")
public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<p> Here <a href = /registration.html>reg</a></p>");

        String name = req.getParameter("username");
        String age = req.getParameter("userage");
        String sex = req.getParameter("sex");
        String country = req.getParameter("country");
        String[] courses = req.getParameterValues("courses");

        try{
            printWriter.println("<p> Name: " + name + "</p>");
            printWriter.println("<p> Age: " + age + "</p>");
            printWriter.println("<p> Sex: " + sex + "</p>");
            printWriter.println("<p> Country: " + country + "</p>");
            for(String course: courses){
                printWriter.println("<li>" + course + "</li>");
            }
        }
        finally {
            printWriter.close();
        }
    }
}