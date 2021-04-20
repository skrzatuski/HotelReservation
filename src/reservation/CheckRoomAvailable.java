package reservation;

import config.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckRoomAvailable{
    boolean roomStatus;
    Statement stt = null;
    String sql;
    public boolean CheckRoom(String dateStart, String dateStop) {
        try {
            DatabaseConnection.getCon();
            stt = DatabaseConnection.getCon().createStatement();
            System.out.println(dateStart);
            System.out.println(dateStop);
            sql = "SELECT 1 WHERE EXISTS " +
                    "(SELECT * FROM rezerwacje WHERE rezerwacje.idpokoju=1 AND " +
                    "(rezerwacje.dataod<=" + "'" + dateStart + "'" + " AND rezerwacje.datado >=" + "'" + dateStart + "'" + ") OR " +
                    "(rezerwacje.dataod<=" + "'" + dateStop + "'" + " AND rezerwacje.datado>=" + "'" + dateStop + "'" + ")" + " OR " +
                    "(rezerwacje.dataod>=" + "'" + dateStart + "'" + " AND rezerwacje.datado<=" + "'" + dateStop + "'" + "))";
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next() == true) {
                roomStatus = true;
            } else if (rs.next() == false) {
                roomStatus=false;
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomStatus;
    }

}