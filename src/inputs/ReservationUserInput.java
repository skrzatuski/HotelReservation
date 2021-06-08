package inputs;


import ValidationData.DataCheck;
import ValidationData.RoomExistCheck;
import java.util.Scanner;

public class ReservationUserInput {
    private Reservation reservation;
    DataCheck dataCheck = new DataCheck();
    RoomExistCheck roomExistCheck = new RoomExistCheck();

    Scanner scannerUserInput = new Scanner(System.in);
    public void readReservationUserInput(){
        reservation = new Reservation();
        userInputFirstNameSurname();
        userInputRoomID();
        userInputDataStart();
        userInputDataStop();
    }
    public Reservation getReservationUserInput() {
        return this.reservation;
    }
    public void userInputDataStart(){
        do{
            System.out.println("Podaj date od(yyyy-MM-dd): ");
            reservation.setDateStart(scannerUserInput.next());
            System.out.println(reservation.getDateStart());
        }while(dataCheck.checkingData(reservation.getDateStart()));
    }
    public void userInputDataStop() {
        do {
            do {
        System.out.println("Podaj date do(yyyy-MM-dd): ");
        reservation.setDateStop(scannerUserInput.next());
                } while (dataCheck.checkingData(reservation.getDateStop()));
            }while(dataCheck.isDataStopGreaterThanDataStart(reservation.getDateStart(), reservation.getDateStop()));
    }
    public void userInputRoomID(){
            do {
                    System.out.println("Podaj nr pokoju: ");
                    if(scannerUserInput.hasNextInt()) {
                        reservation.setRoomId(scannerUserInput.nextInt());
                    }else
                    {
                        System.out.println("Zly format, podaj liczbe");
                        scannerUserInput.next();
                    }
            } while (roomExistCheck.roomExist(reservation.getRoomId()));
    }
    public void userInputFirstNameSurname(){
        System.out.println("Podaj imie: ");
        reservation.setName(scannerUserInput.next());
        System.out.println("Podaj nazwisko: ");
        reservation.setSurname(scannerUserInput.next());
    }
}
