package config;
import java.sql.*;
import static config.Database.*;

public class DatabaseConnection {
    public static Connection getCon(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWORD);
        }catch(SQLException e){
            System.out.println("Cant connect to database");
        }
        return con;
    }
    public static Connection getSqlCon(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }catch(SQLException e){
            System.out.println("Cant connect to SQL");
        }
        return con;
    }
}

