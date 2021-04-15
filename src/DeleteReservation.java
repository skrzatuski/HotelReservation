import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class DeleteReservation extends Database {
    int rezId;
    String conf;
    Scanner scanner = new Scanner(System.in);
    void DeleteReservation() {
        System.out.print("Podaj ID rezerwacji do usuniecia: ");
        rezId = scanner.nextInt();
        try {
            con = DriverManager.getConnection(url + dbName, userName, password);
            stt = con.createStatement();
            sql = "DELETE FROM rezerwacje WHERE idzamowienia=" + "'" + rezId + "'";
            System.out.println("Czy na pewno chcesz usunać " + rezId + " rezerwacje? T)ak/N)ie");
            conf = scanner.next().toUpperCase();
            try {
                if (conf.equals("T")) {
                    stt.executeUpdate(sql);
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
