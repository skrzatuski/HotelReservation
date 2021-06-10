package config;

import java.sql.Connection;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

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
            System.out.println("Brak bazy danych");
            return false;
        }
    }
    public void addDatabase(){
        Scanner scanner = new Scanner(System.in);
        conSQL = DatabaseConnection.getSqlCon();
        AtomicBoolean addDatabaseVerification = new AtomicBoolean(false);
        if(conSQL != null){
            if(!checkIfDbExists()){
                do {
                    System.out.println("Czy chcesz utworzyc baze danych? T)ak/N)ie");
                    String confirmation = scanner.next().toUpperCase();
                    if (confirmation.equals("T")) {
                        createDatabase.CreateDB();
                        createDatabase.CreateTables();
                        exampleDataInsert.DataInsert();
                        System.out.println("Utworzono baze danych!");
                        addDatabaseVerification.set(false);
                    } else if (confirmation.equals("N")) {
                        System.out.println("Nie utworzono bazy danych");
                        addDatabaseVerification.set(false);
                    }
                    if (!confirmation.equals("T") && !confirmation.equals("N")) {
                        System.out.println("Zly wybor");
                        addDatabaseVerification.set(true);
                    }
                }while(addDatabaseVerification.get());
                }
            }
        }
}