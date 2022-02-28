package module1.cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/module1/HelloWorld", "/module1/member/*" })
public class HelloWorld extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public HelloWorld()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Hello</title></head><body>" );
        out.println( "<h2>Hello World</h2>" );
        out.println( "</body></html>" );
    }
}
