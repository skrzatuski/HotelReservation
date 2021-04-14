import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reservation extends Database {
    String name;
    String surname;
    int roomId;
    String dateStart;
    String dateStop;
    /*Reservation object*/
    public Reservation(String name, String surname, int roomId, String dateStart, String dateStop) {
        this.name = name;
        this.surname = surname;
        this.roomId = roomId;
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        try {
            con = DriverManager.getConnection(url + dbName, userName, password);
            String sql = "INSERT INTO rezerwacje (imie,nazwisko,idpokoju,dataod,datado) VALUES (?,?,?,?,?)";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, name);
            stt.setString(2, surname);
            stt.setString(3, String.valueOf(roomId));
            stt.setString(4, String.valueOf(dateStart));
            stt.setString(5, String.valueOf(dateStop));
            stt.executeUpdate();
            con.close();
            System.out.println("Poprawnie dodano rezerwacje!");
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getRoomId(){
        return roomId;
    }
    public String getDateStart(){
        return dateStart;
    }
    public String getDateStop(){
        return dateStop;
    }
}
