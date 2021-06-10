package config;

import java.sql.Connection;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        conSQL = DatabaseConnection.getSqlCon();
        if(conSQL != null){
            if(!checkIfDbExists()){
                    System.out.println("Czy chcesz utworzyc baze danych?");
                    String confirmation = scanner.next().toUpperCase();
                    if(confirmation.equals("T")) {
                        createDatabase.CreateDB();
                        createDatabase.CreateTables();
                        exampleDataInsert.DataInsert();
                    }else
                    {

                    }
                }
            }
        }
}