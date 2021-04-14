import java.sql.*;
import java.util.Scanner;

public class Database extends DisplayMenu {
    final String url = "jdbc:mysql://localhost:3306/";
    final String dbName = "hotel";
    String driver = "com.mysql.cj.jdbc.Driver";
    final String userName = "root";
    final String password = "";
    public Connection con = null;
    public Statement stt = null;
    public String sql;
    private int resId;
    private String name;
    private String surname;
    private int roomId;
    private String dateStart;
    private String dateStop;


    /*Showing all reservation*/
    void ShowReservation() {
        DisplayReservationMenu();
        try {
            con = DriverManager.getConnection(url + dbName, userName, password);
            stt = con.createStatement();
            sql = "SELECT * FROM rezerwacje";
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                resId = rs.getInt("idzamowienia");
                name = rs.getString("imie");
                surname = rs.getString("nazwisko");
                roomId = rs.getInt("idpokoju");
                dateStart = rs.getString("dataod");
                dateStop = rs.getString("datado");
                System.out.print(resId +" ");
                System.out.print(name +" ");
                System.out.print(surname +" ");
                System.out.print(roomId +" ");
                System.out.print(dateStart +" ");
                System.out.println(dateStop);
            }
            rs.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /*Add new reservation*/
    void ExecuteReservation(){
        UserInput userInput = new UserInput();
        userInput.ReadData();
        CheckRoomAvailable checkroom = new CheckRoomAvailable();
        checkroom.CheckRoomAvailable(userInput.dateStart,userInput.dateStop,userInput.roomId);
        if(checkroom.roomStatus) {
            System.out.println("Nie można zarezerwować pokoju w tym okresie");
        }else {
            Reservation doReservation = new Reservation(userInput.getName(), userInput.getSurname(), userInput.getRoomId(), userInput.getDateStart(), userInput.getDateStop());
            try {
                con = DriverManager.getConnection(url + dbName, userName, password);
                String sql = "INSERT INTO rezerwacje (imie,nazwisko,idpokoju,dataod,datado) VALUES (?,?,?,?,?)";
                PreparedStatement stt = con.prepareStatement(sql);
                stt.setString(1, doReservation.getName());
                stt.setString(2, doReservation.getSurname());
                stt.setString(3, String.valueOf(doReservation.getRoomId()));
                stt.setString(4, String.valueOf(doReservation.getDateStart()));
                stt.setString(5, String.valueOf(doReservation.getDateStop()));
                stt.executeUpdate();
                con.close();
                System.out.println("Poprawnie dodano rezerwacje!");
            } catch (
                    SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    /*Showing all free rooms at the moment*/
    void ShowFreeRooms(){

        DisplayFreeRoomsMenu();
        Scanner s3 = new Scanner(System.in);
        dateStart = s3.next();
        dateStop=s3.next();
        try {
            con = DriverManager.getConnection(url + dbName, userName, password);
            stt = con.createStatement();
            sql = "SELECT 1 WHERE EXISTS " +
                    "(SELECT * FROM rezerwacje WHERE rezerwacje.idpokoju=1 AND " +
                    "(rezerwacje.dataod<="+"'"+dateStart+"'" + " AND rezerwacje.datado >="+"'"+dateStart+"'"+") OR " +
                    "(rezerwacje.dataod<="+"'"+dateStop+"'"+" AND rezerwacje.datado>="+"'"+dateStop+"'"+")"+ " OR " +
                    "(rezerwacje.dataod>="+"'"+dateStart+"'"+" AND rezerwacje.datado<="+"'"+dateStop+"'"+"))";

            ResultSet rs = stt.executeQuery(sql);
            if(rs.next()==true){
                System.out.println("Nie można zarezerwować pokoju w tym okresie");
            }else if (rs.next()==false)
            {
                System.out.println("Pokoj wolny");
            }

            rs.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
