package inputs;

import java.util.Scanner;

public class RoomGeneratorUserInput {
    Room room;
    Scanner scanner;
    private boolean status = false;
    public void readRoomGeneratorUserInput(){
        room = new Room();
        scanner = new Scanner(System.in);
        UserInputRoomName();
        UserInputRoomPersonCap();
        UserInputRoomPrice();
    }
    public Room getRoomUserInput(){
        return this.room;
    }
    public void UserInputRoomPersonCap(){
        status = false;
        do{
            System.out.println("Podaj ilu osobowy jest pokoj: ");
            if(scanner.hasNextInt()) {
                room.setRoomPersonCap(scanner.nextInt());
                status = false;
            }else
            {
                System.out.println("Zly format, podaj liczbe");
                status = true;
                scanner.next();
            }
        }while(status);
    }
    public void UserInputRoomName(){
        System.out.println("Podaj nazwe pokoju: ");
        room.setRoomName(scanner.next());
    }
    public void UserInputRoomPrice(){
        status = false;
        do{
            System.out.println("Podaj cene pokoju: ");
            if(scanner.hasNextInt()) {
                room.setPrice(scanner.nextInt());
                status = false;
            }else
            {
                System.out.println("Zly format, podaj liczbe");
                status = true;
                scanner.next();
            }
        }while(status);
    }
}
