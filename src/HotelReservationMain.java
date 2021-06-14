import config.DBExistCheck;
import menu.MainMenu;

import java.io.FileNotFoundException;


public class HotelReservationMain {
    public static void main(String[] args) throws FileNotFoundException {
        MainMenu mainMenu = new MainMenu();
        DBExistCheck dbConnectionCheck = new DBExistCheck();
        dbConnectionCheck.addDatabase();
        /*Main loop*/
        do{
            mainMenu.ChooseMenu();
        }while(true);
    }
}