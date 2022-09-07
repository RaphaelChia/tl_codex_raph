package codex.tl;

public class HotelRoom {
    private String roomName;

    IHotelRoomState available;
    IHotelRoomState occupied;
    IHotelRoomState repair;
    IHotelRoomState vacant;

    IHotelRoomState currentState;

    public HotelRoom(){
        this.available = new Available(this);
        this.occupied = new Occupied(this);
        this.repair = new Repair(this);
        this.vacant = new Vacant(this);

        this.currentState = this.available;
    }

}
