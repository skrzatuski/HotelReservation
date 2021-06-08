package menu;

import displays.DisplayMenu;
import reservation.CreateReservation;
import reservation.DeleteReservation;
import reservation.ShowAllReservation;

import java.util.Scanner;

public class ReservationMenu {
    private int choice;
    private Scanner scanner;
    private ShowAllReservation showAllReservation;
    private CreateReservation createReservation;
    private DeleteReservation deleteReservation;
    DisplayMenu displayMenu;
    public void chooseMenu(){
        displayMenu = new DisplayMenu();
        displayMenu.reservationChooseMenu();
        createReservation = new CreateReservation();
        showAllReservation = new ShowAllReservation();
        deleteReservation = new DeleteReservation();
        scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        switch(choice){
            case 1:
                displayMenu.displayReservationMenu();
                createReservation.createReservation1();
                break;
            case 2:
                displayMenu.displayReservationMenu();
                showAllReservation.showReservation();
                break;
            case 3:
                displayMenu.deleteReservation();
                deleteReservation.deleteReservation();
                break;
            case 0:
                break;
        }
        if (choice != 1 && choice != 2 && choice != 3 && choice !=0) {
            System.out.println("Zły wybór");
        }
    }
}
