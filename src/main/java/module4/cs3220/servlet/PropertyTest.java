package module4.cs3220.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module4.cs3220.model.A;
import module4.cs3220.model.B;

@WebServlet("/module4/PropertyTest")
public class PropertyTest extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public PropertyTest()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.setAttribute( "a", new A() );
        request.setAttribute( "b", new B() );
        request.getRequestDispatcher( "/WEB-INF/module4/PropertyTest.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
