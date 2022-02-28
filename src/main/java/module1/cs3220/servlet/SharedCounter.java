package module1.cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/module1/SharedCounter", loadOnStartup = 1)
public class SharedCounter extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public SharedCounter()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        getServletContext().setAttribute( "counter", 0 );
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        int counter = (int) getServletContext().getAttribute( "counter" );
        ++counter;
        getServletContext().setAttribute( "counter", counter );
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>SharedCounter</title></head><body>" );
        out.println(
            "<h2>This page has been viewed " + counter + " times</h2>" );
        out.println( "</body></html>" );
    }
}
