import config.CreateDatabase;
import config.DBExistCheck;
import menu.MainMenu;

public class HotelReservationMain {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        DBExistCheck dbConnectionCheck = new DBExistCheck();
        CreateDatabase createDatabase = new CreateDatabase();

        /*Main loop*/
        do{
            createDatabase.CreateDB();
            createDatabase.CreateTables();
            dbConnectionCheck.checkIfDbExists();
            mainMenu.ChooseMenu();
        }while(true);
    }
}

