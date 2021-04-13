public class Reservation {
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
