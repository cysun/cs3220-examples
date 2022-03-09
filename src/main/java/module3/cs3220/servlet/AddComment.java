package module3.cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module3.cs3220.model.GuestBookEntry;

@WebServlet("/module3/AddComment")
public class AddComment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddComment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // look for name in session. If it's there, do not display name input
        // field; otherwise display name input field
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>AddComment</title></head><body>" );
        out.println( "<form action='AddComment' method='post'>" );
        String name = (String) request.getSession().getAttribute( "name" );
        if( name == null )
        {
            out.println( "Name: <input type='text' name='name'><br>" );
        }
        else
        {
            out.println( "Name: " + name + "<br>" );
        }
        out.println(
            "<textarea name='message' rows='6' cols='40'></textarea><br>" );
        out.println( "<button>Add Comment</button></form>" );
        out.println( "</body></html>" );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String name = (String) request.getSession().getAttribute( "name" );
        if( name == null )
        {
            name = request.getParameter( "name" );
            request.getSession().setAttribute( "name", name );
        }

        String message = request.getParameter( "message" );
        GuestBookEntry entry = new GuestBookEntry( name, message );

        List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext()
            .getAttribute( "entries3" );
        entries.add( entry );

        response.sendRedirect( "GuestBook" );
    }

}
