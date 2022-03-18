package module5.cs3220.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module5.cs3220.model.GuestBookEntry;

@WebServlet("/module5/EditEntry")
public class EditEntry extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EditEntry()
    {
        super();
    }

    @SuppressWarnings("unchecked")
    private GuestBookEntry getEntry( int id )
    {
        List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext()
            .getAttribute( "entries2" );
        for( GuestBookEntry entry : entries )
            if( entry.getId() == id ) return entry;
        return null;
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String id = request.getParameter( "id" );
        GuestBookEntry entry = getEntry( Integer.parseInt( id ) );
        request.setAttribute( "entry", entry );
        request.getRequestDispatcher( "/WEB-INF/module5/EditEntry.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        GuestBookEntry entry = getEntry(
            Integer.parseInt( request.getParameter( "id" ) ) );
        entry.setName( request.getParameter( "name" ) );
        entry.setMessage( request.getParameter( "message" ) );
        response.sendRedirect( "GuestBook" );
    }
}
