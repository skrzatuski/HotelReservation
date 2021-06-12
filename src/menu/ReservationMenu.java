package menu;

import displays.DisplayMenu;
import reservation.CreateReservation;
import reservation.DeleteReservation;
import reservation.ShowAllReservation;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReservationMenu {
    private int choice;
    private Scanner scanner;
    private ShowAllReservation showAllReservation;
    private CreateReservation createReservation;
    private DeleteReservation deleteReservation;
    DisplayMenu displayMenu;
    public void chooseMenu() throws FileNotFoundException {
        displayMenu = new DisplayMenu();
        createReservation = new CreateReservation();
        showAllReservation = new ShowAllReservation();
        deleteReservation = new DeleteReservation();
        scanner = new Scanner(System.in);
        AtomicBoolean reservationMenuStatus = new AtomicBoolean(false);
        do {
            displayMenu.reservationChooseMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayMenu.displayReservationMenu();
                    createReservation.createReservation1();
                    reservationMenuStatus.set(false);
                    break;
                case 2:
                    displayMenu.displayReservationMenu();
                    showAllReservation.showReservation();
                    reservationMenuStatus.set(false);
                    break;
                case 3:
                    displayMenu.deleteReservation();
                    deleteReservation.deleteReservation();
                    reservationMenuStatus.set(false);
                    break;
                case 0:
                    reservationMenuStatus.set(false);
                    break;
            }
            if (choice != 1 && choice != 2 && choice != 3 && choice != 0) {
                System.out.println("Zły wybór");
                reservationMenuStatus.set(true);
            }
        }while(reservationMenuStatus.get());
    }
}
