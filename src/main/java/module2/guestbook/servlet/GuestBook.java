package module2.guestbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module2.guestbook.model.GuestBookEntry;

@WebServlet(urlPatterns = "/module2/GuestBook", loadOnStartup = 1)
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

        getServletContext().setAttribute( "entries", entries );
    }

    @SuppressWarnings("unchecked")
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext()
            .getAttribute( "entries" );

        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>GuestBook</title></head><body>" );
        out.println( "<h2>Guest Book</h2>" );

        out.println( "<table border='1'>" );
        for( GuestBookEntry entry : entries )
        {
            out.println( "<tr>" );
            out.println( "<td>" + entry.getName() + " says</td>" );
            out.println( "<td>" + entry.getMessage() + "</td>" );
            out.println(
                "<td><a href='EditEntry?id=" + entry.getId() + "'>Edit</a> |" );
            out.println(
                "<a href='DeleteEntry?id=" + entry.getId() + "'>Delete</a>" );
            out.println( "</td>" );
            out.println( "</tr>" );
        }
        out.println( "</table>" );
        out.println( "<p><a href='AddComment'>Add Comment</a></p>" );
        out.println( "</body></html>" );
    }

}
