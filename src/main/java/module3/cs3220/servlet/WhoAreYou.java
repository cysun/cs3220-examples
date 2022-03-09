package module3.cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module3/WhoAreYou")
public class WhoAreYou extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public WhoAreYou()
    {
        super();
    }

    private String getNameFromCookie( HttpServletRequest request )
    {
        Cookie[] cookies = request.getCookies();
        if( cookies != null )
        {
            for( Cookie cookie : cookies )
                if( cookie.getName().equals( "name" ) )
                    return cookie.getValue();
        }
        return null;
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String name = getNameFromCookie( request );

        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Who Are You</title></head><body>" );

        if( name != null )
        {
            out.println( "<h2>Hello " + name + "!</h2>" );
        }
        else
        {
            out.println( "<form method='post'>" );
            out.println(
                "Your name? <input type='text' name='name'> <button>Submit</button>" );
            out.println( "</form>" );
        }
        out.println( "</body></html>" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String name = request.getParameter( "name" );
        Cookie cookie = new Cookie( "name", name );
        response.addCookie( cookie );
        response.sendRedirect( "WhoAreYou" );
    }
}
