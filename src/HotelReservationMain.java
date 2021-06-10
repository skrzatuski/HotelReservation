import config.DBExistCheck;
import config.DatabaseConnection;
import menu.MainMenu;
import java.sql.Connection;


public class HotelReservationMain {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        DBExistCheck dbConnectionCheck = new DBExistCheck();
        dbConnectionCheck.addDatabase();
        /*Main loop*/
        do{
            mainMenu.ChooseMenu();
        }while(true);
    }
}