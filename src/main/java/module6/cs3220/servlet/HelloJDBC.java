package module6.cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module6/HelloJDBC")
public class HelloJDBC extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public HelloJDBC()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        out.println( "<!DOCTYPE html>" );
        out.println( "<html><head><title>Hello JDBC</title></head><body>" );

        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu31";
            String username = "cs3220stu31";
            String password = "abcd";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from items" );

            while( rs.next() )
            {
                out.println( rs.getString( 2 ) );
                out.println( rs.getString( "price" ) );
                out.println( rs.getFloat( "quantity" ) );
                out.println( "<br>" );
            }
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        out.print( "</body></html>" );
    }
}
