package displays;

import config.*;

public class DisplayMenu {
    public String LINE_SEPARATOR = ("------------------------------");
    public void displayChooseMenu(){
        System.out.println(LINE_SEPARATOR);
        System.out.println("             MENU             ");
        System.out.println(LINE_SEPARATOR);
        System.out.println("1 - Dokonaj rezerwacji");
        System.out.println("2 - Weświetl rezerwacje");
        System.out.println("3 - Usun rezerwacje");
        System.out.println("4 - Dodaj Pokoj");
        System.out.println("5 - Pokaz wszystkie pokoje");
    }
    public void displayReservationMenu(){
        System.out.println(LINE_SEPARATOR);
        System.out.println("          REZERWACJE          ");
        System.out.println(LINE_SEPARATOR);
    }
    public void deleteReservation(){
            System.out.println(LINE_SEPARATOR);
            System.out.println("         USUN REZERWACJE         ");
            System.out.println(LINE_SEPARATOR);
        }
}
