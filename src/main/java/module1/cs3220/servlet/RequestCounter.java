package module1.cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module1/RequestCounter")
public class RequestCounter extends HttpServlet {

    private static final long serialVersionUID = 1L;

    int counter = 0;

    public RequestCounter()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        ++counter;
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>RequestCounter</title></head><body>" );
        out.println(
            "<h2>This page has been viewed " + counter + " times</h2>" );
        out.println( "</body></html>" );

    }
}
