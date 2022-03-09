package module3.cs3220.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module3/Download")
public class Download extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Download()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String imgFolder = getServletContext()
            .getRealPath( "/WEB-INF/module3/img" );

        File file = new File( imgFolder, "cs3220-1.jpg" );
        FileInputStream in = new FileInputStream( file );
        ServletOutputStream out = response.getOutputStream();

        response.setContentType( "image/jpeg" );
        response.setHeader( "Content-Length", "" + file.length() );
        response.setHeader( "Content-Disposition",
            "inline; filename=cs3220-1.jpg" );

        byte[] buffer = new byte[2048];
        int bytesRead;
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );
        in.close();
    }
}
