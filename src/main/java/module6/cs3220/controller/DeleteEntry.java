package module6.cs3220.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module6.cs3220.service.DbService;

@WebServlet("/module6/DeleteEntry")
public class DeleteEntry extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DeleteEntry()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        int id = Integer.parseInt( request.getParameter( "id" ) );

        DbService dbService = new DbService();
        dbService.deleteEntry( id );
        dbService.close();

        response.sendRedirect( "GuestBook" );
    }
}
