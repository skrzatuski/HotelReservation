package menu;

import displays.DisplayMenu;
import rooms.RoomGenerator;
import rooms.ShowAllRooms;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomMenu {
    private int choice;
    private Scanner scanner;
    private DisplayMenu displayMenu;
    private RoomGenerator roomGenerator;
    private ShowAllRooms showAllRooms;
    public void chooseMenu(){
        displayMenu = new DisplayMenu();
        roomGenerator = new RoomGenerator();
        showAllRooms = new ShowAllRooms();
        displayMenu.roomChoseMenu();
        scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        if(choice == 1){
            displayMenu.roomMenu();
            roomGenerator.CreateRoom();
        }else if(choice == 2){
            displayMenu.roomMenu();
            showAllRooms.showAllRooms();
        }else if(choice == 3){

        }else if(choice == 0){

        }else{
            throw new InputMismatchException("wrong choice");
        }
    }
}
