package menu;

import displays.DisplayMenu;
import rooms.RoomGenerator;
import rooms.ShowAllRooms;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class RoomMenu {
    private int choice;
    private Scanner scanner;
    private DisplayMenu displayMenu;
    private RoomGenerator roomGenerator;
    private ShowAllRooms showAllRooms;
    public void chooseMenu() {
        displayMenu = new DisplayMenu();
        roomGenerator = new RoomGenerator();
        showAllRooms = new ShowAllRooms();
        scanner = new Scanner(System.in);
        AtomicBoolean roomMenuStatus = new AtomicBoolean(false);
        do {
            displayMenu.roomChoseMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayMenu.roomMenu();
                    roomGenerator.createRoom();
                    roomMenuStatus.set(false);
                    break;
                case 2:
                    displayMenu.roomMenu();
                    showAllRooms.showAllRooms();
                    roomMenuStatus.set(false);
                    break;
                case 3:
                    roomMenuStatus.set(false);
                    break;
                case 4:
                    roomMenuStatus.set(false);
                    break;
                case 0:
                    roomMenuStatus.set(false);
                    break;
            }
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 0) {
                System.out.println("Zły wybór");
                roomMenuStatus.set(true);
            }
        }while(roomMenuStatus.get());
        }
    }

