import config.Database;

public class HotelReservationMain {
    public static void main(String[] args) {
        ControlPanel c1 = new ControlPanel();
        Database d1 = new Database();
        /*Main loop*/
        do{
            c1.ChooseMenu();
        }while(true);
    }
}

