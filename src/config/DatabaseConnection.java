package config;

import errorscatcher.StackTracerFile;

import java.io.FileNotFoundException;
import java.sql.*;
import static config.Database.*;

public class DatabaseConnection {
    public static Connection getCon() throws FileNotFoundException {
        StackTracerFile stackTracerFile = new StackTracerFile();
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWORD);
        }catch(SQLException sqlEx) {
            stackTracerFile.saveExceptionToFile(sqlEx);
            System.out.println("Cant connect to database");
        }
        return con;
    }
    public static Connection getSqlCon() throws FileNotFoundException {
        StackTracerFile stackTracerFile = new StackTracerFile();
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }catch(SQLException sqlEx){
            stackTracerFile.saveExceptionToFile(sqlEx);
            System.out.println("Cant connect to SQL");
        }
        return con;
    }
}

