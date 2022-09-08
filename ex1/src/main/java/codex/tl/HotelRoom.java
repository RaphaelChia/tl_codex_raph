package codex.tl;

import codex.tl.states.*;

/**
 * This class is created with the state design pattern.
 * The 4 states are Available, Occupied, Repair, Vacant.
 * The 5 Actions are Checkin, checkout, clean, take out of service, repair.
 */

public class HotelRoom {

    private String roomName;

    private final IHotelRoomState available;
    private final IHotelRoomState occupied;
    private final IHotelRoomState repair;
    private final IHotelRoomState vacant;

    private IHotelRoomState currentState;

    public HotelRoom(String roomName){
        this.available = new Available(this);
        this.occupied = new Occupied(this);
        this.repair = new Repair(this);
        this.vacant = new Vacant(this);

        this.currentState = this.available;

        this.roomName = roomName;
    }

    public IHotelRoomState getAvailable() {
        return available;
    }

    public IHotelRoomState getOccupied() {
        return occupied;
    }

    public IHotelRoomState getRepair() {
        return repair;
    }

    public IHotelRoomState getVacant() {
        return vacant;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public IHotelRoomState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IHotelRoomState currentState) {
        this.currentState = currentState;
    }
}
