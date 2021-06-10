package rooms;

import config.DatabaseConnection;
import inputs.Room;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowAllRooms {
    Room room;
    Connection connection;
    Statement statement;
    public void showAllRooms(){
        String SQL_SELECT_POKOJE = "SELECT * FROM pokoje";
        room = new Room();
        try {
            connection = DatabaseConnection.getCon();
            if(connection !=null) {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SQL_SELECT_POKOJE);
                while (resultSet.next()) {
                    room.setRoomId(resultSet.getInt("idpokoju"));
                    room.setRoomName(resultSet.getString("nazwapokoju"));
                    room.setRoomPersonCap(resultSet.getInt("iloscosob"));
                    room.setPrice(resultSet.getInt("cena"));
                    System.out.println(room);
                }
                resultSet.close();
            }
        } catch (SQLException a){
            System.out.println("SQLException happend...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
