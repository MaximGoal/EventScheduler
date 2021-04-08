package schedulerProject.model.room;

public class Room {
    private int room_id;
    private String name;
    private String address;

    public Room(String name) {
        this.name = name;
    }

    public Room(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
