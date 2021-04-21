import menu.ControlPanel;

public class HotelReservationMain {
    public static void main(String[] args) {
        ControlPanel controlPanel = new ControlPanel();
        /*Main loop*/
        do{
            controlPanel.ChooseMenu();
        }while(true);
    }
}

