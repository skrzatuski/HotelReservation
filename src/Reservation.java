public class Reservation {
    String name;
    String surname;
    int roomId;
    int dateStart;
    int dateStop;
    /*Reservation object*/
    public Reservation(String name, String surname, int roomId, int dateStart, int dateStop) {
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
    public int getDateStart(){
        return dateStart;
    }
    public int getDateStop(){
        return dateStop;
    }
}
