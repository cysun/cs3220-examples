package module5.cs3220.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module5.cs3220.model.GuestBookEntry;

@WebServlet(urlPatterns = "/module5/GuestBook", loadOnStartup = 1)
public class GuestBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public GuestBook()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
        entries.add( new GuestBookEntry( "John", "Hello!" ) );
        entries.add( new GuestBookEntry( "Jane", "Nice site!" ) );

        getServletContext().setAttribute( "entries2", entries );
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/module5/GuestBook.jsp" )
            .forward( request, response );
    }

}
