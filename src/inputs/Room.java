package inputs;

public class Room {
    private String roomName;
    private int roomPersonCap;
    private int price;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public int getRoomPersonCap() {
        return roomPersonCap;
    }

    public void setRoomPersonCap(int roomPersonCap) {
        this.roomPersonCap = roomPersonCap;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", roomPersonCap=" + roomPersonCap +
                ", price=" + price +
                '}';
    }
}
