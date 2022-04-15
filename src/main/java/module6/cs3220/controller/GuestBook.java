package module6.cs3220.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module6.cs3220.service.DbService;

@WebServlet(urlPatterns = "/module6/GuestBook", loadOnStartup = 1)
public class GuestBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public GuestBook()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        // Loading the JDBC driver is needed when the driver is packaged
        // with the application instead of being provided by the application
        // server.
        try
        {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        DbService dbService = new DbService();
        request.setAttribute( "entries", dbService.getEntries() );
        dbService.close();

        request.getRequestDispatcher( "/WEB-INF/module6/GuestBook.jsp" )
            .forward( request, response );
    }
}
