package reservation;

import config.*;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class DeleteReservation {
    private int reservationId;
    String conf;
    Scanner scanner = new Scanner(System.in);
    public void deleteReservation() {
        try {
                Connection con = DatabaseConnection.getCon();
                 if(con !=null)
                 {
                     System.out.print("Podaj ID rezerwacji do usuniecia: ");
                     reservationId = scanner.nextInt();
                     Statement stt = con.createStatement();
                     String SQL_DELETE_RESERVATION = "DELETE FROM rezerwacje WHERE idzamowienia=" + "'" + reservationId + "'";
                     AtomicBoolean deleteVerification = new AtomicBoolean(false);
                         do {
                             System.out.println("Czy na pewno chcesz usunać " + reservationId + " rezerwacje? T)ak/N)ie");
                             conf = scanner.next().toUpperCase();
                             if (conf.equals("T")) {
                                 stt.executeUpdate(SQL_DELETE_RESERVATION);
                                 System.out.println("Poprawnie usunięto rezerwacje");
                                 deleteVerification.set(false);
                             } else if (conf.equals("N")) {
                                 System.out.println("Nie usunieto rezerwacji");
                                 deleteVerification.set(false);
                             } else if (!conf.equals("T") && !conf.equals("N")) {
                                 System.out.println("Zly wybor");
                                 deleteVerification.set(true);
                             }
                         }while(deleteVerification.get());
                 }
        }catch(SQLException throwables) {
                //throwables.printStackTrace();
            System.out.println("SQLException happend...");
        }
    }
}