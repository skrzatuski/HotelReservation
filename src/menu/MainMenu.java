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
    public void ChooseMenu(){
        try {
            roomMenu = new RoomMenu();
            reservationMenu = new ReservationMenu();
            roomGenerator = new RoomGenerator();
            displayMenu.mainChooseMenu();
            int choice = input.nextInt();

            if (choice == 1) {
                reservationMenu.chooseMenu();
            }else if(choice ==2) {
                roomMenu.chooseMenu();
            }else if(choice ==0) {
                System.exit(0);
            }else{
                throw new InputMismatchException("Not valid choice");
            }
        }catch(InputMismatchException ex){
            System.out.println("Zły wybór, wybierz ponownie");
        }
    }
}
