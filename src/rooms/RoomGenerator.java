package rooms;

import config.DatabaseConnection;
import errorscatcher.StackTracerFile;
import inputs.*;

import java.io.FileNotFoundException;
import java.sql.*;
public class RoomGenerator {
    Connection connection;
    RoomGeneratorUserInput roomGeneratorUserInput;
    Room room;
    StackTracerFile stackTracerFile = new StackTracerFile();
    public void createRoom() throws FileNotFoundException {
        roomGeneratorUserInput = new RoomGeneratorUserInput();
        room = new Room();
        String SQL_INSERT_VALUE = "INSERT INTO pokoje (nazwapokoju,iloscosob,cena) VALUES (?,?,?)";
        try{
            connection = DatabaseConnection.getCon();
            if(connection !=null) {
                roomGeneratorUserInput.readRoomGeneratorUserInput();
                room = roomGeneratorUserInput.getRoomUserInput();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_VALUE);
                preparedStatement.setString(1, room.getRoomName());
                preparedStatement.setInt(2, room.getRoomPersonCap());
                preparedStatement.setInt(3, room.getPrice());
                preparedStatement.executeUpdate();
                connection.close();
                System.out.println("Poprawnie dodano pokoj!");
                System.out.println(room);
            }
        } catch (SQLException throwables) {
            stackTracerFile.saveExceptionToFile(throwables);
            System.out.println("UPS cos poszlo nie tak ...");
        }
    }
}
