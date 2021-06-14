package rooms;

import config.DatabaseConnection;
import errorscatcher.StackTracerFile;
import inputs.Room;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowAllRooms {
    Room room;
    Connection connection;
    Statement statement;
    StackTracerFile stackTracerFile = new StackTracerFile();
    public void showAllRooms() throws FileNotFoundException {
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
        } catch (SQLException sqlEx){
            stackTracerFile.saveExceptionToFile(sqlEx);
            System.out.println("UPS cos poszlo nie tak ...");
        } catch (Exception ex) {
            stackTracerFile.saveExceptionToFile(ex);
            ex.printStackTrace();
        }
    }
}
