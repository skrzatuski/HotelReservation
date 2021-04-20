import displays.DisplayMenu;
import inputs.Reservation;
import reservation.CreateReservation;
import reservation.DeleteReservation;
import reservation.ShowAllReservation;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ControlPanel extends Reservation {
    private final DisplayMenu displayMenu = new DisplayMenu();
    ShowAllReservation showAllReservation;
    CreateReservation createReservation;
    DeleteReservation deleteReservation;
    Scanner input = new Scanner(System.in);
    void ChooseMenu(){
        try {
            deleteReservation = new DeleteReservation();
            showAllReservation = new ShowAllReservation();
            displayMenu.displayChooseMenu();
            int choice = input.nextInt();
            createReservation = new CreateReservation();
            if (choice == 1) {
                createReservation.createReservation1();
            }else if(choice ==2) {
                showAllReservation.ShowReservation();
            }else if(choice ==3) {
                deleteReservation.deleteReservation();
            }else{
                throw new InputMismatchException("Not valid choice");
            }
        }catch(InputMismatchException ex){
            System.out.println("Zły wybór, wybierz ponownie");
        }
    }
}
