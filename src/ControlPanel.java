import javax.xml.crypto.Data;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlPanel extends Database {
    String wybor;

    DisplayMenu dmenu1 = new DisplayMenu();
    Scanner input = new Scanner(System.in);
    void ChooseMenu(){
        try {
            dmenu1.DisplayChooseMenu();
            wybor = input.next();
            if (wybor.equals("1")||wybor.equals("2")||wybor.equals("3")) {
                if(wybor.equals("1")) {
                    ExecuteReservation();
                }else if(wybor.equals("2")) {
                    ShowReservation();
                }else if(wybor.equals("3")){
                    ShowFreeRooms();
                }
            }else{
                throw new InputMismatchException("Not valid choice");
            }
        }catch(InputMismatchException ex){
            System.out.println("Zły wybór, wybierz ponownie");
        }
    }
}
