package module3.cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module3/Countdown")
public class Countdown extends HttpServlet {

    private static final long serialVersionUID = 1L;

    int count = 10;

    public Countdown()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Add</title></head><body>" );
        if( count == 0 )
            out.println( "<h2>Launch!</h2>" );
        else
        {
            response.setHeader( "Refresh", "1" );
            out.println( "<h2>" + count + "</h2>" );
            --count;
        }
        out.println( "</body></html>" );
    }

}
