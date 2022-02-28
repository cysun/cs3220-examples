package module2.cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module2/Add")
public class Add extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Add()
    {
        super();
    }

    // Add two integer values provided by request parameters
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Add</title></head><body>" );

        String pa = request.getParameter( "a" );
        String pb = request.getParameter( "b" );
        int a = pa == null || pa.trim().length() == 0 ? 0
            : Integer.parseInt( pa );
        int b = pb == null || pb.trim().length() == 0 ? 0
            : Integer.parseInt( pb );

        int sum = a + b;
        out.println(
            "<h2>The sum of " + a + " and " + b + " is " + sum + "</h2>" );
        out.println( "</body></html>" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }
}
