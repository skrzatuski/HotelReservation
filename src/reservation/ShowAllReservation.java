package reservation;

import displays.*;
import config.DatabaseConnection;
import inputs.Reservation;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAllReservation {
    DisplayMenu displaymenu;
    Connection con = null;
    Statement stt = null;
    Reservation userinput;
    final private String SQL_SELECT_REZERWACJE_pokaz = "SELECT * FROM rezerwacje";
    public void ShowReservation() {
        displaymenu = new DisplayMenu();
        displaymenu.displayReservationMenu();
        userinput = new Reservation();
        try{
            con = DatabaseConnection.getCon();
            stt = con.createStatement();
            ResultSet rs = stt.executeQuery(SQL_SELECT_REZERWACJE_pokaz);
            while(rs.next()){
                userinput.setReservationId(rs.getInt("idzamowienia"));
                userinput.setName(rs.getString("imie"));
                userinput.setSurname(rs.getString("nazwisko"));
                userinput.setRoomId(rs.getInt("idpokoju"));
                userinput.setDateStart(rs.getString("dataod"));
                userinput.setDateStop(rs.getString("datado"));
                System.out.print(userinput.getReservationId()+" ");
                System.out.print(userinput.getName()+" ");
                System.out.print(userinput.getSurname()+" ");
                System.out.print(userinput.getRoomId()+" ");
                System.out.print(userinput.getDateStart()+" ");
                System.out.println(userinput.getDateStop()+" ");
            }
            rs.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
