package inputs;

import java.util.Scanner;

public class RoomGeneratorUserInput {
    Room room;
    Scanner scanner;
    public void readRoomGeneratorUserInput(){
        room = new Room();
        scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pokoju: ");
        room.setRoomName(scanner.next());
        System.out.println("Podaj ilu osobowy jest pokoj: ");
        room.setRoomPersonCap(scanner.nextInt());
        System.out.println("Podaj cene pokoju: ");
        room.setPrice(scanner.nextInt());
    }
    public Room getRoomUserInput(){
        return this.room;
    }
}
