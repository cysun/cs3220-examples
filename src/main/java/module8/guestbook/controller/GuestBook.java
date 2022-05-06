package module8.guestbook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module8.guestbook.service.DbService;

@WebServlet(urlPatterns = "/module8/GuestBook", loadOnStartup = 1)
public class GuestBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public GuestBook()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        DbService dbService = new DbService();
        request.setAttribute( "entries", dbService.getEntries() );
        dbService.close();

        request.getRequestDispatcher( "/WEB-INF/module8/GuestBook.jsp" )
            .forward( request, response );
    }
}
