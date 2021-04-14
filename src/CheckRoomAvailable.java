import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckRoomAvailable extends Database {
    String dateStart;
    String dateStop;
    int roomId;
    boolean roomStatus;

    public void CheckRoom(String dateStart, String dateStop, int roomId) {
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.roomId = roomId;
        try {
            con = DriverManager.getConnection(url + dbName, userName, password);
            stt = con.createStatement();
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
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateStop() {
        return dateStop;
    }

    public int getRoomId() {
        return roomId;
    }
}
