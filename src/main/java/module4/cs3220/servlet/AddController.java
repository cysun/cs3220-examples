package module4.cs3220.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module4/AddController")
public class AddController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddController()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/module4/AddForm.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        int a = Integer.parseInt( request.getParameter( "a" ) );
        int b = Integer.parseInt( request.getParameter( "b" ) );
        int sum = a + b;
        
        request.setAttribute( "a", a );
        request.setAttribute( "b", b );
        request.setAttribute( "sum", sum );
        request.getRequestDispatcher( "/WEB-INF/module4/AddResult.jsp" )
            .forward( request, response );
    }

}
