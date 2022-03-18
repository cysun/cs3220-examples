package module5.cs3220.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module5.cs3220.model.GuestBookEntry;

@WebServlet("/module5/AddComment")
public class AddComment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddComment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/module5/AddComment.jsp" )
            .forward( request, response );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String name = request.getParameter( "name" );
        String message = request.getParameter( "message" );
        GuestBookEntry entry = new GuestBookEntry( name, message );

        List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext()
            .getAttribute( "entries2" );
        entries.add( entry );

        // returning a view - redirect is considered a special view
        response.sendRedirect( "GuestBook" );
    }

}
