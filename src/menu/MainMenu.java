package menu;

import displays.DisplayMenu;
import rooms.RoomGenerator;
import validationdata.ChooseMenuInputCheck;

import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;


public class MainMenu {
    private final DisplayMenu displayMenu = new DisplayMenu();
    ReservationMenu reservationMenu;
    RoomGenerator roomGenerator;
    RoomMenu roomMenu;
    public void ChooseMenu() throws FileNotFoundException {
            roomMenu = new RoomMenu();
            reservationMenu = new ReservationMenu();
            roomGenerator = new RoomGenerator();
            AtomicBoolean mainMenuStatus = new AtomicBoolean(false);
            ChooseMenuInputCheck mainMenuInputCheck = new ChooseMenuInputCheck();
            do {
                    displayMenu.mainChooseMenu();
                    int choice = mainMenuInputCheck.inputCheck();
                    switch (choice) {
                        case 1 -> {
                            reservationMenu.chooseMenu();
                            mainMenuStatus.set(false);
                        }
                        case 2 -> {
                            roomMenu.chooseMenu();
                            mainMenuStatus.set(false);
                        }
                        case 3 -> {
                            System.exit(0);
                            mainMenuStatus.set(false);
                        }
                    }
                    mainMenuStatus.set(true);
            }while(mainMenuStatus.get());
    }
}
