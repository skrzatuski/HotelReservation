package menu;

import displays.DisplayMenu;
import rooms.RoomGenerator;
import rooms.ShowAllRooms;
import validationdata.ChooseMenuInputCheck;

import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;

public class RoomMenu {
    private int choice;
    private DisplayMenu displayMenu;
    private RoomGenerator roomGenerator;
    private ShowAllRooms showAllRooms;
    public void chooseMenu() throws FileNotFoundException {
        displayMenu = new DisplayMenu();
        roomGenerator = new RoomGenerator();
        showAllRooms = new ShowAllRooms();
        ChooseMenuInputCheck chooseMenuInputCheck = new ChooseMenuInputCheck();
        AtomicBoolean roomMenuStatus = new AtomicBoolean(false);
        do {
            displayMenu.roomChoseMenu();
            choice = chooseMenuInputCheck.inputCheck();
            switch (choice) {
                case 1 -> {
                    displayMenu.roomMenu();
                    roomGenerator.createRoom();
                    roomMenuStatus.set(false);
                }
                case 2 -> {
                    displayMenu.roomMenu();
                    showAllRooms.showAllRooms();
                    roomMenuStatus.set(false);
                }
                case 3 -> roomMenuStatus.set(false);
                case 4 -> roomMenuStatus.set(false);
                case 0 -> roomMenuStatus.set(false);
            }
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 0) {
                System.out.println("Zły wybór");
                roomMenuStatus.set(true);
            }
        }while(roomMenuStatus.get());
        }
    }

