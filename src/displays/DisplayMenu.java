package displays;

import config.*;

public class DisplayMenu {
    public String LINE_SEPARATOR = ("------------------------------");
    public void reservationChooseMenu(){
        displayReservationMenu();
        System.out.println("1 - Dokonaj rezerwacji");
        System.out.println("2 - Weświetl rezerwacje");
        System.out.println("3 - Usun rezerwacje");
        System.out.println("0 - Wroc do głownego menu");
    }
    public void roomChoseMenu(){
        roomMenu();
        System.out.println("1 - Dodaj pokoj");
        System.out.println("2 - Pokaz wszystkie pokoje");
        System.out.println("3 - Wprowadz zmiany do pokoju");
        System.out.println("0 - Wroc do głownego menu");

    }
    public void mainChooseMenu(){
        System.out.println(LINE_SEPARATOR);
        System.out.println("             MENU             ");
        System.out.println(LINE_SEPARATOR);
        System.out.println("1 - Rezerwacje");
        System.out.println("2 - Pokoje");
        System.out.println("3 - Wyjscie z programu");
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
        public void roomMenu(){
            System.out.println(LINE_SEPARATOR);
            System.out.println("          POKOJE         ");
            System.out.println(LINE_SEPARATOR);
        }
}
