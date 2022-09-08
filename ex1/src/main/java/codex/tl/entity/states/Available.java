package codex.tl.entity.states;

import codex.tl.HotelRoom;

public class Available implements IHotelRoomState{

    private final HotelRoom hotelRoom;

    public Available(HotelRoom hotelRoom){
        this.hotelRoom = hotelRoom;
    }
    @Override
    public void checkin() {
        hotelRoom.setCurrentState(hotelRoom.getOccupied());
        System.out.printf("You've got room %s!%n", hotelRoom.getRoomName());
        System.out.println("Checked in successfully! It is now occupied.");
    }

    @Override
    public void checkout() {
        System.out.println("Unable to check-out an available room.");
    }

    @Override
    public void clean() {
        System.out.println("Unable to clean an available room.");
    }

    @Override
    public void outOfService() {
        System.out.println("Unable to take an available room out of service");
    }

    @Override
    public void repaired() {
        System.out.println("Unable to repair an available room.");
    }
}
