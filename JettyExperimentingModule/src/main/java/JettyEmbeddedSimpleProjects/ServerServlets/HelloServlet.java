package JettyEmbeddedSimpleProjects.ServerServlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HelloServlet extends HttpServlet
{
    private String greeting;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Greeting, " + greeting + "</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());
    }

    public void init(ServletConfig servletConfig) throws ServletException{
        String myParam = servletConfig.getInitParameter("myParam");
        this.greeting = myParam == null || myParam.isEmpty() ? "Hello Empty Param!" : myParam;
    }
}