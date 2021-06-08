package menu;

import displays.DisplayMenu;
import rooms.RoomGenerator;
import rooms.ShowAllRooms;

import java.util.Scanner;

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
        displayMenu.roomChoseMenu();
        scanner = new Scanner(System.in);
        choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayMenu.roomMenu();
                    roomGenerator.createRoom();
                    break;
                case 2:
                    displayMenu.roomMenu();
                    showAllRooms.showAllRooms();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
            }
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 0) {
                System.out.println("Zły wybór");
            }
        }
    }

