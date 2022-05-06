package module8.guestbook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module8.guestbook.service.DbService;

@WebServlet("/module8/AddComment")
public class AddComment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddComment()
    {
        super();
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String name = request.getParameter( "name" );
        String message = request.getParameter( "message" );

        DbService dbService = new DbService();
        int id = dbService.addEntry( name, message );
        dbService.close();

        response.setContentType( "text/plain" );
        response.getWriter().print( id );
    }

}
