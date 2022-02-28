package module2.cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module2/RequestInfo")
public class RequestInfo extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RequestInfo()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>RequestInfo</title></head><body>" );
        out.println( "<p>Request Method is " + request.getMethod() + "</p>" );
        out.println( "<p>Request URI is " + request.getRequestURI() + "</p>" );
        out.println( "<p>Request URL is " + request.getRequestURL() + "</p>" );
        out.println(
            "<p>Client Address is " + request.getRemoteAddr() + "</p>" );

        boolean gzipSupported = request.getHeader( "Accept-Encoding" )
            .indexOf( "gzip" ) >= 0;
        if( gzipSupported )
            out.println( "<p>GZip encoding is supported.</p>" );
        else
            out.println( "<p>GZip encoding is not supported.</p>" );

        out.println( "</body></html>" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
