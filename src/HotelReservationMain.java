import menu.MainMenu;

public class HotelReservationMain {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        /*Main loop*/
        do{
            mainMenu.ChooseMenu();
        }while(true);
    }
}

