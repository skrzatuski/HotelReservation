package inputs;

import java.util.Scanner;

public class ReservationUserInput {
    private Reservation reservation;
    public void readReservationUserInput(){
        reservation = new Reservation();
        Scanner scannerUserInput = new Scanner(System.in);
        System.out.println("Podaj imie: ");
        reservation.setName(scannerUserInput.next());
        System.out.println("Podaj nazwisko: ");
        reservation.setSurname(scannerUserInput.next());
        System.out.println("Podaj nr pokoju: ");
        reservation.setRoomId(scannerUserInput.nextInt());
        System.out.println("Podaj date od(RRRR-MM-DD): ");
        reservation.setDateStart(scannerUserInput.next());
        System.out.println("Podaj date do(RRRR-MM-DD): ");
        reservation.setDateStop(scannerUserInput.next());
    }
    public Reservation getReservationUserInput() {
        return this.reservation;
    }
}
