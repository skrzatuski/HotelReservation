package reservation;

import displays.*;
import config.DatabaseConnection;
import inputs.Reservation;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAllReservation {
    Connection con = null;
    Statement stt = null;
    Reservation reservation;
    final private String SQL_SELECT_RESERVATION = "SELECT * FROM rezerwacje";
    public void showReservation() {
        reservation = new Reservation();
        try {
            con = DatabaseConnection.getCon();
            if (con != null) {
                stt = con.createStatement();
                ResultSet rs = stt.executeQuery(SQL_SELECT_RESERVATION);
                while (rs.next()) {
                    reservation.setReservationId(rs.getInt("idzamowienia"));
                    reservation.setName(rs.getString("imie"));
                    reservation.setSurname(rs.getString("nazwisko"));
                    reservation.setRoomId(rs.getInt("idpokoju"));
                    reservation.setDateStart(rs.getString("dataod"));
                    reservation.setDateStop(rs.getString("datado"));
                    System.out.println(reservation);
                }
                rs.close();
            }
        } catch (SQLException throwables) {
            System.out.println("UPS cos poszlo nie tak ...");
        }
    }
}
