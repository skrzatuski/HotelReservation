package inputs;

public class Reservation {
    private int reservationId;
    private String name;
    private String surname;
    private int roomId;
    private String dateStart;
    private String dateStop;
    public int getReservationId(){
        return reservationId;
    }
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public String getDateStart() {
        return dateStart;
    }
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }
    public String getDateStop() {
        return dateStop;
    }
    public void setDateStop(String dateStop) {
        this.dateStop = dateStop;
    }
}
