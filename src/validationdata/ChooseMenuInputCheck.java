package validationdata;

import java.util.Scanner;

public class ChooseMenuInputCheck {
    Scanner input = new Scanner(System.in);
    public int inputCheck(){
        int choice;
        do {
            while (!input.hasNextInt()) {
                System.out.println("zły wybór");
                input.next();
            }
            choice = input.nextInt();
        }while(choice <0 );
        return choice;
    }
}
