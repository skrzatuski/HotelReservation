import java.sql.*;


public class Database extends DisplayMenu {
    final String url = "jdbc:mysql://localhost:3306/";
    final String dbName = "hotel";
    //String driver = "com.mysql.cj.jdbc.Driver";
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
    UserInput userInput = new UserInput();

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
        userInput.ReadData();
        CheckRoomAvailable checkroom = new CheckRoomAvailable();
        checkroom.CheckRoom(userInput.dateStart,userInput.dateStop,userInput.roomId);
        if(checkroom.roomStatus) {
            System.out.println("Nie można zarezerwować pokoju w tym okresie");
        }else {
            Reservation reservation = new Reservation(userInput.getName(), userInput.getSurname(), userInput.getRoomId(), userInput.getDateStart(), userInput.getDateStop());
        }
    }
    /*Delete reservation by ID*/
    void DeleteReservation(){
        DeleteReservation deleteReservation = new DeleteReservation();
        deleteReservation.DeleteReservation();
    }
}
