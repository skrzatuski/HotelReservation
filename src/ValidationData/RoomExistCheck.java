package ValidationData;

import config.DatabaseConnection;
import java.sql.*;

public class RoomExistCheck {

    public boolean roomExist(int roomId){
        String SQL_SELECT = "SELECT idpokoju FROM pokoje WHERE idpokoju=" + roomId;
        Connection con = DatabaseConnection.getCon();
        Statement stt = null;
        ResultSet rs = null;
        int pokojid;
        try{
            stt = con.createStatement();
            rs = stt.executeQuery(SQL_SELECT);
            while(rs.next()){
                pokojid = rs.getInt(1);
                if(roomId == pokojid){
                    return false;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Nie ma pokoju o takim ID");
        return true;
    }
}
