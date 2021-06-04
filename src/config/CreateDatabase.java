package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDatabase {
    Database database = new Database();

    String SQL_CREATE_DB = "CREATE DATABASE hotel";
    String SQL_CREATE_TABLE_POKOJE = "CREATE TABLE pokoje(\n" +
            "   idpokoju   INT AUTO_INCREMENT,\n" +
            "   nazwapokoju text      NOT NULL,\n" +
            "   iloscosob  INT              NOT NULL,\n" +
            "   cena  INT NOT NULL ,      \n" +
            "   PRIMARY KEY (idpokoju));";

    String SQL_CREATE_TABLE_REZERWACJE = "CREATE TABLE rezerwacje( \n" +
            " idzamowienia   INT AUTO_INCREMENT, \n" +
            " imie text      NOT NULL, \n" +
            " nazwisko  text NOT NULL,\n" +
            " idpokoju  INT NOT NULL ,      \n" +
            " dataod  date NOT NULL ,     \n" +
            " datado  date NOT NULL ,      \n" +
            " PRIMARY KEY (idzamowienia),\n" +
            " FOREIGN KEY (idpokoju) REFERENCES pokoje(idpokoju) );";

    public void CreateDB(){
        try{
            Connection con = DriverManager.getConnection(database.DB_URL, database.DB_USER, database.DB_PASSWORD);
            PreparedStatement preparedStatement = con.prepareStatement(SQL_CREATE_DB);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void CreateTables(){
        Connection con = DatabaseConnection.getCon();
        try{
            PreparedStatement preparedStatement = con.prepareStatement(SQL_CREATE_TABLE_POKOJE);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            PreparedStatement preparedStatement = con.prepareStatement(SQL_CREATE_TABLE_REZERWACJE);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

