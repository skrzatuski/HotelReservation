package config;

import errorscatcher.StackTracerFile;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExampleDataInsert {
    String SQL_POKOJE_INSERT = "INSERT INTO pokoje VALUES (NULL, \"bajkowy1\",4,60), (NULL, \"bajkowy2\",3,70), (NULL, \"bajkowy3\",1,30), (NULL, \"bajkowy4\",5,100)";
    String SQL_REZERWACJE_INSERT = "INSERT INTO rezerwacje VALUES " +
            "(NULL,\"Artur\",\"Pietruszewski\",1,\"2021-01-15\",\"2021-01-20\"), " +
            "(NULL,\"Harvey\",\"Specter\",2,\"2021-01-15\",\"2021-01-20\")";
    StackTracerFile stackTracerFile = new StackTracerFile();
    public void DataInsert() throws FileNotFoundException {
        Connection con = DatabaseConnection.getCon();
        try{
            PreparedStatement preparedStatement = con.prepareStatement(SQL_POKOJE_INSERT);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlEx) {
            stackTracerFile.saveExceptionToFile(sqlEx);
            System.out.println("UPS cos poszlo nie tak ...");
        }catch(Exception ex){
            stackTracerFile.saveExceptionToFile(ex);
            System.out.println("UPS cos poszlo nie tak ...");
        }
        try{
            PreparedStatement preparedStatement = con.prepareStatement(SQL_REZERWACJE_INSERT);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlEx) {
            stackTracerFile.saveExceptionToFile(sqlEx);
            System.out.println("UPS cos poszlo nie tak ...");
        }catch(Exception ex){
            stackTracerFile.saveExceptionToFile(ex);
            System.out.println("UPS cos poszlo nie tak ...");
        }
    }
}