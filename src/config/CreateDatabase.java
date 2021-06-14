package config;

import errorscatcher.StackTracerFile;

import static config.Database.*;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDatabase {
    StackTracerFile stackTracerFile = new StackTracerFile();
    String SQL_CREATE_DB = "CREATE DATABASE hotel";
    String SQL_CREATE_TABLE_POKOJE = "CREATE TABLE pokoje(" +
            "   idpokoju   INT AUTO_INCREMENT," +
            "   nazwapokoju text      NOT NULL," +
            "   iloscosob  INT              NOT NULL," +
            "   cena  INT NOT NULL ,      " +
            "   PRIMARY KEY (idpokoju));";

    String SQL_CREATE_TABLE_REZERWACJE = "CREATE TABLE rezerwacje( " +
            " idzamowienia   INT AUTO_INCREMENT, " +
            " imie text      NOT NULL, " +
            " nazwisko  text NOT NULL," +
            " idpokoju  INT NOT NULL ,      " +
            " dataod  date NOT NULL ,     " +
            " datado  date NOT NULL ,      " +
            " PRIMARY KEY (idzamowienia)," +
            " FOREIGN KEY (idpokoju) REFERENCES pokoje(idpokoju) );";

    public void CreateDB() throws FileNotFoundException {
        StackTracerFile stackTracerFile = new StackTracerFile();
        System.out.println("Creating new database...");
        try{
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = con.prepareStatement(SQL_CREATE_DB);
            preparedStatement.executeUpdate();
        }catch(SQLException sqlEx){
            stackTracerFile.saveExceptionToFile(sqlEx);
            System.out.println("UPS cos poszlo nie tak ...");
        }catch(Exception ex){
            stackTracerFile.saveExceptionToFile(ex);
            System.out.println("UPS cos poszlo nie tak ...");
        }
    }
    public void CreateTables() throws FileNotFoundException {
        Connection con = DatabaseConnection.getCon();
        try{
            PreparedStatement preparedStatement = con.prepareStatement(SQL_CREATE_TABLE_POKOJE);
            preparedStatement.executeUpdate();
        }catch(SQLException sqlEx){
            stackTracerFile.saveExceptionToFile(sqlEx);
            System.out.println("UPS cos poszlo nie tak ...");
        }catch(Exception ex){
            stackTracerFile.saveExceptionToFile(ex);
            System.out.println("UPS cos poszlo nie tak ...");
        }
        try{
            PreparedStatement preparedStatement = con.prepareStatement(SQL_CREATE_TABLE_REZERWACJE);
            preparedStatement.executeUpdate();
        }catch(SQLException sqlEx){
            stackTracerFile.saveExceptionToFile(sqlEx);
            System.out.println("UPS cos poszlo nie tak ...");
        }
        catch(Exception ex){
            stackTracerFile.saveExceptionToFile(ex);
            System.out.println("UPS cos poszlo nie tak ...");
        }
    }
}