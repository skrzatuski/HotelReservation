import java.sql.*;

public class Database extends DisplayMenu {
    final String url = "jdbc:mysql://localhost:3306/";
    final String dbName = "hotel";
    String driver = "com.mysql.cj.jdbc.Driver";
    final String userName = "root";
    final String password = "";
    private Connection con = null;
    private Statement stt = null;
    private String column;
    private String sql;
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
    /*Showing all free rooms at the moment*/
    void ShowFreeRooms(){
        Room r1 = new Room();
        DisplayFreeRoomsMenu();
        try {
            con = DriverManager.getConnection(url + dbName, userName, password);
            stt = con.createStatement();
            sql = "SELECT * FROM pokoje";
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                r1.roomId = rs.getInt("idpokoju");
                r1.roomName = rs.getString("nazwapokoju");
                r1.roomPeopleCap = rs.getInt("iloscosob");
                r1.price = rs.getInt("cena");
                System.out.print(+r1.roomId+" ");
                System.out.print("Nazwa pokoju:"+r1.roomName+" ");
                System.out.print("Ilosc osob:"+r1.roomPeopleCap+" ");
                System.out.println("Cena:"+r1.price+" ");
            }
            rs.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
