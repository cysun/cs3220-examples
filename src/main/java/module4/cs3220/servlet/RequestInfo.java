package module4.cs3220.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module4/RequestInfo")
public class RequestInfo extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RequestInfo()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getSession().setAttribute( "hello", "world" );
        request.setAttribute( "hello", "cs3220" );
        request.getRequestDispatcher( "/WEB-INF/module4/RequestInfo.jsp" )
            .forward( request, response );
    }

}
