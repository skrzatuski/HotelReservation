package menu;

import displays.DisplayMenu;
import reservation.CreateReservation;
import reservation.DeleteReservation;
import reservation.ShowAllReservation;
import rooms.RoomGenerator;
import rooms.ShowAllRooms;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ControlPanel{
    private final DisplayMenu displayMenu = new DisplayMenu();
    ShowAllReservation showAllReservation;
    CreateReservation createReservation;
    DeleteReservation deleteReservation;
    RoomGenerator roomGenerator;
    ShowAllRooms showAllRooms;
    Scanner input = new Scanner(System.in);
    public void ChooseMenu(){
        try {
            deleteReservation = new DeleteReservation();
            showAllReservation = new ShowAllReservation();
            showAllRooms = new ShowAllRooms();
            roomGenerator = new RoomGenerator();
            displayMenu.displayChooseMenu();
            int choice = input.nextInt();
            createReservation = new CreateReservation();
            if (choice == 1) {
                createReservation.createReservation1();
            }else if(choice ==2) {
                showAllReservation.ShowReservation();
            }else if(choice ==3) {
                deleteReservation.deleteReservation();
            }else if(choice == 4) {
               roomGenerator.CreateRoom();
            }else if(choice == 5){
                showAllRooms.showAllRooms();
            }else{
                throw new InputMismatchException("Not valid choice");
            }
        }catch(InputMismatchException ex){
            System.out.println("Zły wybór, wybierz ponownie");
        }
    }
}
