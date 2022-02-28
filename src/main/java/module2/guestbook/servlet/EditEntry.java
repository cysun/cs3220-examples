package module2.guestbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module2.guestbook.model.GuestBookEntry;

@WebServlet("/module2/EditEntry")
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
            .getAttribute( "entries" );
        for( GuestBookEntry entry : entries )
            if( entry.getId() == id ) return entry;
        return null;
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String id = request.getParameter( "id" );
        GuestBookEntry entry = getEntry( Integer.parseInt( id ) );

        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>EditEntry</title></head><body>" );
        out.println( "<form action='EditEntry' method='post'>" );
        out.println( "<input type='hidden' name='id' value='" + id + "'>" );
        out.println( "Name: <input type='text' name='name' value='"
            + entry.getName() + "'><br>" );
        out.println( "<textarea name='message' rows='6' cols='40'>"
            + entry.getMessage() + "</textarea><br>" );
        out.println( "<button>Save</button></form>" );
        out.println( "</body></html>" );
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
