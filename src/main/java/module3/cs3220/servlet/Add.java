package module3.cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module3/Add")
public class Add extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Add()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Add</title></head><body>" );

        String pa = request.getParameter( "a" );
        String pb = request.getParameter( "b" );
        if( pa == null || pb == null || pa.trim().length() == 0
            || pb.trim().length() == 0 )
        {
            response.sendRedirect( "AddForm.html" );
            return;
        }

        int sum = Integer.parseInt( pa ) + Integer.parseInt( pb );
        out.println(
            "<h2>The sum of " + pa + " and " + pb + " is " + sum + "</h2>" );
        out.println( "</body></html>" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }
}
