package inputs;

import ValidationData.DataCheck;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReservationUserInput {
    private Reservation reservation;
    DataCheck dataCheck = new DataCheck();
    Scanner scannerUserInput = new Scanner(System.in);
    public void readReservationUserInput(){
        reservation = new Reservation();

        System.out.println("Podaj imie: ");
        reservation.setName(scannerUserInput.next());
        System.out.println("Podaj nazwisko: ");
        reservation.setSurname(scannerUserInput.next());
        System.out.println("Podaj nr pokoju: ");
        reservation.setRoomId(scannerUserInput.nextInt());
        UserInputDataStart();
        UserInputDataStop();
    }
    public Reservation getReservationUserInput() {
        return this.reservation;
    }
    public void UserInputDataStart(){
        do{
            System.out.println("Podaj date od(YYYY-mm-dd): ");
            reservation.setDateStart(scannerUserInput.next());
        }while(dataCheck.CheckingData(reservation.getDateStart()));
    }
    public void UserInputDataStop() {
            do {
                System.out.println("Podaj date do(YYYY-mm-dd): ");
                reservation.setDateStop(scannerUserInput.next());
            } while (dataCheck.CheckingData(reservation.getDateStop()));
    }
}
