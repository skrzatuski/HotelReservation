package menu;

import displays.DisplayMenu;
import rooms.RoomGenerator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;


public class MainMenu {
    private final DisplayMenu displayMenu = new DisplayMenu();
    ReservationMenu reservationMenu;
    RoomGenerator roomGenerator;
    Scanner input = new Scanner(System.in);
    RoomMenu roomMenu;
    public void ChooseMenu() {
            roomMenu = new RoomMenu();
            reservationMenu = new ReservationMenu();
            roomGenerator = new RoomGenerator();
            AtomicBoolean mainMenuStatus = new AtomicBoolean(false);
            do {
                displayMenu.mainChooseMenu();
                int choice = input.nextInt();
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
                if (choice != 1 && choice != 2 && choice != 3) {
                    System.out.println("Zły wybór");
                    mainMenuStatus.set(true);
                }
            }while(mainMenuStatus.get());
    }
}
