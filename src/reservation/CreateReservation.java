package reservation;

import config.DatabaseConnection;
import inputs.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateReservation {
    private static final String SQL_INSERT_VALUE = "INSERT INTO rezerwacje (imie,nazwisko,idpokoju,dataod,datado) VALUES (?,?,?,?,?)";
    private Reservation reservation;
    private ReservationUserInput reservationUserInput;
    private CheckRoomAvailable checkRoomAvailable;
    public void createReservation1() {
        reservationUserInput = new ReservationUserInput();
        reservation = new Reservation();
        checkRoomAvailable = new CheckRoomAvailable();
        try {
            Connection con = DatabaseConnection.getCon();
            reservationUserInput.readReserevationUserInput();
            reservationUserInput.getReservationUserInput();
            reservation = reservationUserInput.getReservationUserInput();
            if(checkRoomAvailable.CheckRoom(reservation.getDateStart(), reservation.getDateStop())){
                System.out.println("Nie można zarezerwowac pokoju w tym okresie");
            }else {
                PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT_VALUE);
                System.out.println(reservation.getName());
                preparedStatement.setString(1, reservation.getName());
                preparedStatement.setString(2, reservation.getSurname());
                preparedStatement.setString(3, String.valueOf(reservation.getRoomId()));
                preparedStatement.setString(4, String.valueOf(reservation.getDateStart()));
                preparedStatement.setString(5, String.valueOf(reservation.getDateStop()));
                preparedStatement.executeUpdate();
                con.close();
                System.out.println("Poprawnie dodano rezerwacje!");
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}