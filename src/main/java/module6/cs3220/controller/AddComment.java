package module6.cs3220.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module6.cs3220.service.DbService;

@WebServlet("/module6/AddComment")
public class AddComment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddComment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/module6/AddComment.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String name = request.getParameter( "name" );
        String message = request.getParameter( "message" );

        DbService dbService = new DbService();
        dbService.addEntry( name, message );
        dbService.close();

        response.sendRedirect( "GuestBook" );
    }

}
