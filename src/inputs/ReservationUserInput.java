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
        UserInputFirstNameSurname();
        UserInputRoomID();
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
        //do {
            do {
        System.out.println("Podaj date do(YYYY-mm-d): ");
        reservation.setDateStop(scannerUserInput.next());
                } while (dataCheck.CheckingData(reservation.getDateStop()));
           // }while(DataStartStopCheck());
    }
    public void UserInputRoomID(){
            do {
                    System.out.println("Podaj nr pokoju: ");
                    if(scannerUserInput.hasNextInt()) {
                        reservation.setRoomId(scannerUserInput.nextInt());
                    }else
                    {
                        System.out.println("Zly format, podaj liczbe");
                        scannerUserInput.next();
                    }
            } while (roomExistCheck.RoomExist(reservation.getRoomId()));
    }
    public void UserInputFirstNameSurname(){
        System.out.println("Podaj imie: ");
        reservation.setName(scannerUserInput.next());
        System.out.println("Podaj nazwisko: ");
        reservation.setSurname(scannerUserInput.next());
    }
}
