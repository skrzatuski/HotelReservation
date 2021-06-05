package menu;

import displays.DisplayMenu;
import reservation.CreateReservation;
import reservation.DeleteReservation;
import reservation.ShowAllReservation;
import rooms.RoomGenerator;
import rooms.ShowAllRooms;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainMenu {
    private final DisplayMenu displayMenu = new DisplayMenu();
    ReservationMenu reservationMenu;
    RoomGenerator roomGenerator;
    ShowAllRooms showAllRooms;
    Scanner input = new Scanner(System.in);
    RoomMenu roomMenu;

    public void ChooseMenu() {
        try {
            roomMenu = new RoomMenu();
            reservationMenu = new ReservationMenu();
            roomGenerator = new RoomGenerator();
            displayMenu.mainChooseMenu();
            int choice = input.nextInt();
            switch(choice) {
                case 1:
                    reservationMenu.chooseMenu();
                    break;
                case 2:
                    roomMenu.chooseMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
            if (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Zły wybór");
            }
        }catch(InputMismatchException ex){
            System.out.println("Zły wybór, wybierz ponownie");
        }
    }
}
