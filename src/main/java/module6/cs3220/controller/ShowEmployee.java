package module6.cs3220.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module6.cs3220.model.Employee;

@WebServlet("/module6/ShowEmployee")
public class ShowEmployee extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/module6/EmployeeForm.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        List<Employee> employees = new ArrayList<Employee>();

        String username = request.getParameter( "username" );
        String password = request.getParameter( "password" );
        String sql = "select * from employees where username = '" + username
            + "' and password = '" + password + "'";

        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu31";
            c = DriverManager.getConnection( url, "cs3220stu31", "abcd" );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            while( rs.next() )
            {
                Employee employee = new Employee();
                employee.setId( rs.getInt( "id" ) );
                employee.setUsername( rs.getString( "username" ) );
                employee.setPassword( rs.getString( "password" ) );
                employee.setBirthday( rs.getDate( "birthday" ) );
                employee.setSalary( rs.getDouble( "salary" ) );
                employees.add( employee );
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

        request.setAttribute( "employees", employees );
        request.getRequestDispatcher( "/WEB-INF/module6/EmployeeInfo.jsp" )
            .forward( request, response );
    }
}
