package reservation;

import config.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckRoomAvailable{
    private boolean roomStatus;
    private Statement stt = null;
    private String sql;
    private ResultSet resultSet;
    public boolean CheckRoom(String dateStart, String dateStop,int roomId) {
        try {
            DatabaseConnection.getCon();
            stt = DatabaseConnection.getCon().createStatement();
            sql = "SELECT 1 WHERE EXISTS " +
                    "(SELECT * FROM rezerwacje WHERE rezerwacje.idpokoju="+roomId+" AND " +
                    "(rezerwacje.dataod<=" + "'" + dateStart + "'" + " AND rezerwacje.datado >=" + "'" + dateStart + "'" + ") OR "  +
                    " rezerwacje.idpokoju="+roomId+" AND " +
                    "(rezerwacje.dataod<=" + "'" + dateStop + "'" + " AND rezerwacje.datado>=" + "'" + dateStop + "'" + ")" + " OR " +
                    " rezerwacje.idpokoju="+roomId+" AND " +
                    "(rezerwacje.dataod>=" + "'" + dateStart + "'" + " AND rezerwacje.datado<=" + "'" + dateStop + "'" + "))";
            resultSet = stt.executeQuery(sql);
            checkRoomStatus();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomStatus;
    }
    public void checkRoomStatus() throws SQLException {
        if (resultSet.next()) {
            roomStatus = true;
        } else if (resultSet.next()) {
            roomStatus=false;
        }
    }

}