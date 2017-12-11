
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

    protected String InitValue1 = "1";
    protected String InitValue2 = "2";
    protected String InitValue3 = "3";
    protected String InitValue4 = "4";

    public void init(MyServlet myServlet) throws ServletException{
    InitValue1 = myServlet.getInitParameter("param1");
    InitValue2 = myServlet.getInitParameter("param2");
    InitValue3 = myServlet.getInitParameter("param3");
    InitValue4 = myServlet.getInitParameter("param4");
  }

  public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    response.getWriter().write("<html><body>Value 1= " +
            InitValue1 + "<br>" + "Value 2= " + InitValue2 + "<br>" + "Value 3= " + InitValue3 + 
            "<br>" + "Value 4= " + InitValue4 + "</body></html>");
  }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet myServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet myServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
