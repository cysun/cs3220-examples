package module8.guestbook.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import module8.guestbook.model.GuestBookEntry;

public class DbService {

    private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu31";

    private String username = "cs3220stu31";

    private String password = "abcd";

    private Connection connection;

    public DbService()
    {
        try
        {
            connection = DriverManager.getConnection( url, username, password );
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        if( connection != null )
        {
            try
            {
                connection.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }

    public List<GuestBookEntry> getEntries()
    {
        List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();

        try
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from guestbook" );
            while( rs.next() )
            {
                GuestBookEntry entry = new GuestBookEntry();
                entry.setId( rs.getInt( "id" ) );
                entry.setName( rs.getString( "name" ) );
                entry.setMessage( rs.getString( "message" ) );
                entries.add( entry );
            }
            stmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        return entries;
    }

    public GuestBookEntry getEntry( int id )
    {
        GuestBookEntry entry = new GuestBookEntry();
        try
        {
            String sql = "select * from guestbook where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();
            if( rs.next() )
            {
                entry.setId( rs.getInt( "id" ) );
                entry.setName( rs.getString( "name" ) );
                entry.setMessage( rs.getString( "message" ) );
            }
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return entry;
    }

    public int addEntry( String name, String message )
    {
        int id = 0;
        try
        {
            String sql = "insert into guestbook (name, message) values (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setString( 1, name );
            pstmt.setString( 2, message );
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if( rs.next() ) id = rs.getInt( 1 );
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return id;
    }

    public void updateEntry( int id, String name, String message )
    {
        try
        {
            String sql = "update guestbook set name = ?, message = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setString( 1, name );
            pstmt.setString( 2, message );
            pstmt.setInt( 3, id );
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public void deleteEntry( int id )
    {
        try
        {
            String sql = "delete from guestbook where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
}
