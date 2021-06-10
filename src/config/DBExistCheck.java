package config;

import java.sql.Connection;

public class DBExistCheck {
    Connection con = null;
    Connection conSQL = null;
    CreateDatabase createDatabase = new CreateDatabase();
    ExampleDataInsert exampleDataInsert = new ExampleDataInsert();
    public boolean checkIfDbExists(){
        con = DatabaseConnection.getCon();
        if (con != null) {
            System.out.println("Connection successful, database exists");
            return true;
        }else{
            System.out.println("Unable to connect to DB");
            return false;
        }
    }
    public void addDatabase(){
        conSQL = DatabaseConnection.getSqlCon();
        if(conSQL != null){
            if(!checkIfDbExists()){
                    System.out.println("Proba utworzenia nowej");
                    createDatabase.CreateDB();
                    createDatabase.CreateTables();
                    exampleDataInsert.DataInsert();
                }
            }
        }
}