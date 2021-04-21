package reservation;

import config.*;

import java.sql.*;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteReservation {
    private int reservationId;
    String conf;
    Scanner scanner = new Scanner(System.in);
    public void deleteReservation() {
        System.out.print("Podaj ID rezerwacji do usuniecia: ");
        reservationId = scanner.nextInt();
        try {
            Connection con = DatabaseConnection.getCon();
            Statement stt = con.createStatement();
            String SQL_DELETE_RESERVATION = "DELETE FROM rezerwacje WHERE idzamowienia=" + "'" + reservationId + "'";
            System.out.println("Czy na pewno chcesz usunać " + reservationId + " rezerwacje? T)ak/N)ie");
            conf = scanner.next().toUpperCase();
            try {
                if (conf.equals("T")) {
                    stt.executeUpdate(SQL_DELETE_RESERVATION);
                    System.out.println("Poprawnie usunięto rezerwacje");
                } else if (conf.equals("N")) {
                    System.out.println("Nie usunieto rezerwacji");
                } else {
                    throw new InputMismatchException("Bledny wybor");
                }
            }catch(InputMismatchException ex){
                System.out.println("Bledny wybor");
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}