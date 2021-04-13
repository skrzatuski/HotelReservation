import java.util.Scanner;

public class UserInput {
    String name;
    String surname;
    int roomId;
    int dateStart;
    int dateStop;
    void ReadData() {
        Scanner s2 = new Scanner(System.in);
        System.out.println("Podaj imie: ");
        name = s2.next();
        System.out.println("Podaj nazwisko: ");
        surname = s2.next();
        System.out.println("Podaj nr pokoju: ");
        roomId = s2.nextInt();
        System.out.println("Podaj date od: ");
        dateStart = s2.nextInt();
        System.out.println("Podaj date do: ");
        dateStop = s2.nextInt();
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
    public int getDateStart() {
        return dateStart;
    }
    public int getDateStop() {
        return dateStop;
    }
}
