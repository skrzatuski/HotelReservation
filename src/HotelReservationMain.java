import config.CreateDatabase;
import config.DBExistCheck;
import config.ExampleDataInsert;
import menu.MainMenu;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class HotelReservationMain {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        DBExistCheck dbConnectionCheck = new DBExistCheck();
        CreateDatabase createDatabase = new CreateDatabase();
        ExampleDataInsert exampleDataInsert = new ExampleDataInsert();
        /*Checking db*/
        dbConnectionCheck.checkIfDbExists();
        if(dbConnectionCheck.isDbStatus()){
            System.out.println("Connection succesfull");
        }else{
            System.out.println("Creating new database");
            createDatabase.CreateDB();
            createDatabase.CreateTables();
            exampleDataInsert.DataInsert();
        }
        /*Main loop*/
        do{
            mainMenu.ChooseMenu();
        }while(true);
    }
}

