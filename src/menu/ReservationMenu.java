package menu;

import displays.DisplayMenu;
import reservation.CreateReservation;
import reservation.DeleteReservation;
import reservation.ShowAllReservation;

import java.util.InputMismatchException;
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
        if(choice == 1){
            displayMenu.displayReservationMenu();
            createReservation.createReservation1();
        }else if(choice == 2){
            displayMenu.displayReservationMenu();
            showAllReservation.ShowReservation();
        }else if(choice == 3){
            displayMenu.deleteReservation();
            deleteReservation.deleteReservation();
        }else if(choice == 0){
            return;
        }else{
            throw new InputMismatchException("wrong choice");
        }
    }
}
