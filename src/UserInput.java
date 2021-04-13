import java.util.Scanner;

public class UserInput {
    String name;
    String surname;
    int roomId;
    String dateStart;
    String dateStop;
    void ReadData() {
        Scanner s2 = new Scanner(System.in);
        System.out.println("Podaj imie: ");
        name = s2.next();
        System.out.println("Podaj nazwisko: ");
        surname = s2.next();
        System.out.println("Podaj nr pokoju: ");
        roomId = s2.nextInt();
        System.out.println("Podaj date od(RRRR-MM-DD): ");
        dateStart = s2.next();
        System.out.println("Podaj date do(RRRR-MM-DD): ");
        dateStop = s2.next();
    }
    public String getName(){
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getRoomId() {
        return roomId;
    }
    public String getDateStart() {
        return dateStart;
    }
    public String getDateStop() {
        return dateStop;
    }
}
