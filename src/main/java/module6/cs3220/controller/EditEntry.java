package module6.cs3220.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module6.cs3220.service.DbService;

@WebServlet("/module6/EditEntry")
public class EditEntry extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EditEntry()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        int id = Integer.parseInt( request.getParameter( "id" ) );

        DbService dbService = new DbService();
        request.setAttribute( "entry", dbService.getEntry( id ) );
        dbService.close();

        request.getRequestDispatcher( "/WEB-INF/module6/EditEntry.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        int id = Integer.parseInt( request.getParameter( "id" ) );
        String name = request.getParameter( "name" );
        String message = request.getParameter( "message" );

        DbService dbService = new DbService();
        dbService.updateEntry( id, name, message );
        dbService.close();

        response.sendRedirect( "GuestBook" );
    }
}
